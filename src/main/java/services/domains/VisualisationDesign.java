package services.domains;

import transfer.datacenter.DeclareCatalogMsg;
import transfer.visudesign.AddVisuMsg;
import transfer.visudesign.CharacterizeMsg;
import transfer.visudesign.PlugDataMsg;

public class VisualisationDesign {
	
	public static void declareDashboard(DeclareCatalogMsg msg){
		System.out.println("VisuDesign : dashboard \""+msg.getName()+"\" declared at "+System.currentTimeMillis());
	}
	
	//TODO add param to handle the spatial composition
	public static void addVisu(AddVisuMsg msg){
		System.out.println("VisuDesign : visualization \""+msg.getVisuName()+"\" added to dashboard \""
				+msg.getDashboardName()+"\" at "+System.currentTimeMillis());
	}
	
	public static void plugData(PlugDataMsg msg){ //, Map<String, Map<String,Object>> concerns
		System.out.println("VisuDesign : data \""+msg.getUri()+"\" pluged on visualization \""+msg.getVisuName()
				+"\" at "+System.currentTimeMillis());
	}
	
	public static void characterize(CharacterizeMsg msg){
		System.out.println("VisuDesign : visualization \""+msg.getVisuName()+"\" characterized by "+msg.getConcerns()
				+" at "+System.currentTimeMillis());
	}
}
