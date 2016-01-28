package transfer.notification;

import transfer.Message;

public class ConsultMsg extends Message {

	private String owner;

	public ConsultMsg(String owner) {
		super();
		this.owner = owner;
	}

	public Object getOwner() {
		return owner;
	}
}
