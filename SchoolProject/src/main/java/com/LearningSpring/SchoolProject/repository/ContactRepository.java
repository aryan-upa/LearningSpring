package com.LearningSpring.SchoolProject.repository;

import com.LearningSpring.SchoolProject.model.Contact;
import com.LearningSpring.SchoolProject.rowMappers.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    public int updateMsgStatus(int contactID, String close, String updatedBy) {
        String sql = "update contact_msg set status = ?, updated_by = ?, updated_at = ? where contact_id = ?";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, close);
                ps.setString(2, updatedBy);
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(4, contactID);
            }
        });
    }
}
