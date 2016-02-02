package transfer.association;

import transfer.Answer;

public class GetLinkedAsw extends Answer {
	private String model;
	private String type; 
	public GetLinkedAsw(String model, String type) {
		super();
		this.model = model;
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public String getType() {
		return type;
	}
}
