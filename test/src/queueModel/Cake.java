package queueModel;

/**
 * @author ssl
 * 
 */
public class Cake {
	//����ı�ǩ��
	private String cakeId;
	
	// Getter and Setter ...

	public String getCakeId() {
		return cakeId;
	}

	public void setCakeId(String cakeId) {
		this.cakeId = cakeId;
	}
	
	// Static Method's ...
	
	/** ���췽�� 
	 * @return */
	public static Cake valueOf(String cakeId){
		Cake cake = new Cake();
		cake.setCakeId(cakeId);
		return cake;
	}
}
