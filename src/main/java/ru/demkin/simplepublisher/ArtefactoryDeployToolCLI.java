package ru.demkin.simplepublisher;

import org.apache.commons.cli.*;

/**
 * Created by evgen1000end on 30.01.2016.
 */
public class ArtefactoryDeployToolCLI {

    public static void main(String[] args) {



        Option option = new Option("p", "publish", true, "Publish");
        option.setArgs(0);
        option.setArgName("publish");

        Options posixOptions = new Options();
        posixOptions.addOption(option);



        CommandLineParser cmdLinePosixParser = new PosixParser();
        try {

            System.out.println("here");
            CommandLine commandLine = cmdLinePosixParser.parse(posixOptions, args);

            if (commandLine.hasOption("p")) {
                //String[] arguments = commandLine.getOptionValues("p");
                System.out.println("We try to Login with: ");
            }

        } catch (ParseException e) {

            System.out.println("hello!");
            e.printStackTrace();

        }


    }

}
