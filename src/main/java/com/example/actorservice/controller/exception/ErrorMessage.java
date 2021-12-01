package com.example.actorservice.controller.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.net.URL;
import java.time.LocalDate;


@RequiredArgsConstructor
@Getter
public class ErrorMessage {
    private final String message;
    private final String url;
    private LocalDate date = LocalDate.now();
}
