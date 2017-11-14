package Database;

public class Product {
	
	private String cardName;
	private String cardNum;
	private String cardExdate;
	
	public Product() {
		this.cardName = "";
		this.cardNum = "";
		this.cardExdate = "";

		}
	
	public Product(String cardName, String cardNum, String cardExdate) {
		this.cardName = cardName;
		this.cardNum = cardNum;
		this.cardExdate = cardExdate;
		
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardExdate() {
		return cardExdate;
	}

	public void setCardExdate(String cardExdate) {
		this.cardExdate = cardExdate;
	}
	
	

}
