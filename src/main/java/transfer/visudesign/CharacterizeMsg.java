package transfer.visudesign;

import java.util.HashMap;
import java.util.Map;

import transfer.Message;

public class CharacterizeMsg extends Message {
	private String dashboardName;
	private String visuName;
	private Map<String, Map<String,Object>> concerns;

	public CharacterizeMsg(String dashboardName, String visuName, String concern, Map<String,Object> params) {
		super();
		this.dashboardName = dashboardName;
		this.visuName = visuName;
		this.concerns= new HashMap<String, Map<String,Object>>();
		concerns.put(concern, params);
	}
	public CharacterizeMsg(String dashboardName, String visuName,
			Map<String, Map<String, Object>> concerns) {
		super();
		this.dashboardName = dashboardName;
		this.visuName = visuName;
		this.concerns = concerns;
	}
	public String getDashboardName() {
		return dashboardName;
	}
	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}
	public String getVisuName() {
		return visuName;
	}
	public void setVisuName(String visuName) {
		this.visuName = visuName;
	}
	public Map<String, Map<String, Object>> getConcerns() {
		
		
		return concerns;
	}
	public void setConcerns(Map<String, Map<String, Object>> concerns) {
		this.concerns = concerns;
	}

}
