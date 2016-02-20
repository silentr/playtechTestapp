package com.playtech.testapp;

import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {

    public App() {
        packages("com.playtech.testapp.facade");
    }
}
