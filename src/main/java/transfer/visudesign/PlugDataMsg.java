package transfer.visudesign;

import transfer.Message;

public class PlugDataMsg extends Message {
	private String dashboardName;
	private String visuName;
	private String uri;

	public PlugDataMsg(String dashboardName, String visuName, String uri) {
		super();
		this.dashboardName = dashboardName;
		this.visuName = visuName;
		this.uri = uri;
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
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
}
