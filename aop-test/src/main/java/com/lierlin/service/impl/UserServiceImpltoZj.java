package com.lierlin.service.impl;

import com.lierlin.service.UserServicetoZj;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Transactional(isolation= Isolation.REPEATABLE_READ,propagation= Propagation.REQUIRED,readOnly=false)
@Service("userServicetoZj")
public class UserServiceImpltoZj implements UserServicetoZj {
    public void add() {
        System.out.println("������һ���û�");
    }
    public void delete() {
        System.out.println("ɾ��һ���û�");
    }
    public void update() {
        System.out.println("����һ���û�");
    }
    public void select() {
        System.out.println("��ѯһ���û�");
    }

}
