package com.LearningSpring.SchoolProject.service;

import com.LearningSpring.SchoolProject.constants.NewAgeSchoolConstants;
import com.LearningSpring.SchoolProject.model.Person;
import com.LearningSpring.SchoolProject.model.Roles;
import com.LearningSpring.SchoolProject.repository.PersonRepository;
import com.LearningSpring.SchoolProject.repository.RolesRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final RolesRepository rolesRepository;

    public PersonService(PersonRepository personRepository, RolesRepository rolesRepository) {
        this.personRepository = personRepository;
        this.rolesRepository = rolesRepository;
    }

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;

        Roles role = rolesRepository.getByRoleName(NewAgeSchoolConstants.STUDENT_ROLE);
        person.setRoles(role);

        person = personRepository.save(person);
        if(person.getPersonId() > 0)
            isSaved = true;
        return isSaved;
    }
}
