package com.lierlin.����;

import javax.swing.JOptionPane;

public class testt {
    public static void main(String[] args) {
        int res = JOptionPane.showConfirmDialog(null, "�Ƿ��������", "�Ƿ����", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            System.out.println("ѡ���Ǻ�ִ�еĴ���"); // ������ǡ���ִ����������
        } else {
            System.out.println("ѡ����ִ�еĴ���"); // ������񡱺�ִ����������
            return;
        }
    }
}