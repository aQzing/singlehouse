package com.qzing.singlehouse.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * 页面异常处理
 * @author Qzing
 *
 */
@ControllerAdvice
public class ErrorHandler {
	private static final Logger logger = LoggerFactory.getLogger(Error.class);

	@ExceptionHandler(value= {Exception.class,RuntimeException.class})
	public String error500(HttpServletRequest request,Exception e) {
		logger.error(e.getMessage(),e);
		logger.error(request.getRequestURL()+"->entern 500");
		return "error/500";
	}
}
