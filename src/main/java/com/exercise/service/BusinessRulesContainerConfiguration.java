/**
 * 
 */
package com.exercise.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Business rules container thar will be in memory with the rules defined in .drl file(s)
 */
@Configuration
@ComponentScan("com.exercise.service")
public class BusinessRulesContainerConfiguration {

	
	/**
	 * New instance of kie service
	 */
	private KieServices kieServices = KieServices.Factory.get();
	
	/**
	 * List of .drl files that contains all rules defined to be applied on the business
	 */
	private static final List<String> rules = Arrays.asList("ACCOUNT_RULE.drl", "TRANSACTION_RULE.drl");
	
	/**
	 * Cointainer of rules
	 * @return
	 * @throws IOException
	 */
	@Bean
	public KieContainer kieContainer() throws IOException {
        getKieRepository();

        KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
        kb.buildAll();

        KieModule kieModule = kb.getKieModule();
        KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        return kContainer;

    }
	
	/**
	 * Gets the filesystem of files that contains the rules files
	 * @return
	 * @throws IOException
	 */
	private KieFileSystem getKieFileSystem() throws IOException {
		
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		for (String rule: rules) {
			kieFileSystem.write(ResourceFactory.newClassPathResource(rule));
		}
		
		return kieFileSystem;
	}
	
	/**
	 * Create kierepository of rules
	 */
	private void getKieRepository() {
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(new KieModule() {
                        public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }
}
