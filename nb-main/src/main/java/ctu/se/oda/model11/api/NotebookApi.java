package ctu.se.oda.model11.api;

import ctu.se.oda.model11.INotebookApplication;
import ctu.se.oda.model11.models.commands.notebooks.CreateNotebookCommandReqDTO;
import ctu.se.oda.model11.models.commands.notebooks.UpdateNotebookCommandReqDTO;
import ctu.se.oda.model11.models.queries.notebooks.RetrieveNotebookQueryResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/notebooks")
public class NotebookApi {
    @Autowired
    private INotebookApplication notebookApplication;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UpdateNotebookCommandReqDTO updateNotebookCommandReqDTO) {
        if (Objects.isNull(updateNotebookCommandReqDTO.getId())) {
            notebookApplication.create(CreateNotebookCommandReqDTO.builder().description(updateNotebookCommandReqDTO.getDescription()).name(updateNotebookCommandReqDTO.getName()).projectId(updateNotebookCommandReqDTO.getProjectId()).build());
        }else {
            notebookApplication.update(updateNotebookCommandReqDTO);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveNotebookQueryResDTO>> list() {
        return new ResponseEntity<>(notebookApplication.list(), HttpStatus.OK);
    }

    @GetMapping("/{notebookId}")
    public ResponseEntity<RetrieveNotebookQueryResDTO> retrieve(@PathVariable String notebookId) {
        return new ResponseEntity<>(notebookApplication.retrieve(UUID.fromString(notebookId)), HttpStatus.OK);
    }

    @DeleteMapping("/{notebookId}")
    public ResponseEntity<Void> delete(@PathVariable String notebookId) {
        notebookApplication.delete(UUID.fromString(notebookId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
