package com.eventi.api.mappers;

import com.eventi.api.domain.event.Event;
import com.eventi.api.domain.event.dto.EventRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component

public class EventMapper {
    public Event toEntity(EventRequestDto dto, String imgUrl) {
        Event newEvent = new Event();
        newEvent.setDescription(dto.description());
        newEvent.setTitle(dto.title());
        newEvent.setRemote(dto.remote());
        newEvent.setEventDate(new Date(dto.eventDate()));
        newEvent.setImgUrl(imgUrl);
        return newEvent;
    }
}
