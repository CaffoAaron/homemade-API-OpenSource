package com.acme.homemade.demo;

import com.acme.homemade.demo.domain.reposiroty.PublicationRepository;
import com.acme.homemade.demo.domain.reposiroty.UserNoChefRepository;
import com.acme.homemade.demo.domain.service.PublicationService;
import com.acme.homemade.demo.service.PublicationServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PublicationServiceImpIntegrationTest {
    @MockBean
    private PublicationRepository publicationRepository;

    @MockBean
    private UserNoChefRepository userNoChefRepository;

    @Autowired
    private PublicationService publicationService;



    @TestConfiguration
    static class  PublicationServiceImpTestConfiguration {
        @Bean
        public PublicationService publicationService(){
            return new PublicationServiceImpl();
        }
    }
}
