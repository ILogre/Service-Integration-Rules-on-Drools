package transfer.association;

import transfer.Message;

public class LinkMsg extends Message {
	
	private String element1;
	private String element2;
	private boolean bidirectionnal;
	
	public LinkMsg(String model1, String model2, boolean bidirectionnal) {
		super();
		this.element1 = model1;
		this.element2 = model2;
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
}
