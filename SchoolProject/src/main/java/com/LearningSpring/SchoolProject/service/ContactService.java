package com.LearningSpring.SchoolProject.service;

import com.LearningSpring.SchoolProject.model.Contact;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ContactService {

    private final Logger log = Logger.getLogger(ContactService.class.getName());

    /**
     * Method to save the contact form fields in the contact page.
     * @param contact This is a contact class object.
     * @return boolean Returns whether the data was saved or not.
     */
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        // TODO: Save the contact details in the DB.
        log.info(contact.toString());
        return isSaved;
    }

}
