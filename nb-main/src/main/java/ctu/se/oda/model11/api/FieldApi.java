package ctu.se.oda.model11.api;

import ctu.se.oda.model11.IFieldApplication;
import ctu.se.oda.model11.models.commands.fields.CreateFieldCommandReqDTO;
import ctu.se.oda.model11.models.commands.fields.UpdateFieldCommandReqDTO;
import ctu.se.oda.model11.models.queries.fields.RetrieveFieldQueryResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fields")
public class FieldApi {
    @Autowired
    private IFieldApplication fieldApplication;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateFieldCommandReqDTO createFieldCommandReqDTO) {
        fieldApplication.create(createFieldCommandReqDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveFieldQueryResDTO>> list() {
        return new ResponseEntity<>(fieldApplication.list(), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Void> update(@RequestBody UpdateFieldCommandReqDTO updateFieldCommandReqDTO) {
        fieldApplication.update(updateFieldCommandReqDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{fieldId}")
    public ResponseEntity<RetrieveFieldQueryResDTO> retrieve(@PathVariable String fieldId) {
        return new ResponseEntity<>(fieldApplication.retrieve(UUID.fromString(fieldId)), HttpStatus.OK);
    }

    @DeleteMapping("/{fieldId}")
    public ResponseEntity<Void> delete(@PathVariable String fieldId) {
        fieldApplication.delete(UUID.fromString(fieldId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
