package ru.job4j.magnit.parser.impl;

import ru.job4j.magnit.parser.Parser;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser implements Parser {
    @Override
    public Object getObject(File file, Class c) throws JAXBException {
//        JAXBContext().newInstance() – создаем образец контекста и передаем Class объекта с которым будем работать
        JAXBContext context = JAXBContext.newInstance(c);
//        context.createUnmarshaller() – создаем анмаршаллер
        Unmarshaller unmarshaller = context.createUnmarshaller();
//        unmarshaller.unmarshall(file) – сохраняем данные схемы в объект. file – файл, с которого читаются данные.
        Object object = unmarshaller.unmarshal(file);
        return object;
    }

    @Override
    public void saveObject(File file, Object o) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
//        устанавливаем свойство FORMATTED_OUTPUT в TRUE. В результат будут добавлены переносы строки и пробелы, чтобы код был читабельным для человека, а не весь текст в одну строку
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(o, file);
    }
}