package services.domainproxies;

import integration.Scenario;
import message.BuildSensorHostingHierarchyMsg;
import message.DeclareCatalogMsg;
import message.DescribeObservationPatternAsw;
import message.DescribeObservationPatternMsg;
import message.DescribeSensorAsw;
import message.DescribeSensorMsg;
import message.IsDefinedAsw;
import message.IsDefinedMsg;
import message.RecordEventBasedSensorMsg;
import message.RecordPeriodicSensorMsg;
import message.SearchAllObservationPatternsAsw;
import message.SearchAllObservationPatternsMsg;
import message.SearchAllSensorsAsw;
import message.SearchAllSensorsMsg;
import message.SearchSensorsByObservationPatternAsw;
import message.SearchSensorsByObservationPatternMsg;
import message.SketchPatternMsg;
import transfer.Answer;
import errors.UnknownCatalogException;
import errors.UnknownObservationPatternException;

public class SensorDeploymentDP {

	/*
	 * This proxy exposes the behavior of the Sensor Deployment domain
	 * accessible to the rule engine It is responsible for receiving information
	 * from the rule engine and transmit the message on the bus.
	 */

	public static void declareCatalog(DeclareCatalogMsg msg) {
		System.out.println("[Proxy] " + "DeclareCatalog" + "\t\t ("
				+ System.currentTimeMillis() + " )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
	}

	public static void buildSensorHostingHierarchy(
			BuildSensorHostingHierarchyMsg msg) {
		System.out.println("[Proxy] " + "buildSensorHostingHierarchy"
				+ "\t\t (" + System.currentTimeMillis() + " )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
	}

	public static void recordPeriodicSensor(RecordPeriodicSensorMsg msg) {
		System.out.println("[Proxy] " + "recordPeriodicSensor" + "\t\t ("
				+ System.currentTimeMillis() + " )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
	}

	public static void recordEventBasedSensor(RecordEventBasedSensorMsg msg) {
		System.out.println("[Proxy] " + "recordEventBasedSensor" + "\t\t ("
				+ System.currentTimeMillis() + " )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
	}

	public static void sketchPattern(SketchPatternMsg msg) {
		System.out.println("[Proxy] " + "sketchPattern" + "\t\t ("
				+ System.currentTimeMillis() + " )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
	}

	public static IsDefinedAsw isDefined(IsDefinedMsg msg) {
		System.out.println("[Proxy] " + "isDefined" + "\t\t ("
				+ System.currentTimeMillis() + " )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
		Answer ans = Scenario.mailbox.get(msg);
		return (IsDefinedAsw) ans;
	}

	public static DescribeSensorAsw describeSensor(DescribeSensorMsg msg) {
		System.out.println("[Proxy] " + "describeSensor" + "\t\t ("
				+ System.currentTimeMillis() + " )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
		Answer ans = Scenario.mailbox.get(msg);
		return (DescribeSensorAsw) ans;
	}

	public static SearchAllSensorsAsw searchAllSensors(SearchAllSensorsMsg msg) {
		System.out.println("[Proxy] " + "searchAllSensors" + "\t\t ("
				+ System.currentTimeMillis() + " )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
		Answer ans = Scenario.mailbox.get(msg);
		return (SearchAllSensorsAsw) ans;
	}

	public static DescribeObservationPatternAsw describeObservationPattern(
			DescribeObservationPatternMsg msg) throws UnknownCatalogException,
			UnknownObservationPatternException {
		System.out.println("[Proxy] " + "describeObservationPattern" + "\t\t ("
				+ System.currentTimeMillis() + " )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
		Answer ans = Scenario.mailbox.get(msg);
		return (DescribeObservationPatternAsw) ans;
	}

	public static SearchAllObservationPatternsAsw searchAllObservationPatterns(
			SearchAllObservationPatternsMsg msg) throws UnknownCatalogException {
		System.out.println("[Proxy] " + "searchAllObservationPatterns"
				+ "\t\t (" + System.currentTimeMillis() + " )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
		Answer ans = Scenario.mailbox.get(msg);
		return (SearchAllObservationPatternsAsw) ans;
	}

	public static SearchSensorsByObservationPatternAsw searchSensorsByObservationPattern(
			SearchSensorsByObservationPatternMsg msg)
			throws UnknownCatalogException {
		System.out.println("[Proxy] " + "searchSensorsByObservationPattern"
				+ "\t\t (" + System.currentTimeMillis() + " )");
		Scenario.spy.increaseInternallyTriggeredDomainRules();
		Scenario.bus.handle(msg);
		Answer ans = Scenario.mailbox.get(msg);
		return (SearchSensorsByObservationPatternAsw) ans;
	}

}