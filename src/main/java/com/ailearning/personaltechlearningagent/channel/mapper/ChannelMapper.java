package com.ailearning.personaltechlearningagent.channel.mapper;

import com.ailearning.personaltechlearningagent.channel.dto.ChannelRequest;
import com.ailearning.personaltechlearningagent.channel.dto.ChannelResponse;
import com.ailearning.personaltechlearningagent.channel.entity.Channel;
import org.springframework.stereotype.Component;

@Component
public class ChannelMapper {

    public Channel toEntity(ChannelRequest request) {
        Channel channel = new Channel();
        channel.setChannelId(request.channelId());
        channel.setChannelName(request.channelName());
        channel.setRssUrl(request.rssUrl());
        channel.setActive(request.active());
        return channel;
    }

    public ChannelResponse toResponse(Channel channel) {
        return new ChannelResponse(
                channel.getId(),
                channel.getChannelId(),
                channel.getChannelName(),
                channel.getRssUrl(),
                channel.isActive(),
                channel.getCreatedAt(),
                channel.getUpdatedAt()
        );
    }

    public void updateEntityFromRequest(ChannelRequest request, Channel channel) {
        channel.setChannelId(request.channelId());
        channel.setChannelName(request.channelName());
        channel.setRssUrl(request.rssUrl());
        channel.setActive(request.active());
    }
}
