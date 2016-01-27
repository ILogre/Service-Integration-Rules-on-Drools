package services.domainproxies;

import transfer.Answer;
import integration.Scenario;
import message.BuildSensorHostingHierarchyMsg;
import message.DeclareCatalogMsg;
import message.IsDefinedAsw;
import message.IsDefinedMsg;
import message.RecordEventBasedSensorMsg;
import message.RecordPeriodicSensorMsg;
import message.SketchPatternMsg;

public class SensorDeploymentDomainProxy {

/*
 * This proxy exposes the behavior of the Sensor Deployment domain accessible to the rule engine
 * It is responsible for receiving information from the rule engine and transmit the message on the bus.
 */
	
	public static void declareCatalog (DeclareCatalogMsg msg){
		System.out.println("[Proxy]"+"DeclareCatalog"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.bus.handle(msg);
	}

	public static void buildSensorHostingHierarchy ( BuildSensorHostingHierarchyMsg msg){
		System.out.println("[Proxy]"+"buildSensorHostingHierarchy"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.bus.handle(msg);
	}
	
	public static void recordPeriodicSensor ( RecordPeriodicSensorMsg msg ){
		System.out.println("[Proxy]"+"recordPeriodicSensor"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.bus.handle(msg);
	}
	
	public static void recordEventBasedSensor ( RecordEventBasedSensorMsg msg ){
		System.out.println("[Proxy]"+"recordEventBasedSensor"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.bus.handle(msg);
	}
	
	public static void sketchPattern ( SketchPatternMsg msg){
		System.out.println("[Proxy]"+"sketchPattern"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.bus.handle(msg);
	}

	
	public static IsDefinedAsw isDefined ( IsDefinedMsg msg ) {
		System.out.println("[Proxy]"+"isDefined"+"\t\t ("+System.currentTimeMillis()+" )");
		Scenario.bus.handle(msg);
		Answer ans = Scenario.mailbox.get(msg);
		return (IsDefinedAsw) ans;
	}
		
}