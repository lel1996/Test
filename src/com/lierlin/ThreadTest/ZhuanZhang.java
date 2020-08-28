package com.lierlin.ThreadTest;


public class ZhuanZhang {
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		final TransgerMoney aMoney = new TransgerMoney(10000);
		final TransgerMoney bMoney = new TransgerMoney(10000);
		
			Thread a1=new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int i=0;i<10000;i++){
					aMoney.Transger(bMoney,1);
				
						//Thread.sleep(100);
						//System.out.println(i);
			
					}
				}
			});
		
		
		
	Thread a2=new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<10000;i++){
			bMoney.Transger(aMoney,2);
}
		}
	});
	a1.start();
	a2.start();
	
	a1.join();
	a2.join();
	System.out.println("a账户的金额"+aMoney.get());

	System.out.println("b账户的金额"+bMoney.get());

	}

}
class TransgerMoney{
	private int total;
	public TransgerMoney(int money){
		this.total = money;
	}
	public int get(){return total;}
	public void set(int num){this.total = num;}
	
	public  void Transger(TransgerMoney target,int num){
		synchronized(TransgerMoney.class){
			if (target.get()>num) {
				this.set(this.get()-num);
				target.set(target.get()+num);
			}
		}
	
	}
}
