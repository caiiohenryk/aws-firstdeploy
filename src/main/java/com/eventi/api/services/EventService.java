package com.eventi.api.services;

import com.eventi.api.domain.event.Event;
import com.eventi.api.domain.event.dto.EventRequestDto;
import com.sun.jdi.request.EventRequest;

public interface EventService {
    public Event createEvent(EventRequestDto dto);
}
