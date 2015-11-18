package services.domains;

import message.CharacterizeVisuMsg;
import message.DeclareDashboardMsg;
import message.PlugDataMsg;
import message.PositionMsg;

public class VisualizationDesignDomain  {
	
	public static void declareDashboard(DeclareDashboardMsg msg){
		System.out.println("[Proxy]"+"declareDashboard"+"\t\t ("+System.currentTimeMillis()+" )");
	}
	
	public static void characterizeVisu(CharacterizeVisuMsg msg){
		System.out.println("[Proxy]"+"characterizeVisu"+"\t\t ("+System.currentTimeMillis()+" )");
	}
	
	public static void plugData(PlugDataMsg msg){
		System.out.println("[Proxy]"+"plugData"+"\t\t ("+System.currentTimeMillis()+" )");
	}
	
	public static void position(PositionMsg msg){
		System.out.println("[Proxy]"+"position"+"\t\t ("+System.currentTimeMillis()+" )");
	}
}
