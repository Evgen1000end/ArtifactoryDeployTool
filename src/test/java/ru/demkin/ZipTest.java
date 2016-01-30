package ru.demkin;


import org.testng.annotations.Test;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;


public class ZipTest {

    @Test
    public void testZIPFolder(){

        String pathToFolder = "C:\\PROJECTS\\ArtifactoryDeployTool\\ArtifactoryDeployTool";

        String pathToZIP = "C:\\PROJECTS\\ArtifactoryDeployTool\\ArtifactoryDeployTool.zip";

        ZipUtil.pack(new File(pathToFolder), new File(pathToZIP));

    }

}



