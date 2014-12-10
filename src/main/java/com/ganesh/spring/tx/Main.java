package com.ganesh.spring.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ganesh.spring.tx.model.User;
import com.ganesh.spring.tx.test.OuterBean;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        OuterBean testBean = (OuterBean) ctx.getBean("outerBeanImpl");

        User user = new User();
        user.setUsername("johndoe");
        user.setName("John Doe");

        //testBean.testRequired(user);


         testBean.testRequiresNew(user);

    }
}
