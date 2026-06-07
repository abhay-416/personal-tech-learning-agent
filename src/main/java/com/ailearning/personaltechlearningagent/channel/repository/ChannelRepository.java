package com.ailearning.personaltechlearningagent.channel.repository;

import com.ailearning.personaltechlearningagent.channel.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
    boolean existsByChannelId(String channelId);
}
