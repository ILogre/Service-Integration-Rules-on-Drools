package integration;

import java.util.HashMap;
import java.util.Map;

import message.CharacterizeVisuMsg;
import message.DeclareCatalogMsg;
import message.DeclareDashboardMsg;
import message.PlugDataMsg;
import transfer.association.LinkMsg;

public class Scenario {

	public static void main(String[] args) throws Exception {
		String catalogName = "test_catalogue";
		String dashboardName = "test_dashboard";
		String visuName = "test_visu";
		String dataName = "test_data";
		ESB bus = new ESB();
		
		Minimal(bus, dashboardName);
		//PlugData(bus,catalogName,dashboardName, visuName, dataName);
		//CharacterizeThreshold(bus,catalogName,dashboardName, visuName);
	}
	
	public static void Minimal(ESB bus, String dashboardName){
		System.out.println("Step 0 : Declare a Dashboard");
		bus.handle(new DeclareDashboardMsg(dashboardName));
		
	}
	
	public static void PlugData(ESB bus, String catalogName, String dashboardName, String visuName, String dataName){
		System.out.println("Step 1 : Declare a Catalog");
		bus.handle(new DeclareCatalogMsg(catalogName));
		
		System.out.println("Step 2 : Declare a Dashboard");
		bus.handle(new DeclareDashboardMsg(dashboardName));
		
		System.out.println("Step 3 : Link both");
		bus.handle(new LinkMsg(catalogName, dashboardName));

		System.out.println("Step 4 : Expose a new Resource");
		//Map<String, String> elems = new HashMap<String,String>();
		//elems.put("t", "numerical");
		//elems.put("v", "numerical");
		//bus.handle(new ExposeResourceMsg(catalogName, uri, "je suis une semantique", elems));
		
		System.out.println("Step 5 : Add a visu to the dashboard");
		bus.handle(new CharacterizeVisuMsg(dashboardName, visuName));
		
		System.out.println("Step 6 : Plug a data on this visualization");
		bus.handle(new PlugDataMsg(dashboardName, visuName, dataName, null));
		
		System.out.println("Step 7 : Ending.");
	}

	public static void CharacterizeThreshold(ESB bus, String catalogName, String dashboardName, String visuName, String dataName){
		System.out.println("Step 1 : Declare a Catalog");
		bus.handle(new DeclareCatalogMsg(catalogName));
		
		System.out.println("Step 2 : Declare a Dashboard");
		bus.handle(new DeclareDashboardMsg(dashboardName));
		
		System.out.println("Step 3 : Link both");
		bus.handle(new LinkMsg(catalogName, dashboardName));
		
		System.out.println("Step 4 : Add a visu to the dashboard");
		bus.handle(new CharacterizeVisuMsg(dashboardName, visuName));
		
		System.out.println("Step 5 : Plug a data on this visualization with a threshold");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", 24);
		Map<String, Map<String,Object>> concerns = new HashMap<String, Map<String,Object>>();
		concerns.put("Threshold", params);
		bus.handle(new PlugDataMsg(dashboardName, visuName, dataName, concerns));
		// PlugDataMsg(String dashboardName, String visuName, String dataName, Map<String, Map<String,Object>> concerns)
		
		
		System.out.println("Step 6 : Ending.");
	}

}
