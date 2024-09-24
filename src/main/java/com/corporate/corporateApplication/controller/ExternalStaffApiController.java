package com.corporate.corporateApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/external/staff")
public class ExternalStaffApiController {

    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ExternalStaffApiController.class);

    @Value("${external.api.base-url}")
    private String baseUrl;

    @Autowired
    public ExternalStaffApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createStaff(@RequestBody String staffPayload) {
        String url = baseUrl + "/api/staff";
        logger.info("Calling external API to create staff: {}", url);
        logger.debug("Payload: {}", staffPayload);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(staffPayload, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        logger.info("Received response from external API: {}", response.getStatusCode());

        return response;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStaff(@PathVariable String id, @RequestBody String staffPayload) {
        String url = baseUrl + "/api/staff/" + id;
        logger.info("Calling external API to update staff with ID: {}", id);
        logger.debug("Payload: {}", staffPayload);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(staffPayload, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        logger.info("Received response from external API: {}", response.getStatusCode());

        return response;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getStaffById(@PathVariable String id) {
        String url = baseUrl + "/api/staff/" + id;
        logger.info("Calling external API to get staff with ID: {}", id);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        logger.info("Received response from external API: {}", response.getStatusCode());

        return response;
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllStaffs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        String url = baseUrl + "/api/staff?page=" + page + "&size=" + size;
        logger.info("Calling external API to get all staff with pagination, page: {}, size: {}", page, size);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        logger.info("Received response from external API: {}", response.getStatusCode());

        return response;
    }
}
