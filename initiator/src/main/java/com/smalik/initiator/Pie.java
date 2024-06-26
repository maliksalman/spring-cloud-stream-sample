package com.smalik.initiator;

import java.time.OffsetDateTime;
import java.util.UUID;

public record Pie(
        UUID id,
        OffsetDateTime time) {
}
