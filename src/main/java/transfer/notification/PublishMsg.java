package transfer.notification;

import transfer.Message;

public class PublishMsg extends Message {

	private String owner;
	private String[] messages;
	
	public PublishMsg(String owner, String ...messages) {
		this.owner=owner;
		this.messages=messages;
	}

	public String getOwner() {
		return owner;
	}

	public String[] getMessages() {
		return messages;
	}

}
