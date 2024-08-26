package com.eventi.api.mappers;

import com.eventi.api.domain.event.Event;
import com.eventi.api.domain.event.dto.EventRequestDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EventMapper {
    public Event toEntity(EventRequestDto dto, String imgUrl) {
        return new Event(
                dto.id(),
                dto.description(),
                dto.title(),
                imgUrl,
                dto.remote(),
                dto.eventDate());
    }
}
