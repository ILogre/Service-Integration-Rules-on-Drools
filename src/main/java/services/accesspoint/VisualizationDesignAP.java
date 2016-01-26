package services.accesspoint;

import domain.VisualizationDesign;
import message.CharacterizeVisuMsg;
import message.DeclareDashboardMsg;
import message.PlugDataMsg;
import message.PositionMsg;

public class VisualizationDesignAP  {
	
	/*
	 * This proxy exposes the behavior of the Visualization Design domain accessible to the final user
	 * It is responsible for receiving the original message from the rule engine and transmit it to the domain implementation.
	 */
	
	public static void declareDashboard(DeclareDashboardMsg msg){
		VisualizationDesign.declareDashboard(msg);
	}
	
	public static void characterizeVisu(CharacterizeVisuMsg msg){
		VisualizationDesign.characterizeVisu(msg);
	}
	
	public static void plugData(PlugDataMsg msg){
		VisualizationDesign.plugData(msg);
	}
	
	public static void position(PositionMsg msg){
		VisualizationDesign.position(msg);
	}
}
