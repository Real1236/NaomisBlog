package com.arthur.blog.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.juli.logging.LogFactory;
import org.apache.juli.logging.Log;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    private final Log logger = LogFactory.getLog(ExceptionController.class);

    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest request, Exception exc, Model model) {
        logger.error("Request " + request.getRequestURL() + " Threw an Exception", exc);
        model.addAttribute("exception", exc.getMessage());
        return "error";
    }

}
