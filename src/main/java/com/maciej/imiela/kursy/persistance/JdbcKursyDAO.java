/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.kursy.persistance;

import com.maciej.imiela.kursy.domain.Course;
import com.maciej.imiela.kursy.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 *
 * @author Maciej
 */
public class JdbcKursyDAO implements KursyDAO {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private static final String SQL_INSERT_USER = "INSERT INTO \"DaneLogowania\" (id, login, haslo, zweryfikowany) VALUES (:id, :user, :password, :ver);";
    private static final String SQL_SELECT_USER = "SELECT * FROM \"DaneLogowania\" WHERE id = :id;";
    private static final String SQL_SELECT_ALL_USER = "SELECT * FROM \"DaneLogowania\";";
    private static final String SQL_SELECT_ALL_COURSES = "SELECT * FROM \"TypKursu\";";

    @Override
    public void addUser(User u) {
        Map param = new HashMap();
        param.put("id", u.getId());
        param.put("user", u.getUsername());
        param.put("password", u.getPassword());
        param.put("ver", u.isVerified());
        jdbcTemplate.update(SQL_INSERT_USER, param);
    }

    @Override
    public User getUserByID(long id) {
        SqlParameterSource param = new MapSqlParameterSource("id", Long.valueOf(id));
        return jdbcTemplate.queryForObject(SQL_SELECT_USER, param, new ParameterizedRowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User u = new User();
                u.setId(rs.getLong(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setVerified(Boolean.parseBoolean(rs.getString(4)));
                return u;
            }
        });
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USER, new HashMap<String, String>(), new ParameterizedRowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User u = new User();
                u.setId(rs.getLong(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setVerified(Boolean.parseBoolean(rs.getString(4)));
                return u;
            }
        });
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = this.jdbcTemplate.query(SQL_SELECT_ALL_COURSES, new HashMap<String, String>(), new ParameterizedRowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int i) throws SQLException {
                Course c = new Course();
                c.setName(rs.getString("nazwa"));
                c.setMaxNumber(rs.getInt("liczba"));
                c.setDescription(rs.getString("opis"));
                return c;
            }
        });
        return courses;
    }
}
