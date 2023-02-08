package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressBookTest {

    BuddyInfo buddy1 = new BuddyInfo("Tooba","Canada","1");

    AddressBook buddies = new AddressBook(1);

    @org.junit.Test
    public void removeBuddy() {
        buddies.addBuddy(buddy1);
        assertTrue(buddies.removeBuddy(buddy1));
    }

    @org.junit.Test
    public void addBuddy() {
        assertTrue(buddies.addBuddy(buddy1));
    }

}