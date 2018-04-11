package ru.job4j.max;

/**
 * Maximum.
 *
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {

    public int max(int first, int second){
        //int max = Math.max(first, second);
        int max = first > second ? first : second;
        return max;
    }

    public int max(int first, int second, int third){
        int res = this.max(first, second);
        int temp = max(res, third);
        //temp = max(max(a,b), c);
        return temp;
    }
}
