package com.ganesh.spring.tx;

import com.ganesh.spring.tx.dao.impl.ExtractUnitDaoImpl;
import com.ganesh.spring.tx.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ganesh on 1/20/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class DaoTestImpl {

    @Autowired
    ExtractUnitDaoImpl extractUnitDaoImpl;


    @Transactional
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {

        User user = new User();
        user.setUsername("jaffa1");
        user.setName("jaffa1");

        User user1 = new User();
        user1.setUsername("jaffa2");
        user1.setName("jaffa2");

        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user1);

        extractUnitDaoImpl.insertBatchExtractUnits(users);
        List<User> result = extractUnitDaoImpl.readExtractUnits();

        result.get(0).getName().equalsIgnoreCase("jaffa1");
        result.get(1).getName().equalsIgnoreCase("jaffa2");

    }

}
