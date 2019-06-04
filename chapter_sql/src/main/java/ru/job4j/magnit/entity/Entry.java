package ru.job4j.magnit.entity;

import javax.xml.bind.annotation.*;
import static org.bitbucket.dollar.Dollar.$;

@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"id", "name"})
public class Entry {
    private int id;
    private String name;
    private int indexNameLengthGenerator = 12;
    private String validCharacters = $('0', '9').join() + $('A', 'Z').join();

    public int getId() {
        return id;
    }

//    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return randomString(indexNameLengthGenerator);
    }

//    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getIndexNameLengthGenerator() {
        return indexNameLengthGenerator;
    }

    public void setIndexNameLengthGenerator(int indexNameLengthGenerator) {
        this.indexNameLengthGenerator = indexNameLengthGenerator;
    }

    private String randomString(int length) {
        return $(validCharacters).shuffle().slice(length).toString();
    }

    @Override
    public String toString() {
        return "Entry {"
                + " id = "
                + id
                + ", name ='"
                + name
                + '\''
                + '}';
    }
}
