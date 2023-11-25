package ctu.se.oda.model11.mappers.notebooks;

import ctu.se.oda.model11.entities.Notebook;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.queries.notebooks.RetrieveNotebookQueryResDTO;
import org.springframework.stereotype.Component;

@Component
public class RetrieveNotebookMapper implements IInfrastructureMapper<Notebook, RetrieveNotebookQueryResDTO> {
    @Override
    public RetrieveNotebookQueryResDTO convert(Notebook source) {
        return RetrieveNotebookQueryResDTO.builder()
                .id(source.getId().toString())
                .name(source.getName())
                .description(source.getDescription())
                .projectId(source.getProjectId().toString())
                .build();
    }
}
