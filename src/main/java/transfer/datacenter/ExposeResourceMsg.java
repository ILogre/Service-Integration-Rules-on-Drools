package transfer.datacenter;

import java.util.Map;

import transfer.Message;

public class ExposeResourceMsg extends Message {
	public String catalogName;
	public String uri;
	public String semantic;
	public Map<String,String> elems;

	public ExposeResourceMsg(String catalogName, String uri, String semantic,
			Map<String, String> elems) {
		super();
		this.catalogName = catalogName;
		this.uri = uri;
		this.semantic = semantic;
		this.elems = elems;
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

	public String getSemantic() {
		return semantic;
	}

	public void setSemantic(String semantic) {
		this.semantic = semantic;
	}

	public Map<String, String> getElems() {
		return elems;
	}

	public void setElems(Map<String, String> elems) {
		this.elems = elems;
	}
	
	
}
