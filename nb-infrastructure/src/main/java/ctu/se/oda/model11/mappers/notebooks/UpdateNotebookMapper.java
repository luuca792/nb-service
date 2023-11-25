package ctu.se.oda.model11.mappers.notebooks;

import ctu.se.oda.model11.entities.Notebook;
import ctu.se.oda.model11.errors.messages.CustomMessageException;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.notebooks.UpdateNotebookCommandReqDTO;
import ctu.se.oda.model11.repositories.INoteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UpdateNotebookMapper implements IInfrastructureMapper<UpdateNotebookCommandReqDTO, Notebook> {
    @Autowired
    private INoteBookRepository noteBookRepository;

    @Override
    public Notebook convert(UpdateNotebookCommandReqDTO source) {
        var optionalNotebook = noteBookRepository.findById(UUID.fromString(source.getId()));
        if (optionalNotebook.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.NOTEBOOK_NOT_FOUND_BY_ID);
        }
        return Notebook.builder()
                .id(optionalNotebook.get().getId())
                .description(Objects.isNull(source.getDescription()) ? optionalNotebook.get().getDescription() : source.getDescription())
                .name(Objects.isNull(source.getName()) ? optionalNotebook.get().getName() : source.getName())
                .projectId(optionalNotebook.get().getProjectId())
                .build();
    }
}
