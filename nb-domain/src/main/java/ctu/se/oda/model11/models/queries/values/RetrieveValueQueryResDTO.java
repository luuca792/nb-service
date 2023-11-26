package ctu.se.oda.model11.models.queries.values;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveValueQueryResDTO {
    @JsonProperty("valueId")
    private String id;
    @JsonProperty("value")
    private String value;
    @JsonProperty("valueFieldId")
    private String fieldId;
}
