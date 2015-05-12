package services.domains;

import transfer.datacenter.DeclareCatalogMsg;
import transfer.datacenter.ExposeResourceMsg;
import transfer.datacenter.IsDefinedAsw;
import transfer.datacenter.IsDefinedMsg;


public class DataCenter {

	public static void declareCatalog(DeclareCatalogMsg msg){
		System.out.println("DataCenter : catalog \""+msg.getName()+"\" declared at "+System.currentTimeMillis());
	}
	
	public static void exposeResource(ExposeResourceMsg msg){
		System.out.println("DataCenter : resource \""+msg.getUri()+"\" exposed on catalog \""+msg.getCatalogName()
				+"\" at "+System.currentTimeMillis());
	}
	
	public static IsDefinedAsw isDefined(IsDefinedMsg msg){
		System.out.println("DataCenter : resource \""+msg.getUri()+"\" existence checked on catalog \""
				+msg.getCatalogName()+"\" at "+System.currentTimeMillis());
		return new IsDefinedAsw(false);
	}
	
}
