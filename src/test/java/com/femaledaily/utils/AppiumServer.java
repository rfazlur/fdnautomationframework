package com.femaledaily.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class AppiumServer {

    public static AppiumDriverLocalService service;

    public static void start(){
        service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder().usingDriverExecutable(new File("/home/faiz/.nvm/versions" +
                        "/node/v11.8.0/bin/node"))
                        .withAppiumJS(new File("/home/faiz/.nvm/versions/node/v11.8.0/bin/appium"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/appiumlog/Appium.log")));
        service.start();
    }

    public static void stop(){
        if (service != null){
            service.stop();
        }
    }

}
