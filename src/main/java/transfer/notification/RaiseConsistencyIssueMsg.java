package transfer.notification;

import transfer.Message;

public class RaiseConsistencyIssueMsg extends Message {
	
	private String owner;
	private String type;
	private ConsistencyIssue issue;
	
	public RaiseConsistencyIssueMsg(String owner, String type, ConsistencyIssue issue) {
		this.owner=owner;
		this.type=type;
		this.issue=issue;
	}

	public String getOwner() {
		return owner;
	}

	public ConsistencyIssue getIssue() {
		return issue;
	}

	public String getType() {
		return type;
	}

}
