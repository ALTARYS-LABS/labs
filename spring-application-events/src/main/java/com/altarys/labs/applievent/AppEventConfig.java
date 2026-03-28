package com.altarys.labs.applievent;

import com.altarys.labs.applievent.organization.*;
import com.altarys.labs.applievent.service.*;
import org.springframework.context.annotation.*;

@Configuration
public class AppEventConfig {

    @Bean
    ClientService clientService() {
        return new ClientService();
    }


    @Bean
    OrgStructureService orgStructureService() {
        return new OrgStructureService();
    }
}
