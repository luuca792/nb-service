package ctu.se.oda.model11.daos;

import ctu.se.oda.model11.entities.Field;
import ctu.se.oda.model11.entities.FieldTask;
import ctu.se.oda.model11.errors.messages.CustomMessageException;
import ctu.se.oda.model11.mappers.IInfrastructureMapper;
import ctu.se.oda.model11.models.commands.fields.CreateFieldCommandReqDTO;
import ctu.se.oda.model11.models.commands.fields.UpdateFieldCommandReqDTO;
import ctu.se.oda.model11.models.queries.fields.RetrieveFieldQueryResDTO;
import ctu.se.oda.model11.repositories.IFieldRepository;
import ctu.se.oda.model11.repositories.IFieldTaskRepository;
import ctu.se.oda.model11.repositories.INoteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FieldDAO implements IFieldDAO{
    @Autowired
    private IFieldRepository fieldRepository;
    @Autowired
    private INoteBookRepository noteBookRepository;
    @Autowired
    private IFieldTaskRepository fieldTaskRepository;
    @Autowired
    private IInfrastructureMapper<CreateFieldCommandReqDTO, Field> createMapper;
    @Autowired
    private IInfrastructureMapper<UpdateFieldCommandReqDTO, Field> updateMapper;
    @Autowired
    private IInfrastructureMapper<Field, RetrieveFieldQueryResDTO> retrieveMapper;

    @Override
    public void create(CreateFieldCommandReqDTO createFieldCommandReqDTO) {
        var createdField = fieldRepository.save(createMapper.convert(createFieldCommandReqDTO));
        try {
            createFieldCommandReqDTO.getTaskIds().stream().forEach(taskId -> fieldTaskRepository.save(FieldTask.builder().field(createdField).taskId(UUID.fromString(taskId)).build()));
        } catch (Exception ex) {

        }
    }

    @Override
    @Transactional
    public void update(UpdateFieldCommandReqDTO updateFieldCommandReqDTO) {
        var updatedField = fieldRepository.save(updateMapper.convert(updateFieldCommandReqDTO));
        fieldTaskRepository.deleteAllByField(updatedField);
        try {
            updateFieldCommandReqDTO.getTaskIds().stream().forEach(taskId -> fieldTaskRepository.save(FieldTask.builder().field(updatedField).taskId(UUID.fromString(taskId)).build()));
        } catch (Exception ex) {

        }
    }

    @Override
    public void delete(UUID fieldId) {
        fieldRepository.deleteById(fieldId);
    }

    @Override
    public List<RetrieveFieldQueryResDTO> list() {
        return fieldRepository.findAll().stream().map(field -> retrieveMapper.convert(field)).collect(Collectors.toList());
    }

    @Override
    public List<RetrieveFieldQueryResDTO> listByNotebookId(UUID notebookId) {
        var optionalNotebook = noteBookRepository.findById(notebookId);
        if (optionalNotebook.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.NOTEBOOK_NOT_FOUND_BY_ID);
        }
        return fieldRepository.findByNotebook(optionalNotebook.get()).stream().map(field -> retrieveMapper.convert(field)).collect(Collectors.toList());
    }

    @Override
    public List<RetrieveFieldQueryResDTO> listByTaskId(UUID taskId) {
        var fieldTasks = fieldTaskRepository.findByTaskId(taskId);
        return fieldTasks.stream().map(fieldTask -> retrieveMapper.convert(fieldTask.getField())).collect(Collectors.toList());
    }

    @Override
    public List<RetrieveFieldQueryResDTO> listByNotebookIdAndTaskId(UUID notebookId, UUID taskId) {
        var lists = listByTaskId(taskId).stream().filter(retrieveFieldQueryResDTO -> retrieveFieldQueryResDTO.getNotebook().getId().equals(notebookId.toString())).collect(Collectors.toList());
        return lists;
    }

    @Override
    public RetrieveFieldQueryResDTO retrieve(UUID fieldId) {
        var optionalField = fieldRepository.findById(fieldId);
        if (optionalField.isEmpty()) {
            throw new IllegalArgumentException(CustomMessageException.FIELD_NOT_FOUND_BY_ID);
        }
        return retrieveMapper.convert(optionalField.get());
    }
}
