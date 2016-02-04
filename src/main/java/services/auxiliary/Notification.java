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
import exceptions.UnknownModelException;

public class Notification extends Service {

	static private Map< Thing, List<Note> > notifications = new HashMap<Thing, List<Note>>();
	
	/*
	 * The semantic of a publication is a message destined to the
	 * domain expert designing a particular model element (represented
	 * by its type and name). This message is not critical for the
	 * validation of the whole SoS
	 */
	public static void publish(PublishMsg msg){
		List<String> messages = Arrays.asList(msg.getMessages());
		Thing temp = new Thing(msg.getOwner(), msg.getType());
		if(!notifications.containsKey(temp)){
			List<Note> notes = new ArrayList<Note>();
			for(String message:messages)
				notes.add(new Note(message,false));
			notifications.put(temp, notes);
		}else{
			List<Note> notes = notifications.get(temp);
			for(String message:messages)
				notes.add(new Note(message,false));
		}
	}
	
	/*
	 * The domain expert designing a particular model element
	 * (represented by its type and name) is allowed to consult
	 * the messages attached to this model (\eg a sensor is used
	 * by a visualization). The critical messages are not suppressed
	 * by this operation.
	 */
	public static ConsultAsw consult(ConsultMsg msg) throws UnknownModelException{
		if(!notifications.containsKey(msg.getOwner()))
			throw new UnknownModelException(msg.getOwner()+" of type "+msg.getType()+" is not known");
		else{
			Thing temp = new Thing(msg.getOwner(), msg.getType());
			List<Note> notes = notifications.get(temp);
			List<String> messages = new ArrayList<String>();
			for(Note n : notes){
				messages.add(n.getNote());
				if(!n.isCritical())
					notes.remove(n);
			}
			return new ConsultAsw(messages);
		}
			
	}
	
	

}
