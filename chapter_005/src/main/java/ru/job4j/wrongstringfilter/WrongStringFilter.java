package ru.job4j.wrongstringfilter;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Реализация функционала фильтрации строкового потока
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 */
public class WrongStringFilter {

    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (Scanner scanner = new Scanner(new InputStreamReader(in));                     //создал поток чтения текста из символьного потока - хочу Scanner, а не BufferedReader
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {        //тут же создал поток вывода
            StringBuilder builder = new StringBuilder();                                   //создаю стрингбилдер, чтоб каждый раз не создавать новую строку при замене и пр.
            while (scanner.hasNextLine()) {
                String read = scanner.nextLine();                                          //проверяю на null чтоб не вляпаться
                if (read != null) {
                    builder.append(read);                                                  //записываю построчно все строки в экземпляр StringBuilder
                }
            }
            String res = builder.toString();                                               //привожу к строке

            for (String str : abuse) {                                                     //форичем пробегаю по String[] abuse
                Pattern pattern = Pattern.compile(str);                                    //прочитал про регулярные выражения - использую для замены классы Pattern, Matcher
                Matcher matcher = pattern.matcher(res);                                    //*фигегознает чем они лучше обчного Stringовского replaceAll.
                boolean found = matcher.matches();
                if (found) {
                    res = matcher.replaceAll(str);
                }
            }
            bw.write(res);                                                                  //записываю в BufferedReader конденсат без примесей.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}