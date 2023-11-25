package ctu.se.oda.model11.mappers.notebooks;

import ctu.se.oda.model11.entities.Notebook;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.notebooks.CreateNotebookCommandReqDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateNotebookMapper implements IInfrastructureMapper<CreateNotebookCommandReqDTO, Notebook> {
    @Override
    public Notebook convert(CreateNotebookCommandReqDTO source) {
        return Notebook.builder()
                .description(source.getDescription())
                .name(source.getName())
                .projectId(UUID.fromString(source.getProjectId()))
                .build();
    }
}
