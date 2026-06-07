package com.ailearning.personaltechlearningagent.channel.dto;

import java.time.LocalDateTime;

public record ChannelResponse(
        Long id,
        String channelId,
        String channelName,
        String rssUrl,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
