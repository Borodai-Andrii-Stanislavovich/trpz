package org.example.exportservice.controller;

import org.example.exportservice.dto.MindMapDto;
import org.example.exportservice.service.ExportService;
import org.example.exportservice.service.MindMapClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/export")
public class ExportController {

    private final MindMapClient client;
    private final ExportService service;
    private final ObjectMapper mapper = new ObjectMapper();

    public ExportController(MindMapClient client, ExportService service) {
        this.client = client;
        this.service = service;
    }

    @GetMapping("/{id}/txt")
    public String exportTxt(@PathVariable Long id) {
        MindMapDto map = client.getMindMap(id);
        return service.exportTxt(map);
    }

    @GetMapping("/{id}/csv")
    public String exportCsv(@PathVariable Long id) {
        MindMapDto map = client.getMindMap(id);
        return service.exportCsv(map);
    }

    @GetMapping("/{id}/json")
    public String exportJson(@PathVariable Long id) throws Exception {
        MindMapDto map = client.getMindMap(id);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
    }
}
