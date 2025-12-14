package org.example.exportservice.service;

import org.example.exportservice.dto.MindMapDto;
import org.springframework.stereotype.Service;

@Service
public class ExportService {

    public String exportTxt(MindMapDto map) {
        StringBuilder sb = new StringBuilder();
        sb.append("MindMap: ").append(map.title).append("\n\n");

        sb.append("Nodes:\n");
        map.nodes.forEach(n ->
                sb.append("- ").append(n.id).append(": ").append(n.label).append("\n")
        );

        sb.append("\nEdges:\n");
        map.edges.forEach(e ->
                sb.append(e.fromNodeId)
                        .append(" -> ")
                        .append(e.toNodeId)
                        .append("\n")
        );

        return sb.toString();
    }

    public String exportCsv(MindMapDto map) {
        StringBuilder sb = new StringBuilder();

        sb.append("NODE_ID,LABEL\n");
        map.nodes.forEach(n ->
                sb.append(n.id).append(",").append(n.label).append("\n")
        );

        sb.append("\nEDGE_ID,FROM,TO\n");
        map.edges.forEach(e ->
                sb.append(e.id)
                        .append(",")
                        .append(e.fromNodeId)
                        .append(",")
                        .append(e.toNodeId)
                        .append("\n")
        );

        return sb.toString();
    }
}
