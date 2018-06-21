package ru.job4j.bracket;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

//public class SortBracketsTest {
//    @Test
//    public void myParserBrackets() throws Exception {
//        SortBrackets sortBrackets = new SortBrackets();
//        sortBrackets.myParserBrackets("([]{}{{}})");
//        assertThat(
//                sortBrackets.myParserBrackets("([]{}{{}})"),
//                is(
//                        new StringBuilder()
//                        .append("Скобка вида []: нач. позиция = 1; кон. позиция = 2.")
//                        .append("Скобка вида {}: нач. позиция = 3; кон. позиция = 4.")
//                        .append("Скобка вида []: нач. позиция = 1; кон. позиция = 2.")
//                        .append("Скобка вида []: нач. позиция = 1; кон. позиция = 2.")
//                        .append("Скобка вида []: нач. позиция = 1; кон. позиция = 2.")
//                        .append("Скобка вида []: нач. позиция = 1; кон. позиция = 2.")
//                        .append("Скобка вида []: нач. позиция = 1; кон. позиция = 2.")
//                        .append("Скобка вида []: нач. позиция = 1; кон. позиция = 2.")
//                )
//    }
//    }
//
//                )
//
//
//                //        Bracket bracket = new Bracket();
//        List<Bracket> result = sortBrackets.myParserBrackets("([]{}{{}})");
//        List<Bracket> expect = new ArrayList <>();
//
//    }
//
//}


//
//    CofeeMaker cofeeMaker = new CofeeMaker();
//    int[] result = cofeeMaker.changes(150, 101);
//    int[] expect = new int[]{10, 10, 10, 10, 5, 2, 2};
//        Assert.assertThat(result, Is.is(expect));