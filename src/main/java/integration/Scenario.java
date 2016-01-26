package integration;

import java.util.HashMap;
import java.util.Map;

import message.CharacterizeVisuMsg;
import message.DeclareCatalogMsg;
import message.DeclareDashboardMsg;
import message.PlugDataMsg;
import transfer.Answer;
import transfer.Message;
import transfer.association.LinkMsg;

public class Scenario {
	
	public static Map<Message,Answer> mailbox;
	public static ESB bus;

	public static void main(String[] args) throws Exception {
		String catalogName = "test_catalogue";
		String dashboardName = "test_dashboard";
		String visuName = "test_visu";
		String dataName = "test_data";
		bus = new ESB();
		mailbox = new HashMap<Message, Answer>();
		
		
		
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
}
