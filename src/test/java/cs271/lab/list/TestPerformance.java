package cs271.lab.list;

import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class TestPerformance {

    // Done run test and record running times for SIZE = 10, 100, 1000, 10000, ...
    // (choose in conjunction with REPS below up to an upper limit where the clock
    // running time is in the tens of seconds)

    // Done refactor to DRY
    // which of the two lists performs better as the size increases?
    //
    private int size;

    public TestPerformance(int size) {
        this.size = size;
    }

    @Parameterized.Parameters
    public static List<Integer> data() {
        return Arrays.asList(10, 100, 1000, 10000, 100000);
    }

    // Done choose this value in such a way that you can observe an actual effect
    // for increasing problem sizes

    private final int REPS = 100000;
    //private final int REPS = 1000000;
    
    private List<Integer> arrayList;

    private List<Integer> linkedList;

    @Before
    public void setUp() throws Exception {
        arrayList = new ArrayList<Integer>(size);
        linkedList = new LinkedList<Integer>();
        for (int i = 0; i < size; i++) {
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
        for (int r = 0; r < REPS; r++) {
            linkedList.add(0, 77);
            linkedList.remove(0);
        }
    }

    @Test
    public void testArrayListAddRemove() {
        for (int r = 0; r < REPS; r++) {
            arrayList.add(0, 77);
            arrayList.remove(0);
        }
    }

    @Test
    public void testLinkedListAccess() {
        long sum = 0;
        for (int r = 0; r < REPS; r++) {
            sum += linkedList.get(r % size);
        }
    }

    @Test
    public void testArrayListAccess() {
        long sum = 0;
        for (int r = 0; r < REPS; r++) {
            sum += arrayList.get(r % size);
        }
    }
}
