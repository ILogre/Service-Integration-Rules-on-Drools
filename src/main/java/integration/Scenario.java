package integration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import message.BuildSensorHostingHierarchyMsg;
import message.CharacterizeVisuMsg;
import message.DeclareCatalogMsg;
import message.DeclareDashboardMsg;
import message.DescribeObservationPatternAsw;
import message.DescribeObservationPatternMsg;
import message.DescribeSensorAsw;
import message.DescribeSensorMsg;
import message.IsValidatedCatalogAsw;
import message.IsValidatedCatalogMsg;
import message.PlugDataMsg;
import message.RecordPeriodicSensorMsg;
import message.SearchAllObservationPatternsAsw;
import message.SearchAllObservationPatternsMsg;
import message.SearchAllSensorsAsw;
import message.SearchAllSensorsMsg;
import message.SketchPatternMsg;
import message.ValidateAndPersistCatalogMsg;
import transfer.Answer;
import transfer.Message;
import transfer.association.LinkMsg;
import businessobject.ContainerType;
import businessobject.Continuous;

public class Scenario {

	public static Map<Message, Answer> mailbox;
	public static ESB bus;
	public static Spy spy;

	public static void main(String[] args) throws Exception {
		String catalogName = "SophiaTech";
		String dashboardName = "WorkingConditions";
		spy = new Spy();

		int step = 0;

		bus = new ESB();
		mailbox = new HashMap<Message, Answer>();

		System.out.println("[Scenario - Step " + ++step
				+ "]: Declare a Catalog");
		bus.handle(new DeclareCatalogMsg(catalogName));

		System.out.println("[Scenario - Step " + ++step
				+ "]: Declare a Dashboard");
		bus.handle(new DeclareDashboardMsg(dashboardName));

		System.out.println("[Scenario - Step " + ++step + "]: Link both");
		bus.handle(new LinkMsg(catalogName, "Catalog", dashboardName,
				"Dashboard", true));

		System.out.println("[Scenario - Step " + ++step
				+ "]: Build an branch of the building hierarchy");
		LinkedHashMap<String, ContainerType> containers = new LinkedHashMap<String, ContainerType>();
		containers.put("Templier1", ContainerType.Building);
		containers.put("FourthFloor", ContainerType.Floor);
		containers.put("Office443", ContainerType.Room);
		containers.put("WallNorthEast", ContainerType.Wall);
		containers.put("WindowLeft", ContainerType.Window);
		bus.handle(new BuildSensorHostingHierarchyMsg(catalogName, containers));

		System.out.println("[Scenario - Step " + ++step
				+ "]: Sketch a new scheme of stored data");
		bus.handle(new SketchPatternMsg(catalogName, "SC_Temperature",
				new Continuous<Integer>("t", 0, Integer.MAX_VALUE),
				new Continuous<Integer>("v", Integer.MIN_VALUE,
						Integer.MAX_VALUE)));

		System.out.println("[Scenario - Step " + ++step
				+ "]: Expose a new periodic sensor");
		bus.handle(new RecordPeriodicSensorMsg(catalogName, "Office443",
				"tempin_443", "SC_Temperature", 2));
		System.out.println("[Scenario - Step " + ++step
				+ "]: Expose a new periodic sensor");
		bus.handle(new RecordPeriodicSensorMsg(catalogName, "Office443",
				"tempout_443", "SC_Temperature", 300));

		System.out.println("[Scenario - Step " + ++step
				+ "]: Check that the Catalog model is currently not validated");
		IsValidatedCatalogMsg failed = new IsValidatedCatalogMsg(catalogName);
		bus.handle(failed);
		IsValidatedCatalogAsw ansFailed = (IsValidatedCatalogAsw) mailbox
				.get(failed);
		System.out.println("Result: Catalog validation status = "
				+ ansFailed.isValidated());

		System.out.println("[Scenario - Step " + ++step
				+ "]: Validate and persist the Catalog model");
		bus.handle(new ValidateAndPersistCatalogMsg(catalogName));

		System.out.println("[Scenario - Step " + ++step
				+ "]: Check that the Catalog model is now validated");
		IsValidatedCatalogMsg success = new IsValidatedCatalogMsg(catalogName);
		bus.handle(success);
		IsValidatedCatalogAsw ansSuccess = (IsValidatedCatalogAsw) mailbox
				.get(success);
		System.out.println("Result: Catalog validation status = "
				+ ansSuccess.isValidated());

		System.out.println("[Scenario - Step " + ++step
				+ "]: List all the Observation patterns");
		SearchAllObservationPatternsMsg patterns = new SearchAllObservationPatternsMsg(
				catalogName);
		bus.handle(patterns);
		SearchAllObservationPatternsAsw patternsAsw = (SearchAllObservationPatternsAsw) mailbox
				.get(patterns);
		System.out.println(patternsAsw);

		System.out.println("[Scenario - Step " + ++step
				+ "]: List all the sensors in Office443");
		SearchAllSensorsMsg sensorsMsg = new SearchAllSensorsMsg(catalogName,
				"Office443");
		bus.handle(sensorsMsg);
		SearchAllSensorsAsw sensorsAsw = (SearchAllSensorsAsw) mailbox
				.get(sensorsMsg);
		System.out.println(sensorsAsw);

		System.out.println("[Scenario - Step " + ++step
				+ "]: Detail an Observation Pattern");
		DescribeObservationPatternMsg descOpPat = new DescribeObservationPatternMsg(
				catalogName, "SC_Temperature");
		bus.handle(descOpPat);
		DescribeObservationPatternAsw descOpPatAsw = (DescribeObservationPatternAsw) mailbox
				.get(descOpPat);
		System.out.println(descOpPatAsw);

		System.out.println("[Scenario - Step " + ++step
				+ "]: Describe a Sensor");
		DescribeSensorMsg descSensor = new DescribeSensorMsg(catalogName,
				"tempin_443");
		bus.handle(descSensor);
		DescribeSensorAsw descSensorAsw = (DescribeSensorAsw) mailbox
				.get(descSensor);
		System.out.println(descSensorAsw);

		System.out.println("[Scenario - Step " + ++step
				+ "]: Add a visu to the dashboard");
		bus.handle(new CharacterizeVisuMsg(dashboardName, "OfficeCooling",
				"Comparison", "Over_time"));

		System.out.println("[Scenario - Step " + ++step
				+ "]: Plug a data on this visualization");
		Map<String, Map<String, Object>> concerns = new HashMap<String, Map<String, Object>>();
		concerns.put("Continuous", null);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("min", 19);
		params.put("max", 29);
		concerns.put("Threshold", params);
		bus.handle(new PlugDataMsg(dashboardName, "OfficeCooling",
				"indoor_temperature", "Office443", "Temperature", concerns));

		System.out.println("[Scenario - Step " + ++step
				+ "]: Plug a data on this visualization");
		concerns = new HashMap<String, Map<String, Object>>();
		concerns.put("Continuous", null);
		bus.handle(new PlugDataMsg(dashboardName, "OfficeCooling",
				"tempout_443", "Office443", "Temperature", concerns));

		System.out.println("[Scenario - Step " + ++step
				+ "]: Check a sensor description");
		DescribeSensorMsg desc = new DescribeSensorMsg(catalogName,
				"tempin_443");
		bus.handle(desc);
		DescribeSensorAsw ansDesc = (DescribeSensorAsw) mailbox.get(desc);
		System.out
				.println("Result: Sensor description = " + ansDesc.toString());

		System.out.println("End of Scenario.\n Rules fired: "
				+ spy.getNbRulesExecuted() + "\n Messages sent by user : "
				+ step + "\n Rules internally triggered: "
				+ spy.getNbRulesInternalTrigger() + " (in domain : "
				+ spy.getNbInternallyTriggeredDomainRules()
				+ " - in auxiliaries "
				+ spy.getNbInternallyTriggeredAuxiliaryRules() + ")");

		clean(catalogName, dashboardName);
	}

	private static void clean(String... modelNames) throws IOException {
		for (String s : modelNames) {
			String fileName = "resources/" + s + ".xmi";
			File file = new File(fileName);
			Files.deleteIfExists(file.toPath());
		}
	}
}
