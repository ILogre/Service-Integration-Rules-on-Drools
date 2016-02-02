package transfer.association;

import transfer.Message;

public class HasLinkedMsg extends Message {
	private String model;
	private String type; 
	private String type2; 
	public HasLinkedMsg(String model, String type, String type2) {
		super();
		this.model = model;
		this.type = type;
		this.type2=type2;
	}
	public String getModel() {
		return model;
	}
	public String getType() {
		return type;
	}
	public String getTypeLookingFor() {
		return type2;
	}

}
