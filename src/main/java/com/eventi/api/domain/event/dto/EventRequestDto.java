package com.eventi.api.domain.event.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

public record EventRequestDto(UUID id, String title, String description, MultipartFile image, Boolean remote, Date eventDate) {

}
