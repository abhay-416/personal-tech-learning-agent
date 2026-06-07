package com.ailearning.personaltechlearningagent.channel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public record ChannelRequest(
        @NotBlank(message = "Channel ID is required")
        String channelId,

        @NotBlank(message = "Channel name is required")
        String channelName,

        @NotBlank(message = "RSS URL is required")
        @URL(message = "Must be a valid URL")
        String rssUrl,

        @NotNull(message = "Active status is required")
        Boolean active
) {
}
