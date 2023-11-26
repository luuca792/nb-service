package ctu.se.oda.model11.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppInfoResponse {
    private String name;
    private String version;

    public AppInfoResponse(String name, String version) {
        this.name = name;
        this.version = version;
    }
}