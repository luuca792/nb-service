package ctu.se.oda.model11.models.commands.responses.notebooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveNotebookCommandResDTO {
    @JsonProperty("notebookId")
    private String id;
    @JsonProperty("notebookName")
    private String name;
    @JsonProperty("notebookDescription")
    private String description;

    @JsonProperty("notebookProjectId")
    private String projectId;
}
