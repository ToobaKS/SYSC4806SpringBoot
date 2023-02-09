package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody String addressBook() {
        AddressBook ab = new AddressBook();
        BuddyInfo a = new BuddyInfo("Tooba", "Kanata", "613");
        BuddyInfo b = new BuddyInfo("Tooba", "Kanata", "613");
        BuddyInfo c = new BuddyInfo("Tooba", "Kanata", "613");

        ab.addBuddy(a);
        ab.addBuddy(b);
        ab.addBuddy(c);

        return ab.toString();

    }

}
