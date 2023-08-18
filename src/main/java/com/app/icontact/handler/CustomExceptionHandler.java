package com.app.icontact.handler;


import com.app.icontact.exception.LoginFailedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(LoginFailedException.class)
    protected RedirectView handleLoginFailedException(LoginFailedException loginFailedException, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("login", "false");
        return new RedirectView("/member/login");
    }

}
