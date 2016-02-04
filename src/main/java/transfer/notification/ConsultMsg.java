package transfer.notification;

import transfer.Message;

public class ConsultMsg extends Message {

	private String owner;
	private String type;

	public ConsultMsg(String owner,String type) {
		super();
		this.owner = owner;
		this.type = type;
	}

	public String getOwner() {
		return owner;
	}

	public String getType() {
		return type;
	}
	
}
