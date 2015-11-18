package services.domains;

import message.BuildSensorHostingHierarchyMsg;
import message.DeclareCatalogMsg;
import message.IsDefinedAsw;
import message.IsDefinedMsg;
import message.RecordEventBasedSensorMsg;
import message.RecordPeriodicSensorMsg;
import message.SketchPatternMsg;

public class SensorDeploymentDomain {

	
	public static void declareCatalog (DeclareCatalogMsg msg){
		System.out.println("[Proxy]"+"DeclareCatalog"+"\t\t ("+System.currentTimeMillis()+" )");
	}

	public static void buildSensorHostingHierarchy ( BuildSensorHostingHierarchyMsg msg){
		System.out.println("[Proxy]"+"buildSensorHostingHierarchy"+"\t\t ("+System.currentTimeMillis()+" )");
	}
	
	public static void recordPeriodicSensor ( RecordPeriodicSensorMsg msg ){
		System.out.println("[Proxy]"+"recordPeriodicSensor"+"\t\t ("+System.currentTimeMillis()+" )");
	}
	
	public static void recordEventBasedSensor ( RecordEventBasedSensorMsg msg ){
		System.out.println("[Proxy]"+"recordEventBasedSensor"+"\t\t ("+System.currentTimeMillis()+" )");
	}
	
	public static void sketchPattern ( SketchPatternMsg msg){
		System.out.println("[Proxy]"+"sketchPattern"+"\t\t ("+System.currentTimeMillis()+" )");
	}

	
	public static IsDefinedAsw isDefined ( IsDefinedMsg msg ) {
		System.out.println("[Proxy]"+"isDefined"+"\t\t ("+System.currentTimeMillis()+" )");
		return new IsDefinedAsw(true);
	}
		
}