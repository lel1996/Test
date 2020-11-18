package com.beanInsert.constructor;
/*
*
* 构造器注入：
*  这种方式的注入是指带有参数的构造函数注入，看下面的例子，我创建了两个成员变量SpringDao和User，
* 但是并未设置对象的set方法，所以就不能支持第一种注入方式，这里的注入方式是在SpringAction的
* 构造函数中注入，也就是说在创建SpringAction对象时要将SpringDao和User两个参数值传进来：
* */
public class SpringAction {
    //注入对象springDao
    private SpringDao springDao;
    private User user;

    public SpringAction(SpringDao springDao,User user){
        this.springDao = springDao;
        this.user = user;
        System.out.println("构造方法调用springDao和user");
    }

    public void save(){
        user.setName("卡卡");
        springDao.save(user);
    }
}