package com.altarys.labs.applievent.resquest;

public record ClientCreationRequest(
        String name,
        String email,
        String phone
) {
}
