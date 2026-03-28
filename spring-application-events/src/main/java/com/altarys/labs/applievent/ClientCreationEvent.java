package com.altarys.labs.applievent;

public record ClientCreationEvent(
        String name,
        String email
) {
}
