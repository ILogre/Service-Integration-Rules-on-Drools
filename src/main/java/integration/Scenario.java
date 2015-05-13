package integration;

import java.util.HashMap;
import java.util.Map;

import transfer.association.LinkMsg;
import transfer.datacenter.DeclareCatalogMsg;
import transfer.datacenter.ExposeResourceMsg;
import transfer.visudesign.AddVisuMsg;
import transfer.visudesign.CharacterizeMsg;
import transfer.visudesign.DeclareDashboardMsg;
import transfer.visudesign.PlugDataMsg;

public class Scenario {

	public static void main(String[] args) throws Exception {
		String catalogName = "je suis un catalogue";
		String dashboardName = "je suis un dashboard";
		String visuName = "je suis une visu";
		String uri = "je suis une uri";
		ESB bus = new ESB();
		
		PlugData(bus,catalogName,dashboardName, visuName, uri);
		//CharacterizeThreshold(bus,catalogName,dashboardName, visuName);
	}
	
	public static void PlugData(ESB bus, String catalogName, String dashboardName, String visuName, String uri){
		System.out.println("Step 1 : Declare a Catalog");
		bus.handle(new DeclareCatalogMsg(catalogName));
		
		System.out.println("Step 2 : Declare a Dashboard");
		bus.handle(new DeclareDashboardMsg(dashboardName));
		
		System.out.println("Step 3 : Link both");
		bus.handle(new LinkMsg(catalogName, dashboardName));

		System.out.println("Step 4 : Expose a new Resource");
		Map<String, String> elems = new HashMap<String,String>();
		elems.put("t", "numerical");
		elems.put("v", "numerical");
		bus.handle(new ExposeResourceMsg(catalogName, uri, "je suis une semantique", elems));
		
		System.out.println("Step 5 : Add a visu to the dashboard");
		bus.handle(new AddVisuMsg(dashboardName, visuName));
		
		System.out.println("Step 6 : Plug a data on this visualization");
		bus.handle(new PlugDataMsg(dashboardName, visuName, uri));
		
		System.out.println("Step 7 : Ending.");
	}

	public static void CharacterizeThreshold(ESB bus, String catalogName, String dashboardName, String visuName){
		System.out.println("Step 1 : Declare a Catalog");
		bus.handle(new DeclareCatalogMsg(catalogName));
		
		System.out.println("Step 2 : Declare a Dashboard");
		bus.handle(new DeclareDashboardMsg(dashboardName));
		
		System.out.println("Step 3 : Link both");
		bus.handle(new LinkMsg(catalogName, dashboardName));
		
		System.out.println("Step 4 : Add a visu to the dashboard");
		bus.handle(new AddVisuMsg(dashboardName, visuName));
		
		System.out.println("Step 5 : Characterize this visualization with a threshold");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", 24);
		bus.handle(new CharacterizeMsg(dashboardName, visuName, "Threshold", params));
		
		System.out.println("Step 6 : Ending.");
	}

}
