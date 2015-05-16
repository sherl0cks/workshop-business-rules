package com.redhat.brms;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class PremiumRulesRunner {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	Driver driver = new Driver();
        	//driver.setAge(age);
        	Quote quote = new Quote();
        	if (null != driver ){
        		kSession.insert(driver);
        	}
        	if (null != quote ){
        		kSession.insert(quote);
        	}
            //kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}