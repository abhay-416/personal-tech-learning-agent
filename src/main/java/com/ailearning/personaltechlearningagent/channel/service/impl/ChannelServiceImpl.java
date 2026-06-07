package com.ailearning.personaltechlearningagent.channel.service.impl;

import com.ailearning.personaltechlearningagent.channel.dto.ChannelRequest;
import com.ailearning.personaltechlearningagent.channel.dto.ChannelResponse;
import com.ailearning.personaltechlearningagent.channel.entity.Channel;
import com.ailearning.personaltechlearningagent.channel.mapper.ChannelMapper;
import com.ailearning.personaltechlearningagent.channel.repository.ChannelRepository;
import com.ailearning.personaltechlearningagent.channel.service.ChannelService;
import com.ailearning.personaltechlearningagent.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;
    private final ChannelMapper channelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ChannelResponse> getAllChannels() {
        return channelRepository.findAll().stream()
                .map(channelMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ChannelResponse getChannelById(Long id) {
        return channelMapper.toResponse(findChannelOrThrow(id));
    }

    @Override
    @Transactional
    public ChannelResponse createChannel(ChannelRequest request) {
        if (channelRepository.existsByChannelId(request.channelId())) {
            throw new IllegalArgumentException("Channel ID already exists");
        }
        Channel channel = channelMapper.toEntity(request);
        Channel savedChannel = channelRepository.save(channel);
        return channelMapper.toResponse(savedChannel);
    }

    @Override
    @Transactional
    public ChannelResponse updateChannel(Long id, ChannelRequest request) {
        Channel channel = findChannelOrThrow(id);

        if (!channel.getChannelId().equals(request.channelId()) &&
                channelRepository.existsByChannelId(request.channelId())) {
            throw new IllegalArgumentException("Channel ID already exists");
        }

        channelMapper.updateEntityFromRequest(request, channel);
        return channelMapper.toResponse(channelRepository.save(channel));
    }

    @Override
    @Transactional
    public void deleteChannel(Long id) {
        channelRepository.delete(findChannelOrThrow(id));
    }

    private Channel findChannelOrThrow(Long id) {
        return channelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Channel not found with id: " + id));
    }

}
