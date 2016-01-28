package services.accesspoint;

import domain.RequirementEngineering;
import message.StartProjectMsg;

public class RequirementEngineeringAP {
	
	/*
	 * This access point exposes the behavior of the Requirement Engineering domain accessible to the final user
	 * It is responsible for receiving the original message from the rule engine and transmit it to the domain implementation.
	 */
	
	
	public static void startProject (StartProjectMsg msg){
		RequirementEngineering.startProject(msg);
	}

}
