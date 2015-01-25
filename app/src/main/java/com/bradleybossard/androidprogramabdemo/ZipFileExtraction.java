package com.bradleybossard.androidprogramabdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by bradleybossard on 1/24/15.
 * 
 * This class extracts a zip file to a folder.
 */
public class ZipFileExtraction {
    public void unZipIt(InputStream zipFile, String outputFolder) {
        try {
            //get the zip file content
            ZipInputStream zin = new ZipInputStream(zipFile);
            //get the zipped file list entry
            ZipEntry entry = null;
            int bytesRead;
            byte[] buffer = new byte[4096];

            while ((entry = zin.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    File dir = new File(outputFolder, entry.getName());
                    if (!dir.exists()) {
                        dir.mkdir();
                    }
                } else {
                    FileOutputStream fos = new FileOutputStream(outputFolder + entry.getName());
                    while ((bytesRead = zin.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                    fos.close();
                }
            }
            zin.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}