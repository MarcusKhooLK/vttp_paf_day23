package vttp.paf.day23.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.paf.day23.model.Contact;
import vttp.paf.day23.repositories.ContactRepository;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository contactRepo;

    public boolean addContact(Contact c) {
        return contactRepo.addContact(c);
    }

    public boolean contactExists(String email) {
        return contactRepo.contactExists(email);
    }

    public List<Contact> getAllContacts() {
        return contactRepo.getAllContacts();
    }

    public boolean removeContact(Contact c) {
        return contactRepo.removeContact(c);
    }
}
