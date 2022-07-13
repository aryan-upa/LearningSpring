package com.LearningSpring.SchoolProject.service;

import com.LearningSpring.SchoolProject.constants.NewAgeSchoolConstants;
import com.LearningSpring.SchoolProject.model.Contact;
import com.LearningSpring.SchoolProject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    private final Logger log = Logger.getLogger(ContactService.class.getName());

    /**
     * Method to save the contact form fields in the contact page.
     * @param contact This is a contact class object.
     * @return boolean Returns whether the data was saved or not.
     */
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        contact.setStatus(NewAgeSchoolConstants.OPEN);
        contact.setCreatedBy(NewAgeSchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());

        int result = contactRepository.saveContactMsg(contact);
        isSaved = result > 0;
        return isSaved;
    }

}
