package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * CyclingFinder Test
 *
 * @author Fedorov Aleksandr (msg2fedorov@mail.com)
 * @version $Id$
 * @since 0.1
 */
@SuppressWarnings("unchecked")
public class CycleSearcherTest {

    private Node first;
    private Node two;
    private Node third;
    private Node four;
    private CycleSearcher searcher;

    @Before
    public void beforeTest() {
        first = new Node(1);
        two = new Node(2);
        third = new Node(3);
        four = new Node(4);
        searcher = new CycleSearcher();
    }

    /**
     * Test hasCycle
     */
    @Test
    public void whenHasCyclingThenReturnTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(searcher.hasCycle(first), is(true));
    }

    @Test
    public void whenHasNotCyclingThenReturnFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(searcher.hasCycle(first), is(false));
    }
}