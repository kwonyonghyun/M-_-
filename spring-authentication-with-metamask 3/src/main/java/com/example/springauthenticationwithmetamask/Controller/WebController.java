package com.example.springauthenticationwithmetamask.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/")
    public String root(HttpServletRequest request) {
        HttpSession session=request.getSession();
        System.out.println("root: "+ SessionClass.getUsernameFromSession(session));
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
