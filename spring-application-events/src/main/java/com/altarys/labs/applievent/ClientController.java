package com.altarys.labs.applievent;


import com.altarys.labs.applievent.model.*;
import com.altarys.labs.applievent.resquest.*;
import com.altarys.labs.applievent.service.*;
import org.springframework.context.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
public record ClientController(
        ClientService clientService,
        ApplicationEventPublisher publisher
) {



   /* private final AbsencePolicyService absencePolicyService;
    private final AuditService auditService;*/

    @PostMapping
    public void createClient(@RequestBody ClientCreationRequest request) {
        AltarysClient client = clientService.saveClient(request);
        publisher.publishEvent(new ClientCreationEvent(client.name(), client.email()));
        // This service now depends on 4 other modules — it knows too much

    }


}