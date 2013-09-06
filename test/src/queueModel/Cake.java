package queueModel;

/**
 * @author ssl
 * 
 */
public class Cake {
	//蛋糕的标签号
	private String cakeId;
	
	// Getter and Setter ...

	public String getCakeId() {
		return cakeId;
	}

	public void setCakeId(String cakeId) {
		this.cakeId = cakeId;
	}
	
	// Static Method's ...
	
	/** 构造方法 
	 * @return */
	public static Cake valueOf(String cakeId){
		Cake cake = new Cake();
		cake.setCakeId(cakeId);
		return cake;
	}
}
