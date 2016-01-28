package transfer.notification;

import java.util.List;

import transfer.Answer;

public class ConsultAsw extends Answer {
	
	private List<String> messages;

	public List<String> getMessages() {
		return messages;
	}

	public ConsultAsw(List<String> messages) {
		super();
		this.messages = messages;
	}

}
