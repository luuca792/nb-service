package ctu.se.oda.model11.api;

import ctu.se.oda.model11.IValueApplication;
import ctu.se.oda.model11.models.commands.values.CreateValueCommandReqDTO;
import ctu.se.oda.model11.models.commands.values.UpdateValueCommandReqDTO;
import ctu.se.oda.model11.models.queries.values.RetrieveValueQueryResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/values")
public class ValueApi {
    @Autowired
    private IValueApplication valueApplication;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateValueCommandReqDTO createValueCommandReqDTO) {
        valueApplication.create(createValueCommandReqDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RetrieveValueQueryResDTO>> list() {
        return new ResponseEntity<>(valueApplication.list(), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Void> update(@RequestBody UpdateValueCommandReqDTO updateValueCommandReqDTO) {
        valueApplication.update(updateValueCommandReqDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{valueId}")
    public ResponseEntity<RetrieveValueQueryResDTO> retrieve(@PathVariable String valueId) {
        return new ResponseEntity<>(valueApplication.retrieve(UUID.fromString(valueId)), HttpStatus.OK);
    }

    @DeleteMapping("/{valueId}")
    public ResponseEntity<Void> delete(@PathVariable String valueId) {
        valueApplication.delete(UUID.fromString(valueId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
