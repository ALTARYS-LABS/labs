package com.altarys.labs.applievent.organization;

import com.altarys.labs.applievent.*;
import org.springframework.context.event.*;

public record OrgStructureService() {

    @EventListener
    void createOrgStructure(ClientCreationEvent event) {
     IO.println("Client creation event received: " + event);
    }

}
