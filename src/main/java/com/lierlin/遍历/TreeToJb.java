package com.lierlin.����;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.map.HashedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeToJb {
    public static void main(String[] args) {
        Map<String,Node> nodes = new HashedMap();
        //ģ�����ݿ�洢���ṹ
        nodes.put("1",new Node("1","root",1,"0"));
        nodes.put("2",new Node("2","a",1,"1"));
        nodes.put("3",new Node("3","b",1,"1"));
        nodes.put("4",new Node("4","c",1,"1"));
        nodes.put("5",new Node("5","d",1,"2"));
        nodes.put("6",new Node("6","e",1,"2"));
        nodes.put("7",new Node("7","f",1,"3"));
        nodes.put("8",new Node("8","g",1,"7"));
        System.out.println("result:" + JSON.toJSONString(getNodeJson("0",nodes)));
    }
    /**
     * �ݹ鴦��   ���ݿ����ṹ����->����json
     * @param nodeId
     * @param nodes
     * @return
     */
    public static JSONArray getNodeJson(String nodeId, Map<String,Node> nodes){

        //��ǰ�㼶��ǰnode����
        Node cur = nodes.get(nodeId);
        //��ǰ�㼶��ǰ���µ������ӽڵ㣨ʵս�в�Ҫ����ȥ��,һ�μ��ص�����Ȼ����������
        List<Node> childList = getChildNodes(nodeId,nodes);

        JSONArray childTree = new JSONArray();
        for (Node node : childList) {
            JSONObject o = new JSONObject();
            o.put("name", node.getName());
            o.put("type", node.getType());
            JSONArray childs = getNodeJson(node.getId(),nodes);  //�ݹ���ø÷���
            if(!childs.isEmpty()) {
                o.put("children",childs);
            }
            childTree.fluentAdd(o);
        }
        return childTree;
    }

    /**
     * ��ȡ��ǰ�ڵ�������ӽڵ�
     * @param nodeId
     * @param nodes
     * @return
     */
    public static List<Node> getChildNodes(String nodeId, Map<String,Node> nodes){
        List<Node> list = new ArrayList<>();
        for (String key : nodes.keySet() ) {
            if(nodes.get(key).getParentId().equals(nodeId)){
                list.add(nodes.get(key));
            }
        }
        return list;
    }

}

    class Node{
        public String id ;
        public String name;
        public Integer type;
        public String parentId;

        public Node(String id, String name, Integer type, String parentId) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.parentId = parentId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }
    }

