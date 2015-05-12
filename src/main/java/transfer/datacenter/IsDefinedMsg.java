package transfer.datacenter;

import transfer.Message;

public class IsDefinedMsg extends Message {
	public String catalogName;
	public String uri;

	public IsDefinedMsg(String catalogName, String uri) {
		super();
		this.catalogName = catalogName;
		this.uri = uri;
	}

	public String getName() {
		return catalogName;
	}

	public void setName(String name) {
		this.catalogName = name;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
