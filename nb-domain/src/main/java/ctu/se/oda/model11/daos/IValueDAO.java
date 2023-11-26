package ctu.se.oda.model11.daos;

import ctu.se.oda.model11.models.commands.fields.CreateFieldCommandReqDTO;
import ctu.se.oda.model11.models.commands.fields.UpdateFieldCommandReqDTO;
import ctu.se.oda.model11.models.commands.values.CreateValueCommandReqDTO;
import ctu.se.oda.model11.models.commands.values.UpdateValueCommandReqDTO;
import ctu.se.oda.model11.models.queries.fields.RetrieveFieldQueryResDTO;
import ctu.se.oda.model11.models.queries.values.RetrieveValueQueryResDTO;

import java.util.List;
import java.util.UUID;

public interface IValueDAO {
    void create(CreateValueCommandReqDTO createValueCommandReqDTO);
    void update(UpdateValueCommandReqDTO updateValueCommandReqDTO);
    void delete(UUID valueId);
    List<RetrieveValueQueryResDTO> list();
    RetrieveValueQueryResDTO retrieve(UUID valueId);
}
