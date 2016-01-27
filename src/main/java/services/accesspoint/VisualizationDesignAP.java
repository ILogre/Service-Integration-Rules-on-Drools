package services.accesspoint;

import java.io.IOException;

import message.CharacterizeVisuMsg;
import message.DeclareDashboardMsg;
import message.PlugDataMsg;
import message.PositionMsg;
import transfer.IsValidatedAsw;
import transfer.IsValidatedMsg;
import transfer.ValidateAndPersistMsg;
import domain.VisualizationDesign;
import errors.UnknownDashboardException;

public class VisualizationDesignAP  {
	
	/*
	 * This proxy exposes the behavior of the Visualization Design domain accessible to the final user
	 * It is responsible for receiving the original message from the rule engine and transmit it to the domain implementation.
	 */
	
	public static void declareDashboard(DeclareDashboardMsg msg){
		VisualizationDesign.declareDashboard(msg);
	}
	
	public static void characterizeVisu(CharacterizeVisuMsg msg) throws UnknownDashboardException{
		VisualizationDesign.characterizeVisu(msg);
	}
	
	public static void plugData(PlugDataMsg msg) throws UnknownDashboardException{
		VisualizationDesign.plugData(msg);
	}
	
	public static void position(PositionMsg msg) throws UnknownDashboardException{
		VisualizationDesign.position(msg);
	}
	
	public static IsValidatedAsw isValidated(IsValidatedMsg msg){
		return VisualizationDesign.isValidated(msg);
	}
	
	public static void validateAndPersist(ValidateAndPersistMsg msg) throws IOException {
		VisualizationDesign.validateAndPersist(msg);
	}
}
