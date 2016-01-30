package ru.demkin.simplepublisher;


import org.jfrog.artifactory.param.ParameterBuilder;

public class DefautParameterBuilder extends ParameterBuilder {

    @Override
    public void buildHomeUrl() {
        parameter.setHomeUrl("http://localhost:8081/artifactory");
    }

    @Override
    public void buildPath() {
        parameter.setPath("CZML.ZIP");
    }

    @Override
    public void buildRepository() {
        parameter.setRepository("COMMON43");
    }

    @Override
    public void buildUsername() {
        parameter.setUsername("admin");
    }

    @Override
    public void buildPassword() {
        parameter.setPassword("password");
    }

    @Override
    public void buildHeaders() {
        parameter.setHeaders(null);
    }
}
