package services.domainproxies;

import integration.Scenario;
import message.CharacterizeVisuMsg;
import message.DeclareDashboardMsg;
import message.PlugDataMsg;
import message.PositionMsg;

/*
 * This proxy exposes the behavior of the Visualization Design domain accessible to the rule engine
 * It is responsible for receiving information from the rule engine and transmit the message on the bus.
 */

public class VisualizationDesignDP  {
	
	public static void declareDashboard(DeclareDashboardMsg msg){
		System.out.println("[Proxy] "+"declareDashboard"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
	}
	
	public static void characterizeVisu(CharacterizeVisuMsg msg){
		System.out.println("[Proxy] "+"characterizeVisu"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
	}
	
	public static void plugData(PlugDataMsg msg){
		System.out.println("[Proxy] "+"plugData"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
	}
	
	public static void position(PositionMsg msg){
		System.out.println("[Proxy] "+"position"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
	}
}
