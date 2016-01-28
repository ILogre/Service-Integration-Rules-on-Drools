package services.domainproxies;

import integration.Scenario;
import message.StartProjectMsg;

public class RequirementEngineeringDomainProxy {


/*
 * This proxy exposes the behavior of the Requirement Engineering domain accessible to the rule engine
 * It is responsible for receiving information from the rule engine and transmit the message on the bus.
 */
	
	
	public static void startProject (StartProjectMsg msg){
		System.out.println("[Proxy]"+"StartProject"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.bus.handle(msg);
	}
	
	
	
}
