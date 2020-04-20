package com.cart.controller;
 
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cart.custexception.CustomExceptionHandler;
import com.cart.dto.Txnrecord;
import com.cart.dto.Txnunit;
import com.cart.dto.User;
import com.cart.service.ProductsService;
import com.cart.service.TxnrecordService;
import com.cart.service.TxnunitService;
import com.cart.service.UserService;


@Controller
@RequestMapping("/cart")
public class AppController {
 
@Autowired
private UserService userService;

@Autowired
private ProductsService productsService;

@Autowired
private TxnrecordService txnrecordService;

@Autowired
private TxnunitService txnunitService;

@GetMapping("/login")
public String loadLogin(Model model) throws Exception {
	User user = new User();
	try {
		model.addAttribute("user", user);
	} catch(Exception ex) {
		throw new CustomExceptionHandler(ex);
	}
    return "loginpage";
}

@PostMapping("/loginaction")
public ModelAndView adminLoginAction(@ModelAttribute("user") User user, HttpServletRequest req, BindingResult result) {
	HttpSession session=req.getSession();
	ModelAndView modelAndView = null;
	Object productDetails = null;
	try {
		User getUserRec = userService.getByUserId(user.getUserid());
		
	    if(null!=getUserRec && null!=user.getPassword() && user.getPassword().equals(getUserRec.getPassword())) {
	    	session.setAttribute("user", getUserRec);
	    	modelAndView = new ModelAndView("/dashboard");
	    	productDetails = productsService.getAllProdRec();
	    	modelAndView.addObject("productDetails", productDetails);
	    }else {
	        ObjectError error = new ObjectError("username","Entered username or password is wrong !!");
	        result.addError(error);
	        modelAndView = new ModelAndView("/loginpage");
	        modelAndView.addAllObjects(result.getModel());
	    }
	}catch(Exception ex) {
		throw new CustomExceptionHandler(ex);
	} finally {
		System.out.println("loginaction complete.");
	}
    return modelAndView;
}

@GetMapping("/dashboard")
public ModelAndView showAdmindashboard(@ModelAttribute("user") User user, HttpServletRequest req)  {
	HttpSession session=req.getSession();
	ModelAndView mav =null;
	if(null!=session && null!=session.getAttribute("user")) {
		 mav= new ModelAndView("/dashboard");
		 mav.addObject(user.getUserid(), user);
	}else {
		mav= new ModelAndView("/loginpage");
	}
	return mav;
}

@PostMapping("/buyproduct")
public ResponseEntity<?> buyproduct(HttpServletRequest req, 
		@RequestParam(name = "itemcode") String itemCode, 
		@RequestParam(name = "quantity") String quantity,
		@RequestParam(name = "price") String price) {
	HttpSession session=req.getSession();
	User user=(User) session.getAttribute("user");
	HttpStatus httpStatus = null;
	Txnrecord recorddata = new Txnrecord();
	String response = null;
	try {
		System.out.println(itemCode+":"+quantity+":"+price);
		Txnunit txnunit = new Txnunit();
		txnunit = verifyAvailability(Integer.parseInt(itemCode));
		if(txnunit.getCurrunit()>0) {
			int restunit = txnunit.getCurrunit()-Integer.parseInt(quantity);
			txnunit.setCurrunit(restunit);
			txnunitService.save(txnunit); // Update available unit
			recorddata.setBuyoutdt(new Date());
			recorddata.setAmount(Integer.parseInt(price));
			recorddata.setItemid(Integer.parseInt(itemCode));
			recorddata.setUnitpurch(Integer.parseInt(quantity));
			recorddata.setPurchby(user.getUserid());
			txnrecordService.save(recorddata); // Update transaction data
			httpStatus = httpStatus.OK;
			response = "item: laptop, status: success, reason: booked";
		} else {
			httpStatus = httpStatus.OK;
			response = "item: laptop, status: fail, reason: unit not available";
		}
	} catch(Exception ex) {
		throw new CustomExceptionHandler(ex);
	} finally {
		System.out.println("buyproduct complete.");
	}
	return new ResponseEntity<>(response,httpStatus); 
}


public Txnunit verifyAvailability(int intemCode) {
	Txnunit txnunit = new Txnunit();
	try {
		txnunit =  txnunitService.getByItemid(intemCode);
		System.out.println("item count:=>"+txnunit.getItemid());
	} catch(Exception ex) {
		throw new CustomExceptionHandler(ex);
	}
	return txnunit;
}

@GetMapping("/logout")
public String logoutAdmin(Model model, HttpServletRequest req)  {
     HttpSession session=req.getSession();
 	if(null!=session) { 
 		session.invalidate();
 	}
 	 return "redirect:/cart/login";
}


}