package cs271.lab.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIterator {

    private List<Integer> list;
    // See the Java List Interface documentation to understand what all the List methods do ...

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        // Done also try with a LinkedList - does it make any difference?
        // Answer: All the tests pass even if we use a LinkedList - Neat!
        //list = new LinkedList<Integer>();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void testEmpty() {
        //Returns an iterator over the elements in the list in proper sequence
        final Iterator<Integer> i = list.iterator();
        assertFalse(i.hasNext());
    }

    @Test
    public void testNonempty() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        final Iterator<Integer> i = list.iterator();
        assertTrue(i.hasNext());
        assertEquals(33, i.next().intValue());
        // Done fix the expected values in the assertions below
        assertTrue(i.hasNext());
        assertEquals(77, i.next().intValue());
        assertTrue(i.hasNext());
        assertEquals(44, i.next().intValue());
        assertTrue(i.hasNext());
        assertEquals(77, i.next().intValue());
        assertTrue(i.hasNext());
        assertEquals(55, i.next().intValue());
        assertTrue(i.hasNext());
        assertEquals(77, i.next().intValue());
        assertTrue(i.hasNext());
        assertEquals(66, i.next().intValue());
        assertFalse(i.hasNext());
    }

    @Test
    public void testRemove() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        final Iterator<Integer> i = list.iterator();
        while (i.hasNext()) {
            if (i.next() == 77) {
                i.remove(); // Done what happens if you use list.remove(77)?
                //Answer: Removes the first occurrence of the element in a list
            }
        }
        // Done using assertEquals and Arrays.asList, express which values are left in the list
        // See TestList.java for examples of how to use Arrays.asList; also see the Java Arrays
        // class for more information
        assertEquals(4, list.size());
        assertEquals(Arrays.asList(33, 44, 55, 66), list);

    }

    @Test
    public void testAverageValues() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        double sum = 0;
        int n = 0;
        // Done use an iterator and a while loop to compute the average (mean) of the values
        // (defined as the sum of the items divided by the number of items)
        final Iterator<Integer> i = list.iterator();
        while (i.hasNext()) {
            sum += i.next().intValue();
            n += 1;
        }

        // testNonempty shows how to use an iterator; use i.hasNext() in the while loop condition
        assertEquals(61.3, sum / n, 0.1);
        assertEquals(7, n);
    }
}