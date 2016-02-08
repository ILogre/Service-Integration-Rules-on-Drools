package services.domainproxies;

import integration.Scenario;
import transfer.Answer;
import transfer.notification.ConsultAsw;
import transfer.notification.ConsultMsg;
import transfer.notification.PublishMsg;
import transfer.notification.RaiseConsistencyIssueMsg;
import exceptions.UnknownModelException;

public class NotificationDP {

	/*
	 * This proxy exposes the behavior of the Notification auxiliary domain accessible to the rule engine
	 * It is responsible for receiving information from the rule engine and transmit the message on the bus.
	 */
		
		public static void publish(PublishMsg msg){
			System.out.println("[Proxy] "+"publish"+"\t\t ("+System.currentTimeMillis()+" )");
			Scenario.spy.increaseInternallyTriggeredAuxiliaryRules();
			Scenario.bus.handle(msg);
		}
		
		public static ConsultAsw consult(ConsultMsg msg) throws UnknownModelException{
			System.out.println("[Proxy] "+"consult"+"\t\t ("+System.currentTimeMillis()+" )");
			Scenario.spy.increaseInternallyTriggeredAuxiliaryRules();
			Scenario.bus.handle(msg);
			Answer ans = Scenario.mailbox.get(msg);
			return (ConsultAsw) ans;
		}

		public static void raiseConsistencyIssue(RaiseConsistencyIssueMsg msg){
			System.out.println("[Proxy] "+"raise Consistency Issue"+"\t\t ("+System.currentTimeMillis()+" )");
			Scenario.spy.increaseInternallyTriggeredAuxiliaryRules();
			Scenario.bus.handle(msg);
		}
	
}
