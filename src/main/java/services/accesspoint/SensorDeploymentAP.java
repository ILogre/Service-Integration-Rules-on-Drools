package services.accesspoint;

import java.io.IOException;

import message.BuildSensorHostingHierarchyMsg;
import message.DeclareCatalogMsg;
import message.DescribeSensorAsw;
import message.DescribeSensorMsg;
import message.IsDefinedAsw;
import message.IsDefinedMsg;
import message.IsValidatedCatalogAsw;
import message.IsValidatedCatalogMsg;
import message.RecordEventBasedSensorMsg;
import message.RecordPeriodicSensorMsg;
import message.SearchAllSensorsAsw;
import message.SearchAllSensorsMsg;
import message.SketchPatternMsg;
import message.ValidateAndPersistCatalogMsg;
import domain.SensorDeployment;
import errors.UnknownCatalogException;
import errors.UnkonwnSensorException;
import errors.UnreachableCodeException;

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

	public static IsDefinedAsw isDefined ( IsDefinedMsg msg ) throws UnknownCatalogException {
		return SensorDeployment.isDefined(msg);
	}
	
	public static void validateAndPersist(ValidateAndPersistCatalogMsg msg) throws IOException {
		SensorDeployment.validateAndPersist(msg);
	}
	
	public static IsValidatedCatalogAsw isValidated(IsValidatedCatalogMsg msg){
		return SensorDeployment.isValidated(msg);
	}
	
	public static DescribeSensorAsw describeSensor(DescribeSensorMsg msg) throws UnknownCatalogException, UnkonwnSensorException, UnreachableCodeException{
		return SensorDeployment.describeSensor(msg);
	}
	
	public static SearchAllSensorsAsw searchAllSensors(SearchAllSensorsMsg msg){
		return SensorDeployment.searchAllSensors(msg);
	}

}