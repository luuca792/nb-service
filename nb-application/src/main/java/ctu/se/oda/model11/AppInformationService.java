package ctu.se.oda.model11;

import ctu.se.oda.model11.models.AppInfoResponse;
import org.springframework.stereotype.Service;

@Service
public class AppInformationService {

    private static AppInfoResponse appInfo;

    public static AppInfoResponse getAppInfo() {
        appInfo = new AppInfoResponse("Notebook Service", "0.0.1-SNAPSHOT");
        return appInfo;
    }
}