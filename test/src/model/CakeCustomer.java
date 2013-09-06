package model;

/**蛋糕店消费者
 * @author ssl
 * 
 */
public class CakeCustomer implements Runnable{

	private CakeStore cakeStore;  
	  
    public CakeCustomer(CakeStore cakeStore) {  
        this.cakeStore = cakeStore;  
    } 

	@Override
	public void run() {
		while(true){
			cakeStore.eatCake();  
            System.out.println(Thread.currentThread()+"吃了cake");
        }  
		
	}

}
