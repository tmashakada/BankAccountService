/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz.bankaccountservice.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 *
 * @author tmashakada email:tmashakada10@gmail.com
 */
@Component
public class RESTAuthenticationEntryPoint implements AuthenticationEntryPoint{
    
        @Autowired
        @Qualifier("handlerExceptionResolver")
         private HandlerExceptionResolver resolver;
        @Override
        public void commence(HttpServletRequest hsr, HttpServletResponse hsr1, AuthenticationException ae) throws IOException, ServletException {
         
         
          resolver.resolveException(hsr, hsr1, null, ae);
         
         
    }
}
