package com.smalik.initiator;

import java.time.OffsetDateTime;
import java.util.UUID;

public record Fruit(
        UUID id,
        OffsetDateTime time) {
}