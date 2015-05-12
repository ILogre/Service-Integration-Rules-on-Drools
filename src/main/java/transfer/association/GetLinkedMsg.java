package transfer.association;

import transfer.Message;

public class GetLinkedMsg extends Message {
	private String model;
	public GetLinkedMsg(String model) {
		super();
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

}
