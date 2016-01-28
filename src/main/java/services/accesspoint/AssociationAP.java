package services.accesspoint;

import services.auxiliary.Association;
import transfer.association.GetLinkedAsw;
import transfer.association.GetLinkedMsg;
import transfer.association.LinkMsg;

public class AssociationAP {

	/*
	 * This access point exposes the behavior of the Association domain accessible to the final user
	 * It is responsible for receiving the original message from the rule engine and transmit it to the domain implementation.
	 */
	
	public static void link(LinkMsg msg){
		Association.link(msg);
	}
	
	public static GetLinkedAsw getLinked(GetLinkedMsg msg) throws Exception{
		return Association.getLinked(msg);
	}

}
