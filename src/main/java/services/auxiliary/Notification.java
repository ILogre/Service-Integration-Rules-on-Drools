package services.auxiliary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import transfer.Service;
import transfer.notification.ConsultAsw;
import transfer.notification.ConsultMsg;
import transfer.notification.PublishMsg;
import transfer.notification.RegisterMsg;
import exceptions.UnknownModelException;

public class Notification extends Service {

	static private Map< String, List<String> > notifications = new HashMap<String, List<String>>();
	
	public static void publish(PublishMsg msg){
		List<String> messages = Arrays.asList(msg.getMessages());
		if(!notifications.containsKey(msg.getOwner())){
			notifications.put(msg.getOwner(), messages);
		}else{
			List<String> existing = notifications.get(msg.getOwner());
			existing.addAll(messages);
		}
	}
	
	public static ConsultAsw consult(ConsultMsg msg) throws UnknownModelException{
		if(!notifications.containsKey(msg.getOwner()))
			throw new UnknownModelException(msg.getOwner()+" is not known");
		else
			return new ConsultAsw(notifications.get(msg.getOwner()));
	}
	
	public static void register(RegisterMsg msg){
		List<String> messages = new ArrayList<String>();
		notifications.put(msg.getOwner(), messages);
	}

}
