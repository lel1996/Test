package com.lierlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lamda {
    public static void main(String[] args) {
/*Consumer<Double> consumer = new Consumer<Double>() {
    @Override
    public void accept(Double aDouble) {
  System.out.println("ฯ๛ทัมห"+aDouble);
    }
};*/
//Consumer<Double> consumer = t->System.out.println("xiaofeile "+t);
 a(t->System.out.println("xiaofeile "+t),1000);
int [] arr = getNums(()->new Random().nextInt(100),5);
 System.out.println(Arrays.toString(arr));
 //System.out.println(handlerString(S-> s().trim()),"zhangsna    ");

    }
    public static void a(Consumer<Double> consumer,double money){
        consumer.accept(money);

    }

    public static int[] getNums(Supplier<Integer> supplier,int Conut){
        int [] arr=new int[Conut];
        for (int i = 0; i < Conut; i++) {
            arr[i] = supplier.get();
        }
        return arr;
    }

    public static String handlerString(Function<String,String> function,String str){

        return function.apply(str);
    }



}
