package transfer.visudesign;

import transfer.Message;

public class AddVisuMsg extends Message {
	private String dashboardName;
	private String visuName;

	public AddVisuMsg(String dashboardName, String visuName) {
		super();
		this.dashboardName = dashboardName;
		this.visuName = visuName;
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
}
