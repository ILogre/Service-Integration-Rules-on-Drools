package integration;

public class Spy {

	private int nbRulesExecuted;
	private int nbInternallyTriggeredRules;
	private int nbInternallyTriggeredDomainRules;
	private int nbInternallyTriggeredAuxiliaryRules;
	
	public Spy() {
		super();
		this.nbRulesExecuted = 0;
		this.nbInternallyTriggeredRules = 0;
	}

	public int getNbRulesExecuted() {
		return nbRulesExecuted;
	}

	public int getNbRulesInternalTrigger() {
		return nbInternallyTriggeredRules;
	}

	public void increaseInternallyTriggeredDomainRules() {
		nbInternallyTriggeredRules++;
		nbInternallyTriggeredDomainRules++;
	}
	

	public void increaseInternallyTriggeredAuxiliaryRules() {
		nbInternallyTriggeredRules++;
		nbInternallyTriggeredAuxiliaryRules++;
	}

	public void increaseNbRulesExecuted() {
		nbRulesExecuted++;
	}

	public int getNbInternallyTriggeredDomainRules() {
		return nbInternallyTriggeredDomainRules;
	}

	public int getNbInternallyTriggeredAuxiliaryRules() {
		return nbInternallyTriggeredAuxiliaryRules;
	}

}
