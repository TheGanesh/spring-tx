package com.ganesh.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Ganesh on 1/19/15.
 */
@Component
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Autowired
    DataSource dataSource;

    @Override
    protected DataSource determineTargetDataSource() {

        System.out.println("coming into determineTargetDataSource");

        DataSource dataSource = this.dataSource;
        if (dataSource == null) {
            throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + "hi" + "]");
        }
        return dataSource;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }

    @Override
    public void afterPropertiesSet() {
        // overridden to avoid datasource validation error by Spring
    }
}
