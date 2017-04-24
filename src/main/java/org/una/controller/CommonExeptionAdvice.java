package org.una.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExeptionAdvice {

	
	private static final Logger logger = LoggerFactory.getLogger(CommonExeptionAdvice.class);
	
	@ExceptionHandler
	private ModelAndView errorModelAndView(Exception e)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception",e);
		
		return modelAndView;
	}
}
