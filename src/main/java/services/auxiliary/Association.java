package services.auxiliary;

import java.util.ArrayList;
import java.util.List;

import transfer.Service;
import transfer.association.GetLinkedAsw;
import transfer.association.GetLinkedMsg;
import transfer.association.HasLinkedAsw;
import transfer.association.HasLinkedMsg;
import transfer.association.LinkMsg;

public class Association extends Service{

	private static List<Pair> pairs = new ArrayList<Pair>();
	
	public static void link(LinkMsg msg){
		pairs.add(new Pair(msg.getElement1(), msg.getType1(), msg.getElement2(), msg.getType2(), msg.isBidirectionnal()));
		System.out.println("Association : link set between "+msg.getElement1()+" of type "+msg.getType1()+" and "+msg.getElement2()+" of type "+msg.getType2()+", bidirectionnal : "+msg.isBidirectionnal());
	}
	
	public static GetLinkedAsw getLinked(GetLinkedMsg msg) throws LinkedElementNotFoundException{
		for(Pair p : pairs)
			if (p.contains(msg.getModel(), msg.getType(), msg.getTypeLookingFor())){
				Thing asw = p.getPaired(msg.getModel(), msg.getType(), msg.getTypeLookingFor());
				return new GetLinkedAsw(asw.getElement(), asw.getType());
			}
		throw new LinkedElementNotFoundException("Element "+msg.getModel()+" of type "+msg.getType()+" has no linked element");
	}
	
	public static HasLinkedAsw hasLinked(HasLinkedMsg msg){
		boolean found = false;
		for(Pair p : pairs)
			if (p.contains(msg.getModel(), msg.getType(), msg.getTypeLookingFor()))
				found = true;
		return new HasLinkedAsw(found);
	}
}
