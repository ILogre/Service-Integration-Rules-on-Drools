package transfer.notification;

import transfer.Message;

public class PublishMsg extends Message {

	private String owner;
	private String type;
	private String[] messages;
	
	public PublishMsg(String owner, String type, String ...messages) {
		this.owner=owner;
		this.type=type;
		this.messages=messages;
	}

	public String getOwner() {
		return owner;
	}

	public String[] getMessages() {
		return messages;
	}

	public String getType() {
		return type;
	}
}
