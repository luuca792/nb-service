package ctu.se.oda.model11.models.commands.fields;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateFieldCommandReqDTO {
    @JsonProperty("fieldName")
    private String name;
    @JsonProperty("fieldTypeId")
    private Long fieldTypeId;
    @JsonProperty("fieldNotebookId")
    private String notebookId;
    @JsonProperty("fieldTaskIds")
    private List<String> taskIds;
}
