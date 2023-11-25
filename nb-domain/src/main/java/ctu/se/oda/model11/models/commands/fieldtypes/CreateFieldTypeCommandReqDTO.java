package ctu.se.oda.model11.models.commands.fieldtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateFieldTypeCommandReqDTO {
    @JsonProperty("fieldTypeName")
    private String name;
}
