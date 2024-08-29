package com.eventi.api.controllers;

import com.eventi.api.domain.event.Event;
import com.eventi.api.domain.event.dto.EventRequestDto;
import com.eventi.api.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Event> postEvent(@RequestParam("title") String title,
                                           @RequestParam("description") String description,
                                           @RequestParam("image") MultipartFile image,
                                           @RequestParam("date") Long date,
                                           @RequestParam("remote") Boolean remote) {
        EventRequestDto requestDto = new EventRequestDto(title, description, image, remote, date);
        return ResponseEntity.ok(eventService.createEvent(requestDto));
    }

}
