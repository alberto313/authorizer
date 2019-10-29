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
 * @author Z749313
 *
 */
@Configuration
@ComponentScan("com.exercise.service")
public class BusinessRulesContainerConfiguration {

	
	private KieServices kieServices = KieServices.Factory.get();
	
	private static final List<String> rules = Arrays.asList("ACCOUNT_RULE.drl");
	
	@Bean
	public KieContainer kieContainer() throws IOException {
        getKieRepository();

        KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
        kb.buildAll();

        KieModule kieModule = kb.getKieModule();
        KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        return kContainer;

    }
	
	private KieFileSystem getKieFileSystem() throws IOException {
		
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		for (String rule: rules) {
			kieFileSystem.write(ResourceFactory.newClassPathResource(rule));
		}
		
		return kieFileSystem;
	}
	
	private void getKieRepository() {
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(new KieModule() {
                        public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }
}
