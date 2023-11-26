package ctu.se.oda.model11.models.queries.fieldtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveFieldTypeQueryResDTO {
    @JsonProperty("fieldTypeId")
    private Long id;
    @JsonProperty("fieldTypeName")
    private String name;
}
