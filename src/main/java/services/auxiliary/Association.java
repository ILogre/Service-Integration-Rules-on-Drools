package services.auxiliary;

import java.util.ArrayList;
import java.util.List;

import transfer.association.GetLinkedAsw;
import transfer.association.GetLinkedMsg;
import transfer.association.LinkMsg;

public class Association {

	private static List<Pair> pairs = new ArrayList<Pair>();
	
	public static void link(LinkMsg msg){
		pairs.add(new Pair(msg.getModel1(), msg.getModel2()));
		System.out.println("Association : link between "+msg.getModel1()+" and "+msg.getModel2());
	}
	
	public static GetLinkedAsw getLinked(GetLinkedMsg msg) throws Exception{
		for(Pair p : pairs)
			if (p.contains(msg.getModel()))
				return new GetLinkedAsw(p.getPaired(msg.getModel()));
		return new GetLinkedAsw(null);
	}
}
