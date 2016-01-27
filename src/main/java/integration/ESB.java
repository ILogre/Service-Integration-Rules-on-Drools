package integration;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import transfer.Answer;
import transfer.Message;

public class ESB {
	
	//private KieSession kSession;

	public ESB(){

	}
	
	public Answer handle(Message msg){
        try {
	        KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
		    KieSession kSession = kContainer.newKieSession("ksession-rules");
	        kSession.insert(msg);
	        kSession.insert(Scenario.mailbox);
	        kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
		return new Answer(); //TODO how to ?
	}
	
}