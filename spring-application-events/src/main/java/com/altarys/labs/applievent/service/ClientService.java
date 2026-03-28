package com.altarys.labs.applievent.service;

import com.altarys.labs.applievent.model.*;
import com.altarys.labs.applievent.resquest.*;

public record ClientService() {

    public AltarysClient saveClient(ClientCreationRequest client) {
        return new AltarysClient(client.name(), client.email(), client.phone());
    }
}
