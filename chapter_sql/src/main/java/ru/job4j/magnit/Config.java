package ru.job4j.magnit;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    //создаю пропертю для чтения конфиги из файла
    private final Properties values = new Properties();

    public void init() {
    //загружаю содержимое файла через экземпляр properties
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("sqlite.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    //возвращаю значение из фпйла-конфига по ключу
    public String get(String key) {
        return this.values.getProperty(key);
    }
}