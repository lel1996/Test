package com.beanInsert.set;
public class SpringAction {
    //ע�����springDao
    private SpringDao springDao;
    //һ��Ҫд��ע������set����
    public void setSpringDao(SpringDao springDao) {
        this.springDao = springDao;
    }

    public void ok(){
        springDao.dao();
    }
}