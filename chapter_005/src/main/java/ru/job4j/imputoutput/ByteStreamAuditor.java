package ru.job4j.imputoutput;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * @Autor Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Реализация проверки целого числа, считанного потоком на четность/нечетность
 */


public class ByteStreamAuditor {

    public boolean isNumber(InputStream in) throws IOException {
        boolean result = false;

        try {
            byte[] buffer = new byte[in.available()];                   //создаю байтовый массив, размером in.available (число байт в потоке)
            ByteArrayOutputStream baos = new ByteArrayOutputStream();   //создаю поток вывода
            while (true) {
                int readBytesCount = in.read(buffer);                       //определяю маячок-проверялку наличия следующего байта во взодном потоке
                if (readBytesCount == -1) {                                 //если маячок срабатывает (возвращается -1) - break;
                    break;
                }
                if (readBytesCount > 0) {                                   //пока в потоке есть следующий байт
                    baos.write(buffer, 0, buffer.length);                //записываю в выходной поток число байтов, равное buffer.length
                }
            }
            baos.flush();                                                   //допинываю остатки байтов в поток записи
            baos.close();                                                   //закрываю поток записи
            byte[] data = baos.toByteArray();                               //получаю байтовый массив, который нужно переконвертить каким-то образом в число
            ByteBuffer bb = ByteBuffer.wrap(data);                          //Тээк, прочитал про волшебный Buffer из функционала java.nio
            long l = bb.getInt();
            if (l % 2 == 0) {
                result = true;
            }
//                if (byteArrayToInt(data) % 2 == 0) {                      //тут лажа - рассчитывает по чет/нечет количеству ячеек в байтовом массиве почему то.
//                    result = true;
//                }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }
}