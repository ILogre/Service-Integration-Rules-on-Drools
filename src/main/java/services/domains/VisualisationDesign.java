package services.domains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import transfer.datacenter.DeclareCatalogMsg;
import transfer.visudesign.AddVisuMsg;
import transfer.visudesign.CharacterizeMsg;
import transfer.visudesign.PlugDataMsg;

public class VisualisationDesign {
	
	public static void declareDashboard(DeclareCatalogMsg msg){
		String name = msg.getName();
		System.out.println("VisuDesign : dashboard \""+name+"\" declared at "+System.currentTimeMillis());
		Container.getInstance().exposeDashboard(new Dashboard(name));
	}
	
	//TODO add param to handle the spatial composition
	public static void addVisu(AddVisuMsg msg){
		String dashboardName = msg.getDashboardName();
		String visuName = msg.getVisuName();
		System.out.println("VisuDesign : visualization \""+visuName+"\" added to dashboard \""
				+dashboardName+"\" at "+System.currentTimeMillis());
		Container.getInstance().getDashboard(dashboardName).addVisu(new Visualization(visuName));
	}
	
	public static void plugData(PlugDataMsg msg){ //, Map<String, Map<String,Object>> concerns
		String dashboardName = msg.getDashboardName();
		String visuName = msg.getVisuName();
		String uri = msg.getUri();
		System.out.println("VisuDesign : data \""+uri+"\" pluged on visualization \""+visuName+"\" at "+System.currentTimeMillis());
		Container.getInstance().getDashboard(dashboardName).getVisu(visuName).addData(uri);
	}
	
	public static void characterize(CharacterizeMsg msg){
		String dashboardName = msg.getDashboardName();
		String visuName = msg.getVisuName();
		Map<String, Map<String, Object>> concerns = msg.getConcerns();
		System.out.println("VisuDesign : visualization \""+visuName+"\" characterized by "+msg.getConcerns()
				+" at "+System.currentTimeMillis());
		
		Visualization v = Container.getInstance().getDashboard(dashboardName).getVisu(visuName);
		for(String concern : concerns.keySet())
			v.addConcern(new Concern(concern,concerns.get(concern)));
			
	}
	
	private static class Container{
		private static Container instance;
		private List<Dashboard> dashboards;
		private Container(){ this.dashboards = new ArrayList<VisualisationDesign.Dashboard>();}
		
		public static Container getInstance(){
			if(instance==null) instance=new Container();
			return instance;
		}
		public void exposeDashboard(Dashboard d){
			this.dashboards.add(d);
		}
		public Dashboard getDashboard(String dashboardName){
			for(Dashboard d : dashboards)
				if(d.getName()==dashboardName)
					return d;
			return null;
		}
		
	}
	
	private static class Dashboard {
		private String name;
		private List<Visualization> visus;
		public Dashboard(String name) {
			this.name = name;
			visus = new ArrayList<Visualization>();
		}
		public Visualization getVisu(String visuName) {
			for(Visualization v : visus)
				if(v.getName()==visuName)
					return v;
			return null;
		}
		public void addVisu(Visualization v){this.visus.add(v);}
		public Boolean hasVisu(Visualization v){ return this.visus.contains(v);}
		public String getName(){return this.name;}
	}
	
	private static class Visualization {
		private String name;
		private List<String> data;
		private List<Concern> concerns;
		
		public Visualization(String name) {
			this.name = name;
			data = new ArrayList<String>();
			concerns = new ArrayList<Concern>();
		}
		public String getName() {
			return name;
		}
		public void addData(String uri){this.data.add(uri);}
		public void addConcern(Concern c){this.concerns.add(c);}
	}
	
	private static class Concern {
		private String name;
		private Map<String,Object> params;
		
		public Concern(String name) {
			this.name = name;
			params = new HashMap<String,Object>();
		}

		public Concern(String name, Map<String,Object> params) {
			this(name);
			this.params.putAll(params);
		}
	}
}
