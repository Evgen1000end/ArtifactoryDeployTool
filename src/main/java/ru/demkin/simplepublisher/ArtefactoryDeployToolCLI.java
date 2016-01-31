package ru.demkin.simplepublisher;

import org.apache.commons.cli.*;
import org.jfrog.artifactory.api.ADTConfig;
import org.jfrog.artifactory.api.ADTConfigBuilder;


public class ArtefactoryDeployToolCLI {

    public static void main(String[] args) {



        Option option = new Option("p", "publish", true, "Publish");
        option.setArgs(0);
        option.setArgName("publish");

        Options posixOptions = new Options();
        posixOptions.addOption(option);


        CommandLineParser cmdLinePosixParser = new PosixParser();
        try {

            CommandLine commandLine = cmdLinePosixParser.parse(posixOptions, args);

            if (commandLine.hasOption("p")) {
                System.out.println("Publish artefact its about to begin!");

                String path =System.getProperty("user.dir")+"\\"+ADTDefaults.DEFAULT_BUILD_NAME;
               // String path = "C:\\PROJECTS\\ArtifactoryDeployTool\\Bin\\"+ADTDefaults.DEFAULT_BUILD_NAME;

                ADTConfig config = new ADTConfigBuilder().build(path);

                System.out.println("Config File loaded successful");

               // ArtifactoryAPI artifactoryAPI = new ArtifactoryAPIImpl(new DefautParameterBuilder());

                ADTWrapper adtWrapper = new ADTWrapper(config);

                adtWrapper.importFrom();

            }

            else
            {
                System.out.println("Please, input commands.");
            }

        } catch (ParseException e) {
            e.printStackTrace();

        }


    }

}
