package com.lierlin.遍历;

import javax.swing.JOptionPane;

public class testt {
    public static void main(String[] args) {
        int res = JOptionPane.showConfirmDialog(null, "是否继续操作", "是否继续", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            System.out.println("选择是后执行的代码"); // 点击“是”后执行这个代码块
        } else {
            System.out.println("选择否后执行的代码"); // 点击“否”后执行这个代码块
            return;
        }
    }
}