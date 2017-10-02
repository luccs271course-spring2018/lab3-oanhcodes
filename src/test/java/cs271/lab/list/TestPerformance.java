package cs271.lab.list;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

    // Done run test and record running times for SIZE = 10, 100, 1000, 10000, ...
    // (choose in conjunction with REPS below up to an upper limit where the clock
    // running time is in the tens of seconds)

    // TODO refactor to DRY
    // which of the two lists performs better as the size increases?
    //private final int SIZE = 10;
    private final int SIZE = 100;
    //private final int SIZE = 1000;
    //private final int SIZE = 10000;

    // done choose this value in such a way that you can observe an actual effect
    // for increasing problem sizes

    private final int REPS = 1000000;
    //private final int REPS = 10000000;
    //private final int REPS = 100000000;

    private List<Integer> arrayList;

    private List<Integer> linkedList;

    @Before
    public void setUp() throws Exception {
        arrayList = new ArrayList<Integer>(SIZE);
        linkedList = new LinkedList<Integer>();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @After
    public void tearDown() throws Exception {
        arrayList = null;
        linkedList = null;
    }

    @Test
    public void testLinkedListAddRemove() {
        final long startTime = System.currentTimeMillis();
        for (int r = 0; r < REPS; r++) {
            linkedList.add(0, 77);
            linkedList.remove(0);
        }
        final long endTime   = System.currentTimeMillis();
        final long totalTime = endTime - startTime;
        System.out.println("LinkedList AddRemove with size of " + SIZE + " took: " + totalTime);
    }

    @Test
    public void testArrayListAddRemove() {
        final long startTime = System.currentTimeMillis();
        for (int r = 0; r < REPS; r++) {
            arrayList.add(0, 77);
            arrayList.remove(0);
        }
        final long endTime = System.currentTimeMillis();
        final long totalTime = endTime - startTime;
        System.out.println("ArrayList AddRemove with size of " + SIZE + " took: " + totalTime);
    }

    @Test
    public void testLinkedListAccess() {
        final long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int r = 0; r < REPS; r++) {
            sum += linkedList.get(r % SIZE);
        }
        final long endTime = System.currentTimeMillis();
        final long totalTime = endTime - startTime;
        System.out.println("LinkedList Access with size of " + SIZE + " took: " + totalTime);
    }

    @Test
    public void testArrayListAccess() {
        final long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int r = 0; r < REPS; r++) {
            sum += arrayList.get(r % SIZE);
        }
        final long endTime = System.currentTimeMillis();
        final long totalTime = endTime - startTime;
        System.out.println("ArrayList Access with size of " + SIZE + " took: " + totalTime);
    }
}
