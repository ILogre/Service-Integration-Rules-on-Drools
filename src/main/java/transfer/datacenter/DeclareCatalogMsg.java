package transfer.datacenter;

import transfer.Message;

public class DeclareCatalogMsg extends Message {
	public String name;

	public DeclareCatalogMsg(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
