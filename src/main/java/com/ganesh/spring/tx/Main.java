package com.ganesh.spring.tx;

import com.ganesh.spring.tx.dao.ExtractUnitDao;
import com.ganesh.spring.tx.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//        OuterBean testBean = (OuterBean) ctx.getBean("outerBeanImpl");
//
//        User user = new User();
//        user.setUsername("johndoe");
//        user.setName("John Doe");

        //testBean.testRequired(user);
        //testBean.testRequiresNew(user);

        ExtractUnitDao extractUnitDao =  (ExtractUnitDao) ctx.getBean("extractUnitDaoImpl");

        User user = new User();
        user.setUsername("jaffa1");
        user.setName("jaffa1");

        User user1 = new User();
        user1.setUsername("jaffa2");
        user1.setName("jaffa2");

        User user2 = new User();
        user2.setUsername("jaffa3");
        user2.setName("jaffa3");

        User user3 = new User();
        user3.setUsername("jaffa4");
        user3.setName("jaffa4");


        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        extractUnitDao.insertBatchExtractUnits(users);
        users = extractUnitDao.readExtractUnits();

        for(User x:users){
            System.out.println(x.getName());
        }

    }
}
