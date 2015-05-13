package services.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import transfer.datacenter.DeclareCatalogMsg;
import transfer.datacenter.ExposeResourceMsg;
import transfer.datacenter.IsDefinedAsw;
import transfer.datacenter.IsDefinedMsg;


public class DataCenter {

	public static void declareCatalog(DeclareCatalogMsg msg){
		String catalogName = msg.getName();
		System.out.println("DataCenter : catalog \""+catalogName+"\" declared at "+System.currentTimeMillis());
		Container.getInstance().declareCatalog(new Catalog(catalogName));
	}
	
	public static void exposeResource(ExposeResourceMsg msg){
		String catalogName = msg.getCatalogName();
		String uri = msg.getUri();
		System.out.println("DataCenter : resource \""+uri+"\" exposed on catalog \""+catalogName+"\" at "+System.currentTimeMillis());
		Container.getInstance().getCatalog(catalogName).addResource(new Resource(uri, msg.getSemantic(), msg.getElems()));
	}
	
	public static IsDefinedAsw isDefined(IsDefinedMsg msg){
		String catalogName = msg.getCatalogName();
		String uri = msg.getUri();
		System.out.println("DataCenter : resource \""+uri+"\" existence checked on catalog \""+catalogName+"\" at "+System.currentTimeMillis());
		Catalog c = Container.getInstance().getCatalog(catalogName);
		
		return new IsDefinedAsw(c.getResource(uri)!=null);
	}
	
	private static class Container{
		private static Container instance;
		private List<Catalog> catalogs;
		private Container(){ this.catalogs = new ArrayList<Catalog>();}
		
		public static Container getInstance(){
			if(instance==null) instance=new Container();
			return instance;
		}
		public void declareCatalog(Catalog c){
			this.catalogs.add(c);
		}
		public Catalog getCatalog(String catalogName){
			for(Catalog c : catalogs)
				if(c.getName()==catalogName)
					return c;
			return null;
		}
		
	}
	
	private static class Catalog {
		private String name;
		private List<Resource> res;
		public Catalog(String name) {
			this.name = name;
			res = new ArrayList<Resource>();
		}
		public Resource getResource(String resUri) {
			for(Resource r : res)
				if(r.getUri()==resUri)
					return r;
			return null;
		}
		public void addResource(Resource r){this.res.add(r);}
		public String getName(){return this.name;}
	}
	
	private static class Resource {
		public String uri;
		public String semantic;
		public Map<String,String> elems;

		public Resource(String uri, String semantic,Map<String, String> elems) {
			super();
			this.uri = uri;
			this.semantic = semantic;
			this.elems = elems;
		}
		public String getUri() {
			return uri;
		}
	}
	
}
