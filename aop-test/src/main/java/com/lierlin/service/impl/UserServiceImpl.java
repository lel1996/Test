package com.lierlin.service.impl;

import com.lierlin.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional(isolation= Isolation.REPEATABLE_READ,propagation= Propagation.REQUIRED,readOnly=false)
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("save");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void find() {
        System.out.println("find");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }
}
