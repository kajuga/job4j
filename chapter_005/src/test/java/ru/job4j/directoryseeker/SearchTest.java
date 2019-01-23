package ru.job4j.directoryseeker;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchTest {
    private Search search;
    private List<String> listExt;
    private String dirPath;
    private File[] expected;

    @Before
    public void setUp() {
        search = new Search();
        listExt = new ArrayList<>();
        listExt.add("txt");
        listExt.add("log");
        dirPath = getClass().getClassLoader().getResource("test").getPath();
        expected = new File[]{
                new File("file01.log"),
//                new File("/tmp/javatest/file02.txt"),
//                new File("/tmp/javatest/j2/file03.log"),
//                new File("/tmp/javatest/j2/file04.txt"),
//                new File("/tmp/javatest/j1/j11/file06.txt"),
//                new File("/tmp/javatest/j1/j11/file05.log"),
//                new File("/tmp/javatest/j1/j11/java111/file08.txt"),
//                new File("/tmp/javatest/j1/j11/java111/file07.log")

        };

    }
    @Test
    public void testSearchSpecificFiles() {

        List<File> fileList = search.files(dirPath, listExt);
        assertArrayEquals(expected, fileList.toArray(new File[0]));

    }
}