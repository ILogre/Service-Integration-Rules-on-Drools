package integration;

public class Spy {

	private int nbRulesExecuted;
	private int nbRulesInternalTrigger;
	
	public Spy() {
		super();
		this.nbRulesExecuted = 0;
		this.nbRulesInternalTrigger = 0;
	}

	public int getNbRulesExecuted() {
		return nbRulesExecuted;
	}

	public int getNbRulesInternalTrigger() {
		return nbRulesInternalTrigger;
	}

	public void increaseNbRulesInternalTrigger() {
		nbRulesInternalTrigger++;
	}

	public void increaseNbRulesExecuted() {
		nbRulesExecuted++;
	}
	

}
