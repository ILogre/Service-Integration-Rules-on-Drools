package integration;

import transfer.association.LinkMsg;
import transfer.datacenter.DeclareCatalogMsg;
import transfer.visudesign.AddVisuMsg;
import transfer.visudesign.DeclareDashboardMsg;
import transfer.visudesign.PlugDataMsg;

public class Scenario {

	public static void main(String[] args) throws Exception {
		String catalogName = "jesuisuncatalogue";
		String dashboardName = "jesuisundashboard";
		String visuName = "jesuisunevisu";
		String uri = "je suis une uri";
		ESB bus = new ESB();
		
		System.out.println("Step 1 : Declare a Catalog");
		bus.handle(new DeclareCatalogMsg(catalogName));
		
		System.out.println("Step 2 : Declare a Dashboard");
		bus.handle(new DeclareDashboardMsg(dashboardName));
		
		System.out.println("Step 3 : Link both");
		bus.handle(new LinkMsg(catalogName, dashboardName));
		
		System.out.println("Step 4 : Add a visu to the dashboard");
		bus.handle(new AddVisuMsg(dashboardName, visuName));
		
		System.out.println("Step 5 : Plug a data on this visualization");
		bus.handle(new PlugDataMsg(dashboardName, visuName, uri));
		
		System.out.println("Step 6 : Ending.");
	}
	

}
