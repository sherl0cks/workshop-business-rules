package com.redhat.brms;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class PremiumRulesRunner {
	
	static KieSession ksession;
	
    public static final void main(String[] args) {
        try {
            // load up the knowledge base
        	ksession = readKnowledgeBase();
        	
        	Driver driver = new Driver();
        	driver.setAge(30);
        	driver.setCity("Raleigh");
        	Quote quote = new Quote();
        	Vehicle vehicle = new Vehicle();
        	vehicle.setMake("BMW");
        	if (null != driver ){
        		ksession.insert(driver);
        	}
        	if (null != vehicle ){
        		ksession.insert(vehicle);
        	}
        	if (null != quote ){
        		ksession.insert(quote);
        	}
        	ksession.startProcess("InsurancePremiumRuleFlow");
        	ksession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        ksession.dispose();
    }
	private static KieSession readKnowledgeBase() throws Exception {
		
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
	    KieSession kSession = kContainer.newKieSession();
		
		return kSession;
	}
}