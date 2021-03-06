package services.accesspoint;

import java.io.IOException;

import message.CharacterizeVisuMsg;
import message.DeclareDashboardMsg;
import message.IsValidatedDashboardAsw;
import message.IsValidatedDashboardMsg;
import message.PlugDataMsg;
import message.PositionMsg;
import message.ValidateAndPersistDashboardMsg;
import domain.VisualizationDesign;
import errors.UnknownDashboardException;

public class VisualizationDesignAP  {
	
	/*
	 * This access point exposes the behavior of the Visualization Design domain accessible to the final user
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
	
	public static IsValidatedDashboardAsw isValidated(IsValidatedDashboardMsg msg){
		return VisualizationDesign.isValidated(msg);
	}
	
	public static void validateAndPersist(ValidateAndPersistDashboardMsg msg) throws IOException {
		VisualizationDesign.validateAndPersist(msg);
	}
}
