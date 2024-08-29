package com.eventi.api.domain.event.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record EventRequestDto(String title, String description, MultipartFile image, Boolean remote, Long eventDate) {

}
