package ctu.se.oda.model11.models.queries.fields;

import com.fasterxml.jackson.annotation.JsonProperty;
import ctu.se.oda.model11.models.queries.fieldtypes.RetrieveFieldTypeQueryResDTO;
import ctu.se.oda.model11.models.queries.notebooks.RetrieveNotebookQueryResDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveFieldQueryResDTO {
    @JsonProperty("fieldId")
    private String id;
    @JsonProperty("fieldName")
    private String name;
    @JsonProperty("fieldNotebook")
    private RetrieveNotebookQueryResDTO notebook;
    @JsonProperty("fieldType")
    private RetrieveFieldTypeQueryResDTO fieldType;
}
