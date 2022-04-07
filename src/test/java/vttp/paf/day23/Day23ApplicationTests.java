package vttp.paf.day23;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vttp.paf.day23.model.Contact;
import vttp.paf.day23.services.ContactService;

@SpringBootTest
class Day23ApplicationTests {

    @Autowired
    private ContactService contactService;

    @Test
    void shouldAddDummyRecord(){
        Contact c = new Contact();

        c.setEmail("dummy@gmail.com");
        c.setName("dummy");
        c.setDob(new java.sql.Date(new java.util.Date().getTime()));
        c.setPhone("123456");
        c.setPassphrase("HELLO");
        c.setStatus("friend");

        boolean result = contactService.addContact(c);
        System.out.println(">>> Added result: " + result);
        assertTrue(result);

        result = contactService.removeContact(c);
        System.out.println(">>> Removed result: " + result);
        assertTrue(result);
    }
}
