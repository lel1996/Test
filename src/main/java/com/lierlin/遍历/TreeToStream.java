package com.lierlin.����;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TreeToStream {
    public static void main(String[] args) {

            //ģ������ݿ��ѯ����
            List<Menu> menus = Arrays.asList(
                    new Menu(1,"���ڵ�",0),
                    new Menu(2,"�ӽڵ�1",1),
                    new Menu(3,"�ӽڵ�1.1",2),
                    new Menu(4,"�ӽڵ�1.2",2),
                    new Menu(5,"���ڵ�1.3",2),
                    new Menu(6,"���ڵ�2",1),
                    new Menu(7,"���ڵ�2.1",6),
                    new Menu(8,"���ڵ�2.2",6),
                    new Menu(9,"���ڵ�2.2.1",7),
                    new Menu(10,"���ڵ�2.2.2",7),
                    new Menu(11,"���ڵ�3",1),
                    new Menu(12,"���ڵ�3.1",11)
            );

            //��ȡ���ڵ�
            List<Menu> collect = menus.stream().filter(m -> m.getParentId() == 0).map(
                    (m) -> {
                        m.setChildList(getChildrens(m, menus));
                        return m;
                    }
            ).collect(Collectors.toList());
            System.out.println("-------תjson������-------");
            System.out.println(JSON.toJSON(collect));
        }

        /**
         * �ݹ��ѯ�ӽڵ�
         * @param root  ���ڵ�
         * @param all   ���нڵ�
         * @return ���ڵ���Ϣ
         */
        private static List<Menu> getChildrens(Menu root, List<Menu> all) {
            List<Menu> children = all.stream().filter(m -> {
                return Objects.equals(m.getParentId(), root.getId());
            }).map(
                    (m) -> {
                        m.setChildList(getChildrens(m, all));
                        return m;
                    }
            ).collect(Collectors.toList());
            return children;
        }
    }



@Data
@Builder
class Menu {
    /**
     * id
     */
    public Integer id;
    /**
     * ����
     */
    public String name;
    /**
     * ��id �����ڵ�Ϊ0
     */
    public Integer parentId;
    /**
     * �ӽڵ���Ϣ
     */
    public List<Menu> childList;


    public Menu(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Menu(Integer id, String name, Integer parentId, List<Menu> childList) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childList = childList;
    }

}