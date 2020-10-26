package com.lierlin.CAS;

import lombok.extern.log4j.Log4j;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;




public class AtomicIntegerTest {

    public static void main(String[] args) {
        AtomicInteger aint = new AtomicInteger(5);
        //BigDecimal
        if (aint.compareAndSet(7,8));
        {
            System.out.println(aint.compareAndSet(5,9));
            System.out.println(aint);
        }

    }
}
