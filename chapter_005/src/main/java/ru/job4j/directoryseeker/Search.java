package ru.job4j.directoryseeker;

import java.io.File;
import java.util.*;

public class Search {

    public List<File> files(String parent, List<String> exts) {
        List<File> resultList = new ArrayList<>();                                  //создаю список объектов File
        Queue<File> fileQueue = new LinkedList<>();                                 //тут очередь тож из обхектов File
        File file = new File(parent);                                               //тут устанавливаю родительскую директорию
        Arrays.stream(file.listFiles()).forEach(a -> fileQueue.add(a));             //тут получаю массив файлов, подкаталогов и тупо запихиваю их через задницу в queue
        File tempFile;
        while (!fileQueue.isEmpty()) {                                              //если что-то есть в этой queue
            tempFile = fileQueue.poll();                                            //вытаскиваю верхушку методом poll, схоронив в temp
            if (tempFile.isDirectory()) {                                           //если вытаскиваемое  - директория
                Arrays.stream(tempFile.listFiles()).forEach(a -> fileQueue.add(a)); //то запихиваю в queue все содержимое -  файлы, директории
            } else {
                for (String s : exts) {                                              //ежели - вытащенное не директория, то пробегаясь по всем нужным нам расширениям
                    if (tempFile.getName().endsWith(s)) {                            //при условии, что вытащенное из queue оканчивается нужным стрингом-"расширением"
                        resultList.add(tempFile);                                    //запихиваю это в результирующий список
                        break;
                    }
                }
            }
        }
        return resultList;
    }
}