package com.ailearning.personaltechlearningagent.channel.service;

import com.ailearning.personaltechlearningagent.channel.dto.ChannelRequest;
import com.ailearning.personaltechlearningagent.channel.dto.ChannelResponse;

import java.util.List;

public interface ChannelService {
    List<ChannelResponse> getAllChannels();

    ChannelResponse getChannelById(Long id);

    ChannelResponse createChannel(ChannelRequest request);

    ChannelResponse updateChannel(Long id, ChannelRequest request);

    void deleteChannel(Long id);
}
