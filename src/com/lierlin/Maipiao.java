package com.lierlin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Vector;




public class Maipiao {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Date date=new Date();
		int b=date.getHours()+date.getSeconds();
		int data = 0;
		List<Thread> thradList = new ArrayList<Thread>();
		final List<Integer> list =new Vector<Integer>();
		 final Seil aa = new Seil(2000);
		for (int i=0;i<5000;i++) {
			 Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int count=aa.set(random());
				    try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					list.add(count);
				}
			});
			thradList.add(thread);
			thread.start();
			
		}	
		for (Thread a : thradList) {
			a.join();
		}
		System.out.println("ÓàÆ±"+aa.get());
		for (int i = 0; i < list.size(); i++) {
			data += list.get(i);
		}
		int bbString=date.getHours()+date.getSeconds();
		System.out.println("Âô³öµÄÆ±"+data);
		System.out.print(bbString-b);
		System.out.println(bbString);
		System.out.println(b);
		
		
		
	}
	static Random random = new Random();
	public	static int random(){return random.nextInt(5)+1;}

}





class Seil{
	static int count;
	
	public Seil(int count){
		this.count = count;
	}
	
	public int get() {
		return count;
	}
	public int set(int num){
		if (count >= num) {
			count = count - num;
			return num;
		}
		else {
			return 0;
		}
		
	}
	
}