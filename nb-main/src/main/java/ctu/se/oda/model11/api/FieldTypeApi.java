package ctu.se.oda.model11.api;

import ctu.se.oda.model11.IFieldTypeApplication;
import ctu.se.oda.model11.models.commands.fieldtypes.CreateFieldTypeCommandReqDTO;
import ctu.se.oda.model11.models.commands.fieldtypes.UpdateFieldTypeCommandReqDTO;
import ctu.se.oda.model11.models.queries.fieldtypes.RetrieveFieldTypeQueryResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/field-types")
public class FieldTypeApi {
    @Autowired
    private IFieldTypeApplication fieldTypeApplication;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateFieldTypeCommandReqDTO createFieldTypeCommandReqDTO) {
        fieldTypeApplication.create(createFieldTypeCommandReqDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveFieldTypeQueryResDTO>> list() {
        return new ResponseEntity<>(fieldTypeApplication.list(), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Void> update(@RequestBody UpdateFieldTypeCommandReqDTO updateFieldTypeCommandReqDTO) {
        fieldTypeApplication.update(updateFieldTypeCommandReqDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{fieldTypeId}")
    public ResponseEntity<RetrieveFieldTypeQueryResDTO> retrieve(@PathVariable Long fieldTypeId) {
        return new ResponseEntity<>(fieldTypeApplication.retrieve(fieldTypeId), HttpStatus.OK);
    }

    @DeleteMapping("/{fieldTypeId}")
    public ResponseEntity<Void> delete(@PathVariable Long fieldTypeId) {
        fieldTypeApplication.delete(fieldTypeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
