package services.auxiliary;

import java.util.ArrayList;
import java.util.List;

import transfer.Service;
import transfer.association.GetLinkedAsw;
import transfer.association.GetLinkedMsg;
import transfer.association.LinkMsg;

public class Association extends Service{

	private static List<Pair> pairs = new ArrayList<Pair>();
	
	public static void link(LinkMsg msg){
		pairs.add(new Pair(msg.getElement1(), msg.getElement2(), msg.isBidirectionnal()));
		System.out.println("Association : link set between "+msg.getElement1()+" and "+msg.getElement2()+", bidirectionnal : "+msg.isBidirectionnal());
	}
	
	public static GetLinkedAsw getLinked(GetLinkedMsg msg) throws Exception{
		for(Pair p : pairs)
			if (p.contains(msg.getModel()))
				return new GetLinkedAsw(p.getPaired(msg.getModel()));
		return new GetLinkedAsw(null);
	}
}
