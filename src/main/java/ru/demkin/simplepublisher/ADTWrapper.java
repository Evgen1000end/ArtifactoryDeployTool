package ru.demkin.simplepublisher;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.jfrog.artifactory.ArtifactoryUtilsException;
import org.jfrog.artifactory.api.ADTConfig;
import org.jfrog.artifactory.api.StatusCode;
import org.zeroturnaround.zip.ZipUtil;
import java.io.File;

public class ADTWrapper {

    private ADTConfig config;

    public ADTWrapper(ADTConfig config) {
        this.config = config;
    }

    private static Client client;

    static{
        client = Client.create();
    }

    public File exportTo(final File pFileDestination){
          return null;
//        final WebResource webResource = client.resource(params.getWebResourcePath());
//
//        final ClientResponse response = webResource.accept("application/zip").get(ClientResponse.class);
//
//        final int status = response.getStatus();
//
//        if (status != StatusCode.OK.getCode()) {
//            throw new ArtifactoryUtilsException(status,"The download does not succeed. Please check if the url : "+this.params.getRepo_folder()+" is correct.");
//        }
//
//        try {
//            FileUtils.writeByteArrayToFile(pFileDestination, IOUtils.toByteArray(response.getEntityInputStream()));
//        } catch (IOException e) {
//            //logger.error(e.getStackTrace());
//        }
//
//        return pFileDestination;
    }

    public void importFrom(){

        System.out.println("Prepare to unload... ");

        client.addFilter(
                new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter
                        (this.config.getLogin(), this.config.getPassword()));

        final WebResource webResource = client.resource(this.config.getWebResourcePath());

//		for(Entry<String,String> header : params.getHeaders().entrySet()){
//			webResource.header(header.getKey().trim(), header.getValue().trim());
//		}

      //  String pathToZip = config.getDisk_path()+"\\"+
      //          config.getArchive_name()+".zip";

        String pathToZip = "C:\\PROJECTS\\"+  config.getArchive_name()+
                "-"+config.getVersion()+ ".zip";

        ZipUtil.pack(new File(config.getDisk_path()), new File(pathToZip));

        System.out.println("Archive created successful!");

        final ClientResponse clientResponse =  webResource.put(ClientResponse.class, new File(pathToZip));

        final int status = clientResponse.getStatus();

        if(status != StatusCode.CREATED.getCode()){
            throw new ArtifactoryUtilsException(); //status,this.params
        }

        System.out.println("Artifactory upload done!");
    }

    public void delete(){


//        client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(this.params.getUsername(), this.params.getPassword()));
//
//        final WebResource webResource = client.resource(this.params.getWebResourcePath());
//
//        final ClientResponse clientResponse =webResource.delete(ClientResponse.class);
//
//        final int status = clientResponse.getStatus();
//
//        if(status != StatusCode.NO_CONTENT.getCode()){
//            throw new ArtifactoryUtilsException(status,this.params);
//        }

    }

}



