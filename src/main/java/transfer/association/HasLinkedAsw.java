package transfer.association;

import transfer.Answer;

public class HasLinkedAsw extends Answer {
	private boolean answer;

	public HasLinkedAsw(boolean answer) {
		super();
		this.answer = answer;
	}

	public boolean getAnswer() {
		return answer;
	}

}
