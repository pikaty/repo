package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CRegistration {


    @RequestMapping(value = "/*reg*" , method = RequestMethod.POST)
    public String reg(@RequestParam String username, @RequestParam String password, Model model){
        model.addAttribute("username" , username);
        model.addAttribute("password" , password);
        return "hello";
    }
}
