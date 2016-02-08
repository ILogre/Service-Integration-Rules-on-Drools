package services.domainproxies;

import integration.Scenario;
import services.auxiliary.LinkedElementNotFoundException;
import transfer.Answer;
import transfer.association.GetLinkedAsw;
import transfer.association.GetLinkedMsg;
import transfer.association.HasLinkedAsw;
import transfer.association.HasLinkedMsg;
import transfer.association.LinkMsg;

public class AssociationDP {

/*
 * This proxy exposes the behavior of the Association auxiliary domain accessible to the rule engine
 * It is responsible for receiving information from the rule engine and transmit the message on the bus.
 */
	
	public static void link(LinkMsg msg){
		System.out.println("[Proxy] "+"link"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.spy.increaseInternallyTriggeredAuxiliaryRules();
		Scenario.bus.handle(msg);
	}
	
	public static GetLinkedAsw getLinked(GetLinkedMsg msg) throws LinkedElementNotFoundException{
		System.out.println("[Proxy] "+"getLinked"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.spy.increaseInternallyTriggeredAuxiliaryRules();
		Scenario.bus.handle(msg);
		Answer ans = Scenario.mailbox.get(msg);
		return (GetLinkedAsw) ans;
	}
	
	public static HasLinkedAsw hasLinked(HasLinkedMsg msg){
		System.out.println("[Proxy] "+"hasLinked"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.spy.increaseInternallyTriggeredAuxiliaryRules();
		Scenario.bus.handle(msg);
		Answer ans = Scenario.mailbox.get(msg);
		return (HasLinkedAsw) ans;
	}
	
}
