package transfer.visudesign;

import transfer.Message;

public class DeclareDashboardMsg extends Message {
	private String dashboardName;
	public DeclareDashboardMsg(String dashboardName) {
		super();
		this.dashboardName = dashboardName;
	}
	public String getDashboardName() {
		return dashboardName;
	}
	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}
}
