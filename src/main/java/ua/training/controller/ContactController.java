package ua.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.training.model.Contact;
import ua.training.service.ContactService;

@RequestMapping("/contacts")
@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public String showContactList(Model model) {
        model.addAttribute("contacts", contactService.findAllContacts());
        return "contact-list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showContact(@PathVariable Long id, Model uiModel) {
        Contact contact = contactService.findById(id);
        uiModel.addAttribute("contact", contact);
        return "single-contact";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveNewContact(@RequestParam("first_name") String firstName,
                                 @RequestParam("last_name") String lastName,
                                 Model model) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contactService.save(contact);
        return "redirect:contacts";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteContact(@PathVariable Long id, Model model) {
        contactService.deleteContact(id);
        model.addAttribute("contacts", contactService.findAllContacts());
        return "redirect:../../contacts";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String updateContactData(@PathVariable Long id,
                                    @RequestParam("first_name") String firstName,
                                    @RequestParam("last_name") String lastName) {
        Contact contact = contactService.findById(id);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contactService.save(contact);
        return "redirect:../../contacts";
    }
}
