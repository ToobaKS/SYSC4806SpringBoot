package org.example;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/addressBook")
    public AddressBook getAddressBook(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        AddressBook buddies = this.addressBookRepository.findById(id);
        return buddies;
    }

    @PostMapping("/createaddressbook")
    public AddressBook addressBook() {
        AddressBook buddies = new AddressBook(counter.incrementAndGet());
        addressBookRepository.save(buddies);
        return buddies;
    }

    @PostMapping("/addbuddy")
    public AddressBook addBuddy(@RequestParam(value = "id", defaultValue = "1") long id, @RequestParam(value = "name", defaultValue = "John") String name, @RequestParam(value = "address", defaultValue = "Canada") String address, @RequestParam(value = "phone", defaultValue = "613") String phone) {
        BuddyInfo buddy = new BuddyInfo(name, address, phone);
        AddressBook ab = addressBookRepository.findById(id);
        ab.addBuddy(buddy);
        addressBookRepository.save(ab);
        return ab;
    }

    @DeleteMapping("/removebuddy")
    public AddressBook removeBuddy(@RequestParam(value = "id") long id, @RequestParam(value = "name") String name, @RequestParam(value = "address") String address, @RequestParam(value = "phone") String phone) {
        BuddyInfo buddy = new BuddyInfo(name, address, phone);
        AddressBook ab = addressBookRepository.findById(id);
        ab.removeBuddy(buddy);
        addressBookRepository.save(ab);
        return ab;
    }
}
