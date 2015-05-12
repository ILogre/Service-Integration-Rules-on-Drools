package transfer.association;

import transfer.Answer;

public class GetLinkedAsw extends Answer {
	private String model;
	public GetLinkedAsw(String model) {
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
