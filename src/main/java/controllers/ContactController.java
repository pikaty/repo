package controllers;

import domain.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ContactService;

import java.util.List;

@Controller
public class ContactController {
    final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @RequestMapping(value="list")
    public String list(Model uiModel){
        logger.info("Listing contacts");

        List<Contact> contacts = contactService.findAll();
        uiModel.addAttribute("contacts", contacts);

        logger.info("No. of contacts: " + contacts.size());

        return "contacts/list";
    }
}
