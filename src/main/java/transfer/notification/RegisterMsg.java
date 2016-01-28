package transfer.notification;

import transfer.Message;

public class RegisterMsg extends Message {

	private String owner;

	public String getOwner() {
		return owner;
	}

	public RegisterMsg(String owner) {
		super();
		this.owner = owner;
	}

}
