package ctu.se.oda.model11;


import ctu.se.oda.model11.models.commands.requests.notebooks.CreateNotebookCommandReqDTO;
import ctu.se.oda.model11.models.commands.requests.notebooks.UpdateNotebookCommandReqDTO;
import ctu.se.oda.model11.models.queries.responses.notebooks.RetrieveNotebookQueryResDTO;

import java.util.List;
import java.util.UUID;

public interface INotebookApplication {
    void create(CreateNotebookCommandReqDTO createNotebookCommandReqDTO);
    void update(UpdateNotebookCommandReqDTO updateNotebookCommandReqDTO);
    void delete(UUID notebookId);
    List<RetrieveNotebookQueryResDTO> list();
    RetrieveNotebookQueryResDTO retrieve(UUID notebookId);
}
