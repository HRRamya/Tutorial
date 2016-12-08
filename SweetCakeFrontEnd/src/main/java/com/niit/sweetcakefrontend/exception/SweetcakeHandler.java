package com.niit.sweetcakefrontend.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SweetcakeHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(SweetcakeHandler.class);
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request, Exception e)
	{
		logger.error("SQLException Occured::URL="+request.getRequestURL());
		logger.error("SQLException Occured::Exception="+e.getMessage());
		
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("message", "It seems one of the table or few fields does not exist in DB.");
		mv.addObject("errorMessage", e.getMessage());
	return mv;
	}
	
	

}
