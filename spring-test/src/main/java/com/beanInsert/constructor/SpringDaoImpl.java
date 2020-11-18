package com.beanInsert.constructor;

public class SpringDaoImpl implements SpringDao {


    @Override
    public void save(User user) {
        System.out.println("constructor ***********");
    }
}
