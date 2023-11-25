package ctu.se.oda.model11.daos;

import ctu.se.oda.model11.models.commands.notebooks.CreateNotebookCommandReqDTO;
import ctu.se.oda.model11.models.commands.notebooks.UpdateNotebookCommandReqDTO;
import ctu.se.oda.model11.models.queries.notebooks.RetrieveNotebookQueryResDTO;

import java.util.List;
import java.util.UUID;

public interface INotebookDAO {
    void create(CreateNotebookCommandReqDTO createNotebookCommandReqDTO);
    void update(UpdateNotebookCommandReqDTO updateNotebookCommandReqDTO);
    List<RetrieveNotebookQueryResDTO> list();
    RetrieveNotebookQueryResDTO retrieve(UUID notebookId);
    void delete(UUID notebookId);
}
