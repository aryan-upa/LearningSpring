package com.LearningSpring.SchoolProject.security;

import com.LearningSpring.SchoolProject.model.Person;
import com.LearningSpring.SchoolProject.model.Roles;
import com.LearningSpring.SchoolProject.repository.PersonRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewAgeSchoolAuthenticationProvider implements AuthenticationProvider {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    public NewAgeSchoolAuthenticationProvider(PersonRepository personRepository,
                                              PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Person person = personRepository.readByEmail(username);
        if (person == null)
            throw new BadCredentialsException("user does not exist.");
        if (person.getPersonId() < 0)
            throw new BadCredentialsException("Invalid User");
        if(!passwordEncoder.matches(pwd, person.getPwd()))
            throw new BadCredentialsException("Invalid UserID or Password!");
        return new UsernamePasswordAuthenticationToken(
                person.getName(), null, getGrantedAuthorities(person.getRoles())
        );
    }

    private List<GrantedAuthority> getGrantedAuthorities(Roles roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + roles.getRoleName()));
        return authorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
