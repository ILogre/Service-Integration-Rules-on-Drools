package integration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import message.BuildSensorHostingHierarchyMsg;
import message.CharacterizeVisuMsg;
import message.DeclareCatalogMsg;
import message.DeclareDashboardMsg;
import message.PlugDataMsg;
import message.RecordPeriodicSensorMsg;
import message.SketchPatternMsg;
import businessobject.ContainerType;
import businessobject.Continuous;
import transfer.Answer;
import transfer.Message;
import transfer.association.LinkMsg;

public class Scenario {

	public static Map<Message, Answer> mailbox;
	public static ESB bus;

	public static void main(String[] args) throws Exception {
		String catalogName = "SophiaTech";
		String dashboardName = "WorkingConditions";

		bus = new ESB();
		mailbox = new HashMap<Message, Answer>();

		System.out.println("Step 1 : Declare a Catalog");
		bus.handle(new DeclareCatalogMsg(catalogName));

		System.out.println("Step 2 : Declare a Dashboard");
		bus.handle(new DeclareDashboardMsg(dashboardName));

		System.out.println("Step 3 : Link both");
		bus.handle(new LinkMsg(catalogName, dashboardName, true));

		System.out.println("Step 4 : Build an branch of the building hierarchy");
		LinkedHashMap<String, ContainerType> containers = new LinkedHashMap<String, ContainerType>();
		containers.put("Templier1", ContainerType.Building);
		containers.put("FourthFloor", ContainerType.Floor);
		containers.put("Office443", ContainerType.Room);
		containers.put("WallNorthEast", ContainerType.Wall);
		containers.put("WindowLeft", ContainerType.Window);
		bus.handle(new BuildSensorHostingHierarchyMsg(catalogName, containers));

		System.out.println("Step 5 : Sketch a new scheme of stored data");
		bus.handle(new SketchPatternMsg(catalogName, "SC_Temperature",
				new Continuous<Integer>("t", 0, Integer.MAX_VALUE),
				new Continuous<Integer>("v", Integer.MIN_VALUE,
						Integer.MAX_VALUE)));

		System.out.println("Step 6 : Expose a new periodic sensor");
		bus.handle(new RecordPeriodicSensorMsg(catalogName, "Office443",
				"tempin_443", "SC_Temperature", 2));
		System.out.println("Step 6bis : Expose a new periodic sensor");
		bus.handle(new RecordPeriodicSensorMsg(catalogName, "Office443",
				"tempout_443", "SC_Temperature", 300));

		System.out.println("Step 7 : Add a visu to the dashboard");
		bus.handle(new CharacterizeVisuMsg(dashboardName, "OfficeCooling", "Comparison", "Over_time"));

		System.out.println("Step 8 : Plug a data on this visualization");
		Map<String, Map<String, Object>> concerns = new HashMap<String, Map<String, Object>>();
		concerns.put("Continuous", null);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("min", 19);
		params.put("max", 29);
		concerns.put("Threshold", params);
		bus.handle(new PlugDataMsg(dashboardName, "OfficeCooling", "indoor_temperature", concerns));

		System.out.println("Step 7 : Ending.");
	}
}
