package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingAddressBook {

    private static final Logger log = LoggerFactory.getLogger(AccessingAddressBook.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingAddressBook.class);
    }

    @Bean
   public CommandLineRunner demo2(AddressBookRepository repository) {
        return (args) -> {

            //Create new AddressBooks
            AddressBook a1 = new AddressBook(1);
            a1.addBuddy(new BuddyInfo("Jack", "Kanata", "21"));
            a1.addBuddy(new BuddyInfo("Chloe", "Ottawa", "22"));
            a1.addBuddy(new BuddyInfo("Kim", "Quebec", "23"));
            a1.addBuddy(new BuddyInfo("David", "Gatineau", "24"));
            a1.addBuddy(new BuddyInfo("Michelle", "Toronto", "25"));

            AddressBook a2 = new AddressBook(2);
            a2.addBuddy(new BuddyInfo("Jack", "Kanata", "21"));
            a2.addBuddy(new BuddyInfo("Chloe", "Ottawa", "22"));
            a2.addBuddy(new BuddyInfo("Kim", "Quebec", "23"));
            a2.addBuddy(new BuddyInfo("David", "Gatineau", "24"));
            a2.addBuddy(new BuddyInfo("Michelle", "Toronto", "25"));

            AddressBook a3 = new AddressBook(3);
            a3.addBuddy(new BuddyInfo("Jack", "Kanata", "21"));
            a3.addBuddy(new BuddyInfo("Chloe", "Ottawa", "22"));
            a3.addBuddy(new BuddyInfo("Kim", "Quebec", "23"));
            a3.addBuddy(new BuddyInfo("David", "Gatineau", "24"));
            a3.addBuddy(new BuddyInfo("Michelle", "Toronto", "25"));

            AddressBook a4 = new AddressBook(4);
            a4.addBuddy(new BuddyInfo("Jack", "Kanata", "21"));
            a4.addBuddy(new BuddyInfo("Chloe", "Ottawa", "22"));
            a4.addBuddy(new BuddyInfo("Kim", "Quebec", "23"));
            a4.addBuddy(new BuddyInfo("David", "Gatineau", "24"));
            a4.addBuddy(new BuddyInfo("Michelle", "Toronto", "25"));

            // save the address books
            repository.save(a1);
            repository.save(a2);
            repository.save(a3);
            repository.save(a4);

            // fetch all Address Books
            log.info("Address found with findAll():");
            log.info("-------------------------------");
            for (AddressBook buddies : repository.findAll()) {
                log.info(buddies.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            AddressBook buddies = repository.findById(1L);
            log.info("Buddy found with findById(1L):");
            log.info("--------------------------------");
            log.info(buddies.toString());
            log.info("");
       };
    }
}
