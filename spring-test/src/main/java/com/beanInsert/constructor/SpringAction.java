package com.beanInsert.constructor;
/*
*
* ������ע�룺
*  ���ַ�ʽ��ע����ָ���в����Ĺ��캯��ע�룬����������ӣ��Ҵ�����������Ա����SpringDao��User��
* ���ǲ�δ���ö����set���������ԾͲ���֧�ֵ�һ��ע�뷽ʽ�������ע�뷽ʽ����SpringAction��
* ���캯����ע�룬Ҳ����˵�ڴ���SpringAction����ʱҪ��SpringDao��User��������ֵ��������
* */
public class SpringAction {
    //ע�����springDao
    private SpringDao springDao;
    private User user;

    public SpringAction(SpringDao springDao,User user){
        this.springDao = springDao;
        this.user = user;
        System.out.println("���췽������springDao��user");
    }

    public void save(){
        user.setName("����");
        springDao.save(user);
    }
}