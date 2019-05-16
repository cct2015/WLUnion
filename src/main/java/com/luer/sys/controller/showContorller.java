package com.luer.sys.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value = "/sysother")
public class showContorller {
    @RequestMapping(value = "/show")
    public String showQuestion(String id, Model model){
        model.addAttribute("Myid",id);
        return "/templates/sys/showQuestion";
    }
}
