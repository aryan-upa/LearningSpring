package com.LearningSpring.SchoolProject.repository;

import com.LearningSpring.SchoolProject.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday, String> {

//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public HolidayRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Holiday> getAllHolidays() {
//        String sql = "select * from holidays";
//        var rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
//        return jdbcTemplate.query(sql, rowMapper);
//    }
}
