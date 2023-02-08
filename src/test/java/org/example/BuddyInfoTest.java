package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    String name = "Tooba";
    String address = "Canada";
    String phoneNumber = "1";
    BuddyInfo buddy = new BuddyInfo(name,address,phoneNumber);


    @Test
    public void getName() {
        assertEquals(name, buddy.getName());
    }

    @Test
    public void getAddress() {
        assertEquals(address, buddy.getAddress());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals(phoneNumber, buddy.getPhoneNumber());
    }

    @Test
    public void main() {
    }
}