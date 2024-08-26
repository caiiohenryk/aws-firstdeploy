package com.eventi.api.services.implementations;

import com.eventi.api.domain.event.Event;
import com.eventi.api.domain.event.dto.EventRequestDto;
import com.eventi.api.mappers.EventMapper;
import com.eventi.api.services.EventService;
import org.springframework.web.multipart.MultipartFile;

public class EventServiceImpl implements EventService {

    private static EventMapper mapper;

    @Override
    public Event createEvent(EventRequestDto dto) {
        String imgUrl = null;
        if(dto.image() != null) {
            imgUrl = this.uploadImg(dto.image());
        }
        mapper.toEntity(dto, imgUrl);
        return null;
    }

    private String uploadImg(MultipartFile file) {
        return "";
    }
}
