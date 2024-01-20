package com.example.springauthenticationwithmetamask.Controller;


import com.example.springauthenticationwithmetamask.Entity.TockenCreatLog;
import com.example.springauthenticationwithmetamask.Service.TockenService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TockedController {

    private final TockenService tockenService;

    @PostMapping("/tocken-add")
    public String tockenAdd(@RequestParam("tokenAmount") Long tokenAmount, Model model, HttpServletRequest request){
        // Process the tokenAmount here and add attributes to the model if necessary
        TockenCreatLog tockenCreatLog=TockenCreatLog.builder()
                .numOfTocken(tokenAmount/8)
                .duration(tokenAmount)
                        .userId(SessionClass.getUsernameFromSession(request.getSession()))
                                .build();
        System.out.println(tockenCreatLog.toString());
        tockenService.save(tockenCreatLog);
        return "redirect:/log";
    }


    @GetMapping("/log")
    public String tockenList(Model model){
        model.addAttribute("tockenList",tockenService.getAll());
        return "log";
    }
}
