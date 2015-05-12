package transfer.association;

import transfer.Message;

public class LinkMsg extends Message {
	private String model1;
	private String model2;
	public LinkMsg(String model1, String model2) {
		super();
		this.model1 = model1;
		this.model2 = model2;
	}
	public String getModel1() {
		return model1;
	}
	public void setModel1(String model1) {
		this.model1 = model1;
	}
	public String getModel2() {
		return model2;
	}
	public void setModel2(String model2) {
		this.model2 = model2;
	}
}
