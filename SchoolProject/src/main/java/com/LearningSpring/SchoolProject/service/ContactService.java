package com.LearningSpring.SchoolProject.service;

import com.LearningSpring.SchoolProject.constants.NewAgeSchoolConstants;
import com.LearningSpring.SchoolProject.model.Contact;
import com.LearningSpring.SchoolProject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
        boolean isSaved = false;
        contact.setStatus(NewAgeSchoolConstants.OPEN);
        contact.setCreatedBy(NewAgeSchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());

        Contact savedContact = contactRepository.save(contact);
        if (savedContact.getContactID() > 0)
            isSaved = true;
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus() {
        List<Contact> contactMsgs = contactRepository.findByStatus(NewAgeSchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactID, String updatedBy) {
        boolean isUpdated = false;
        Optional<Contact> contactOptional = contactRepository.findById(contactID);
        contactOptional.ifPresent(
                contact -> {
                    contact.setUpdatedAt(LocalDateTime.now());
                    contact.setUpdatedBy(updatedBy);
                    contact.setStatus(NewAgeSchoolConstants.CLOSE);
                });
        if(contactOptional.isPresent()) {
            Contact updatedContact = contactRepository.save(contactOptional.get());
            isUpdated = true;
        }
        return isUpdated;
    }
}
