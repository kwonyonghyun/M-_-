package com.example.springauthenticationwithmetamask.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Enumeration;

public class SessionClass {
    public  static String sessionToString(HttpSession session) {
        StringBuilder sessionDetails = new StringBuilder();
        sessionDetails.append("Session ID: ").append(session.getId()).append("\n");

        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            sessionDetails.append("Attribute Name: ").append(attributeName)
                    .append(", Value: ").append(session.getAttribute(attributeName))
                    .append("\n");
        }
        return sessionDetails.toString();
    }

    public static String getUsernameFromSession(HttpSession session) {
        Object securityContext = session.getAttribute("SPRING_SECURITY_CONTEXT");
        if (securityContext instanceof SecurityContextImpl) {
            Authentication authentication = ((SecurityContextImpl) securityContext).getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                return userDetails.getUsername();
            }
        }
        return null;
    }

}
