package ru.job4j.zipper;

import ru.job4j.directoryseeker.Search;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.List;


/**
 * Class ZipProject.
 */
public class Zip {

    public static void main(String[] args) {
        String srcDir = "/home/kajuga/projects/job4j/chapter_005/src/main/resources";
        String zip = "/home/kajuga/projects/job4j/chapter_005/src/test/resources";
        String ext = "xml";
        List<String> exts = new ArrayList<>();
        exts.add(ext);
        new Zip().zip(exts, srcDir, zip);

    }

    /**
     * method to zip files with an appropriate extension.
     *
     * @param srcDir source directory.
     * @param exts   files´ extension.
     * @param zip zipped directory.
     */
    public void zip(List<String> exts, String srcDir, String zip) {
        byte[] buffer = new byte[1024];
        Search search = new Search();
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zip));
            List<File> files = search.files(srcDir, exts);
            for (int i = 0; i < files.size(); i++) {
                File tempfile = files.get(i);
                FileInputStream fis = new FileInputStream(tempfile);
                zos.putNextEntry(new ZipEntry(tempfile.getAbsolutePath()));
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}