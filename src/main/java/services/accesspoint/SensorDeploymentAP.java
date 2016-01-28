package services.accesspoint;

import java.io.IOException;

import message.BuildSensorHostingHierarchyMsg;
import message.DeclareCatalogMsg;
import message.IsDefinedAsw;
import message.IsDefinedMsg;
import message.IsValidatedCatalogAsw;
import message.IsValidatedCatalogMsg;
import message.RecordEventBasedSensorMsg;
import message.RecordPeriodicSensorMsg;
import message.SketchPatternMsg;
import message.ValidateAndPersistCatalogMsg;
import domain.SensorDeployment;
import errors.UnknownCatalogException;

public class SensorDeploymentAP {

	/*
	 * This access point exposes the behavior of the Sensor Deployment domain accessible to the final user
	 * It is responsible for receiving the original message from the rule engine and transmit it to the domain implementation.
	 */
	
	public static void declareCatalog (DeclareCatalogMsg msg){
		SensorDeployment.declareCatalog(msg);
	}

	public static void buildSensorHostingHierarchy ( BuildSensorHostingHierarchyMsg msg) throws UnknownCatalogException{
		SensorDeployment.buildSensorHostingHierarchy(msg);
	}
	
	public static void recordPeriodicSensor ( RecordPeriodicSensorMsg msg ) throws UnknownCatalogException{
		SensorDeployment.recordPeriodicSensor(msg);
	}
	
	public static void recordEventBasedSensor ( RecordEventBasedSensorMsg msg ) throws UnknownCatalogException{
		SensorDeployment.recordEventBasedSensor(msg);
	}
	
	public static void sketchPattern ( SketchPatternMsg msg) throws UnknownCatalogException{
		SensorDeployment.sketchPattern(msg);
	}

	public static IsDefinedAsw isDefined ( IsDefinedMsg msg ) {
		return SensorDeployment.isDefined(msg);
	}
	
	public static void validateAndPersist(ValidateAndPersistCatalogMsg msg) throws IOException {
		SensorDeployment.validateAndPersist(msg);
	}
	
	public static IsValidatedCatalogAsw isValidated(IsValidatedCatalogMsg msg){
		return SensorDeployment.isValidated(msg);
	}
		
}