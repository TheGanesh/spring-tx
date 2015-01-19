package com.ganesh.spring.tx.dao;

import com.ganesh.spring.tx.model.User;

import java.util.List;

/**
 * Created by Ganesh on 1/18/15.
 */
public interface ExtractUnitDao {

    public void insertBatchExtractUnits(List<User> users);
    public List<User>  readExtractUnits();


}
