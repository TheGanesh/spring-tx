package com.ganesh.spring.tx.dao.impl;

import com.ganesh.spring.tx.dao.ExtractUnitDao;
import com.ganesh.spring.tx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Ganesh on 1/18/15.
 */

@Repository
public class ExtractUnitDaoImpl implements ExtractUnitDao {

    @Autowired
    DataSource dataSource;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public void insertBatchExtractUnits(List<User> users) {

        String sql = "INSERT INTO USER (ID, USERNAME, NAME) VALUES (:id, :username, :name)";

        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(users.toArray());

        getJdbcTemplate().batchUpdate(sql, params);

    }

    @Override
    public List<User> readExtractUnits() {
        //String sql = "SELECT * FROM USER where ID = :id";
        String sql = "SELECT * FROM USER";
        User user = new User();
        user.setId(16);

        List<User> users = getJdbcTemplate().query(sql, new BeanPropertySqlParameterSource(user),new BeanPropertyRowMapper<User>(User.class));

        return users;
    }


    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
