package vttp.paf.day23.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import vttp.paf.day23.model.Contact;
import vttp.paf.day23.services.ContactService;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactSvc;

    @GetMapping("")
    public ModelAndView displayForm() {
        final ModelAndView mav = new ModelAndView("index.html");
        List<Contact> contacts = contactSvc.getAllContacts();

        mav.addObject("contacts", contacts);
        return mav;
    }
    
    @PostMapping(path="/postContact")
    public ModelAndView postContact(@RequestBody MultiValueMap<String, String> form) {
        
        final ModelAndView mav = new ModelAndView("index.html");

        // check if email exists
        if(contactSvc.contactExists(form.getFirst("email"))) {
            mav.addObject("statusMsg", "Contact exists!");
            mav.setStatus(HttpStatus.BAD_REQUEST);
            mav.addObject("statusCode", 400);
        } else {
            boolean result = contactSvc.addContact(Contact.create(form));
            if(result) {
                System.out.println(">>> Contact added");
                mav.addObject("statusMsg", "Added successfully");
                mav.setStatus(HttpStatus.CREATED);
                mav.addObject("statusCode", 200);
            } else {
                System.out.println(">>> Error");
                mav.addObject("statusMsg", "Error!");
                mav.addObject("statusCode", 400);
            }
        }

        mav.addObject("contacts", contactSvc.getAllContacts());

        return mav;
    }
}
