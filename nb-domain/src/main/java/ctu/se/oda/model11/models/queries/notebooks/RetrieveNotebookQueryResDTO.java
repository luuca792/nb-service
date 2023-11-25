package ctu.se.oda.model11.models.queries.notebooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveNotebookQueryResDTO {
    @JsonProperty("noteBookId")
    private String id;
    @JsonProperty("noteBookName")
    private String name;
    @JsonProperty("noteBookDescription")
    private String description;

    @JsonProperty("noteBookProjectId")
    private String projectId;
}
