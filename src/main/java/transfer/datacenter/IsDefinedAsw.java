package transfer.datacenter;

import transfer.Answer;

public class IsDefinedAsw extends Answer {
	private Boolean answer;

	public IsDefinedAsw(Boolean answer) {
		super();
		this.answer = answer;
	}

	public Boolean getAnswer() {
		return answer;
	}

	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}
	
}
