package transfer.association;

import transfer.Message;

public class LinkMsg extends Message {
	
	private String element1;
	private String element2;
	private String type1; 
	private String type2;
	private boolean bidirectionnal;
	

	public LinkMsg(String element1, String type1, String element2,
			String type2, boolean bidirectionnal) {
		super();
		this.element1 = element1;
		this.type1 = type1;
		this.element2 = element2;
		this.type2 = type2;
		this.bidirectionnal = bidirectionnal;
	}

	public String getElement1() {
		return element1;
	}

	public String getElement2() {
		return element2;
	}
	
	public boolean isBidirectionnal() {
		return bidirectionnal;
	}

	public String getType1() {
		return type1;
	}

	public String getType2() {
		return type2;
	}

	
}
