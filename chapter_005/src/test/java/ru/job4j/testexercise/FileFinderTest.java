package ru.job4j.testexercise;

import junit.framework.*;

import java.util.List;

public class FileFinderTest extends TestCase {

    public FileFinderTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(FileFinderTest.class);

        return suite;
    }


    public void testFindAll() throws Exception {
        System.out.println("findAll");

        String startPath = "folderForTests";
        FileFinder finder = new FileFinder();

        List result = finder.findAll(startPath);
        assertEquals(result.size(), 8);
        assertEquals(finder.getDirectorySize(), 209);
        assertEquals(finder.getDirectoriesNumber(), 3);
        assertEquals(finder.getFilesNumber(), 5);

        result = finder.findAll(startPath, ".+");
        assertEquals(result.size(), 8);

        result = finder.findAll(startPath, "^fol.*");
        assertEquals(result.size(), 2);
        assertEquals(finder.getDirectoriesNumber(), 2);
        assertEquals(finder.getFilesNumber(), 0);

        result = finder.findAll(startPath, ".*[Ff]ol.*");
        assertEquals(result.size(), 3);
        assertEquals(finder.getDirectoriesNumber(), 3);
        assertEquals(finder.getFilesNumber(), 0);

        result = finder.findAll(startPath, ".+\\.txt");
        assertEquals(result.size(), 4);
        assertEquals(finder.getDirectoriesNumber(), 0);
        assertEquals(finder.getFilesNumber(), 4);

        try {
            result = finder.findAll(startPath + "/folder1/file11.txt");
            fail("������ ���� ���������� ����������");
        } catch (Exception err) { }

        try {
            result = finder.findAll("");
            fail("������ ���� ���������� ����������");
        } catch (Exception err) { }

        try {
            result = finder.findAll("������������");
            fail("������ ���� ���������� ����������");
        } catch (Exception err) { }
    }


    public void testFindFiles() throws Exception {
        System.out.println("findFiles");

        String startPath = "folderForTests";
        FileFinder finder = new FileFinder();

        List result = finder.findFiles(startPath);
        assertEquals(result.size(), 5);
        assertEquals(finder.getDirectorySize(), 209);
        assertEquals(finder.getDirectoriesNumber(), 0);
        assertEquals(finder.getFilesNumber(), 5);

        result = finder.findFiles(startPath, ".+\\.txt");
        assertEquals(result.size(), 4);

        result = finder.findFiles(startPath, ".+\\.html");
        assertEquals(result.size(), 1);

        result = finder.findFiles(startPath, "^file.+");
        assertEquals(result.size(), 5);

        result = finder.findFiles(startPath, "^fol.+");
        assertEquals(result.size(), 0);

        result = finder.findFiles(startPath + "/folder2", ".+\\.txt");
        assertEquals(result.size(), 1);
        assertEquals(finder.getDirectoriesNumber(), 0);
        assertEquals(finder.getFilesNumber(), 1);
    }


    public void testFindDirectories() throws Exception {
        System.out.println("findDirectories");

        String startPath = "folderForTests";
        FileFinder finder = new FileFinder();

        List result = finder.findDirectories(startPath);
        assertEquals(result.size(), 3);
        assertEquals(finder.getDirectoriesNumber(), 3);
        assertEquals(finder.getFilesNumber(), 0);

        result = finder.findDirectories(startPath, "");
        assertEquals(result.size(), 3);

        result = finder.findDirectories(startPath + "/folder1", ".+[Ff]ol.+");
        assertEquals(result.size(), 1);
    }
}
