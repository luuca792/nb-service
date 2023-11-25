package ctu.se.oda.model11.daos;

import ctu.se.oda.model11.entities.Notebook;
import ctu.se.oda.model11.errors.messages.CustomMessageException;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.notebooks.CreateNotebookCommandReqDTO;
import ctu.se.oda.model11.models.commands.notebooks.UpdateNotebookCommandReqDTO;
import ctu.se.oda.model11.models.queries.notebooks.RetrieveNotebookQueryResDTO;
import ctu.se.oda.model11.repositories.INoteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotebookDAO implements INotebookDAO{
    @Autowired
    private INoteBookRepository noteBookRepository;
    @Autowired
    private IInfrastructureMapper<CreateNotebookCommandReqDTO, Notebook> createMapper;
    @Autowired
    private IInfrastructureMapper<UpdateNotebookCommandReqDTO, Notebook> updateMapper;
    @Autowired
    private IInfrastructureMapper<Notebook, RetrieveNotebookQueryResDTO> retrieveMapper;

    @Override
    public void create(CreateNotebookCommandReqDTO createNotebookCommandReqDTO) {
        noteBookRepository.save(createMapper.convert(createNotebookCommandReqDTO));
    }

    @Override
    public void update(UpdateNotebookCommandReqDTO updateNotebookCommandReqDTO) {
        noteBookRepository.save(updateMapper.convert(updateNotebookCommandReqDTO));
    }

    @Override
    public List<RetrieveNotebookQueryResDTO> list() {
        return noteBookRepository.findAll().stream().map(notebook -> retrieveMapper.convert(notebook)).collect(Collectors.toList());
    }

    @Override
    public RetrieveNotebookQueryResDTO retrieve(UUID notebookId) {
        var optionalNotebook = noteBookRepository.findById(notebookId);
        if (optionalNotebook.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.NOTEBOOK_NOT_FOUND_BY_ID);
        }
        return retrieveMapper.convert(optionalNotebook.get());
    }

    @Override
    public void delete(UUID notebookId) {
        var optionalNotebook = noteBookRepository.findById(notebookId);
        if (optionalNotebook.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.NOTEBOOK_NOT_FOUND_BY_ID);
        }
        noteBookRepository.deleteById(notebookId);
    }
}
