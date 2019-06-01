package ru.job4j.magnit;


import ru.job4j.magnit.entity.Entries;
import ru.job4j.magnit.entity.Entry;
import ru.job4j.magnit.parser.impl.JaxbParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JAXBException {
        Config config = new Config();
        config.init();
        try(StoreSQL storeSql = new StoreSQL(config);) {
            storeSql.generate(100);
            Entries entries = new Entries(storeSql.findAll());
//            StoreXML storeXML = new StoreXML(new File(args[0]));
//            storeXML.save(entries);
            File file = new File("/home/kajuga/projects/job4j/chapter_sql/src/main/java/ru/job4j/magnit/entries.xml");
            JaxbParser jaxbParser = new JaxbParser();
            jaxbParser.saveObject(file, entries);


            //System.out.println(storeSql.findAll());
        }
    }
}

