package com.hcms.hostelcomplaintmanagementsystem.jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccessDeniedHandler  {

    private final ObjectMapper objectMapper;


}
