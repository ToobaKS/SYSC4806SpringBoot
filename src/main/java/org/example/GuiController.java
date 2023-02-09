package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuiController {

    @GetMapping("/addressbook")
    public String addressBook(@RequestParam(name="name", required=false, defaultValue="John") String name,
                           @RequestParam(name="address", required=false, defaultValue="World") String address,
                           @RequestParam(name="phone", required=false, defaultValue="World") String phone,
                           Model model) {
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("phone", phone);

        return "addressbook";
    }

}