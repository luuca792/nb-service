package com.ctu.se.oda.model11;

import com.ctu.se.oda.model11.models.commands.responses.AppInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AppInformationService {

    private static AppInfoResponse appInfo;

    public static AppInfoResponse getAppInfo() {
        appInfo = new AppInfoResponse("Notebook Service", "0.0.1-SNAPSHOT");
        return appInfo;
    }
}