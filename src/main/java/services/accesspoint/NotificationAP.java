package services.accesspoint;

import services.auxiliary.Notification;
import transfer.notification.ConsultAsw;
import transfer.notification.ConsultMsg;
import transfer.notification.PublishMsg;
import exceptions.UnknownModelException;

public class NotificationAP {

	/*
	 * This access point exposes the behavior of the Sensor Deployment domain accessible to the final user
	 * It is responsible for receiving the original message from the rule engine and transmit it to the domain implementation.
	 */
	
	public static void publish(PublishMsg msg){
		Notification.publish(msg);
	}
	
	public static ConsultAsw consult(ConsultMsg msg) throws UnknownModelException{
		return Notification.consult(msg);
	}
	
}
