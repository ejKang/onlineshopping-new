package net.ejkang.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerNoHandlerFoundException() {
        ModelAndView mv = new ModelAndView("error");

        mv.addObject("title", "404 Error Page");
        mv.addObject("errorTitle", "This page is not constructed !");
        mv.addObject("errorDescription", "The page you are looking for is not available now ! ");

        return mv;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handlerProductNotFoundException() {
        ModelAndView mv = new ModelAndView("error");

        mv.addObject("title", "Product Error Page");
        mv.addObject("errorTitle", "This product is not constructed !");
        mv.addObject("errorDescription", "The product you are looking for is not available now ! ");

        return mv;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException() {
        ModelAndView mv = new ModelAndView("error");

        mv.addObject("title", "Error Page");
        mv.addObject("errorTitle", "This is not constructed !");
        mv.addObject("errorDescription", "The Page you are looking for is not available now ! ");

        return mv;
    }
}