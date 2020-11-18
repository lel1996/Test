package com.lierlin.service.impl;

import com.lierlin.service.UserServicetoZj;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Transactional(isolation= Isolation.REPEATABLE_READ,propagation= Propagation.REQUIRED,readOnly=false)
@Service("userServicetoZj")
public class UserServiceImpltoZj implements UserServicetoZj {
    public void add() {
        System.out.println("增加了一个用户");
    }
    public void delete() {
        System.out.println("删除一个用户");
    }
    public void update() {
        System.out.println("更新一个用户");
    }
    public void select() {
        System.out.println("查询一个用户");
    }

}
