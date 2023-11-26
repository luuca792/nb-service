package ctu.se.oda.model11.models.commands.values;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateValueCommandReqDTO {
    @JsonProperty("valueId")
    private String id;
    @JsonProperty("value")
    private String value;
}
