package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressBookId = null;

    public AddressBook() {
        buddies = new ArrayList<>();
    }

    public AddressBook(long addressBookId) {
        this.addressBookId = addressBookId;
        buddies = new ArrayList<>();
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public Long getAddressBookId() {
        return addressBookId;
    }

    public void setAddressBookId(Long addressBookId) {
        this.addressBookId = addressBookId;
    }

    public boolean removeBuddy(BuddyInfo buddy) {
        return buddies.remove(buddy);
    }

    public boolean addBuddy(BuddyInfo buddy) {
        if(buddy != null){
            return buddies.add(buddy);
        }
        return false;
    }

    public String toString(){
        String out = "";
        for(BuddyInfo b : buddies){
            out += b.toString() + "\n";
        }
        return out;
    }
}
