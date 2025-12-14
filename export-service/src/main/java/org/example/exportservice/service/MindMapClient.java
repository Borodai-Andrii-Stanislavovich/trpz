package org.example.exportservice.service;

import org.example.exportservice.dto.MindMapDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MindMapClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${mindmap.service.url}")
    private String baseUrl;

    public MindMapDto getMindMap(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, MindMapDto.class);
    }
}
