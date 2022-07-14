package com.LearningSpring.SchoolProject.repository;

import com.LearningSpring.SchoolProject.model.Contact;
import com.LearningSpring.SchoolProject.rowMappers.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    public int saveContactMsg(Contact contact) {
        String sql = "INSERT INTO CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS," +
                "CREATED_AT,CREATED_BY) VALUES(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(
                sql,
                contact.getName(),
                contact.getMobileNum(),
                contact.getEmail(),
                contact.getSubject(),
                contact.getMessage(),
                contact.getStatus(),
                contact.getCreatedAt(),
                contact.getCreatedBy());
    }

    public List<Contact> findMsgsWithStatus(String status) {
        String sql = "select * from contact_msg where status = ?";
        return jdbcTemplate.query(sql, (PreparedStatementSetter) ps -> ps.setString(1, status), new ContactRowMapper());
    }
}
