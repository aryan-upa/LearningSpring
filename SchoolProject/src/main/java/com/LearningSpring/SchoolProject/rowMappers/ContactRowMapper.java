package com.LearningSpring.SchoolProject.rowMappers;

import com.LearningSpring.SchoolProject.model.Contact;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setContactID(resultSet.getInt("contact_id"));
        contact.setName(resultSet.getString("name"));
        contact.setMobileNum(resultSet.getString("mobile_num"));
        contact.setEmail(resultSet.getString("email"));
        contact.setSubject(resultSet.getString("subject"));
        contact.setMessage(resultSet.getString("message"));
        contact.setStatus(resultSet.getString("status"));
        contact.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        contact.setCreatedBy(resultSet.getString("created_by"));

        if (null != resultSet.getTimestamp("updated_at")) {
            contact.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
            contact.setUpdatedBy(resultSet.getString("updated_by"));
        }
        return contact;
    }

}
