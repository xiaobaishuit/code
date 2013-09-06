package test;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author ssl
 * 
 */
public class WeakHashMapTest {
	static Map wMap = new WeakHashMap();
	public static void init(){
		wMap.put("1", "ding");
		wMap.put("2", "job");
	}
	public static void main(String[] args) throws InterruptedException {
		testWeakHashMap();
	}
	
	public static void testWeakHashMap() throws InterruptedException{
		System.out.println(wMap.get("1"));
		Thread.sleep(5000);
		System.out.println(wMap.get("1"));
	}

}
