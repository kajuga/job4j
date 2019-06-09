package ru.job4j.magnit;

import ru.job4j.magnit.entity.Entries;
import ru.job4j.magnit.parser.impl.JaxbParser;
import javax.xml.bind.JAXBException;
import java.io.File;

public class Main {

    public static void main(String[] args) throws JAXBException {
        Config config = new Config();
        config.init();
        try (StoreSQL storeSql = new StoreSQL(config);) {
            storeSql.generate(100);
            Entries entries = new Entries(storeSql.findAll());
            File fileSource = new File(Main.class.getClassLoader().getResource("magnit/entries.xml").getFile());
            File fileXsl = new File(Main.class.getClassLoader().getResource("magnit/entries-scheme.xsl").getFile());
            File fileResult = new File(Main.class.getClassLoader().getResource("magnit").getPath() + "/entries-after-convert.xml");
            JaxbParser jaxbParser = new JaxbParser();
            jaxbParser.saveObject(fileSource, entries);

            ConvertXSQT convertXSQT = new ConvertXSQT();
            convertXSQT.convert(fileSource, fileResult, fileXsl);
        }
    }
}