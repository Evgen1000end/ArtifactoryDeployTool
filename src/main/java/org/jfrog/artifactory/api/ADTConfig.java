package org.jfrog.artifactory.api;


import java.util.List;

public class ADTConfig {

    private String archive_name;

    public String getArchive_name() {
        return archive_name;
    }

    public void setArchive_name(String archive_name) {
        this.archive_name = archive_name;
    }

    private String server_ip;

    private String disk_path;

    public String getDisk_path() {
        return disk_path;
    }

    public void setDisk_path(String disk_path) {
        this.disk_path = disk_path;
    }

    private String repo_folder;

    public String getRepo_folder() {
        return repo_folder;
    }

    public void setRepo_folder(String repo_folder) {
        this.repo_folder = repo_folder;
    }

    private String repository_name;

    private String login;

    private String password;

    private List<String> headers;

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public String getServer_ip() {
        return server_ip;
    }

    public void setServer_ip(String server_ip) {
        this.server_ip = server_ip;
    }

    public String getRepository_name() {
        return repository_name;
    }

    public void setRepository_name(String repository_name) {
        this.repository_name = repository_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebResourcePath(){
        return this.server_ip+"/artifactory/"+this.repository_name+"/"+this.repo_folder+"/"+this.archive_name+".zip";
    }

}

