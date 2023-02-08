package org.example;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    private AddressBook buddies;
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/addressbook")
    public AddressBook addressBook() {
        buddies = new AddressBook(counter.incrementAndGet());
        addressBookRepository.save(buddies);
        return buddies;
    }

    @GetMapping("/addbuddy")
    public boolean addBuddy(@RequestParam(value = "id") long id, @RequestParam(value = "name") String name, @RequestParam(value = "address") String address, @RequestParam(value = "phone") String phone) {
        BuddyInfo buddy = new BuddyInfo(name, address, phone);
        return addressBookRepository.findById(id).addBuddy(buddy);
    }

    @GetMapping("/removebuddy")
    public boolean removeBuddy(@RequestParam(value = "id") long id, @RequestParam(value = "name") String name, @RequestParam(value = "address") String address, @RequestParam(value = "phone") String phone) {
        BuddyInfo buddy = new BuddyInfo(name, address, phone);
        return addressBookRepository.findById(id).addBuddy(buddy);
    }
}
