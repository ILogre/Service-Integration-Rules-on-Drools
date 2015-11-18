package services.accesspoint;

import domain.SensorDeployment;
import message.BuildSensorHostingHierarchyMsg;
import message.DeclareCatalogMsg;
import message.IsDefinedAsw;
import message.IsDefinedMsg;
import message.RecordEventBasedSensorMsg;
import message.RecordPeriodicSensorMsg;
import message.SketchPatternMsg;

public class SensorDeploymentAP {

	
	public static void declareCatalog (DeclareCatalogMsg msg){
		SensorDeployment.declareCatalog(msg);
	}

	public static void buildSensorHostingHierarchy ( BuildSensorHostingHierarchyMsg msg){
		SensorDeployment.buildSensorHostingHierarchy(msg);
	}
	
	public static void recordPeriodicSensor ( RecordPeriodicSensorMsg msg ){
		SensorDeployment.recordPeriodicSensor(msg);
	}
	
	public static void recordEventBasedSensor ( RecordEventBasedSensorMsg msg ){
		SensorDeployment.recordEventBasedSensor(msg);
	}
	
	public static void sketchPattern ( SketchPatternMsg msg){
		SensorDeployment.sketchPattern(msg);
	}

	
	public static IsDefinedAsw isDefined ( IsDefinedMsg msg ) {
		return SensorDeployment.isDefined(msg);
		
	}
		
}