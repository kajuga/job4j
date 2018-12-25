package ru.job4j.nonblockingcache;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class NonBlockingCacheTest {
    private volatile boolean optimisticExceptionIsOn = false;
    private NonBlockingCache nonBlockingCache = new NonBlockingCache();

    @Before
    public void beforeTest() {
        nonBlockingCache.add(new Base(1, "Sashok"));
        nonBlockingCache.add(new Base(2, "Pushok"));
        nonBlockingCache.add(new Base(4, "Abrashok"));
        nonBlockingCache.add(new Base(7, "Bioshok"));
    }

    /**
     * Test add
     */
    @Test
    public void whenAddNewBaseModelsThenMyCacheContainsNewModelsWithZeroVersion() {
        assertThat(nonBlockingCache.getModel(1).getName(), is("Sashok"));
        assertThat(nonBlockingCache.getModel(1).getVer(), is(0));
        assertThat(nonBlockingCache.getModel(7).getName(), is("Bioshok"));
        assertThat(nonBlockingCache.getModel(4).getName(), is("Abrashok"));
        assertThat(nonBlockingCache.getModel(7).getVer(), is(0));
        assertThat(nonBlockingCache.getModel(4).getVer(), is(0));
    }

    /**
     * Test delete
     */
    @Test
    public void whenDeleteExistingModelThenDeletedFromNonBlockingCash() {
        Base model = nonBlockingCache.getModel(1);
        Base model2 = nonBlockingCache.getModel(7);
        assertThat(nonBlockingCache.delete(model), is(true));
        assertThat(nonBlockingCache.getModel(1), nullValue());
        assertThat(nonBlockingCache.getModel(7), is(model2));
        assertThat(nonBlockingCache.delete(model2), is(true));
        assertThat(nonBlockingCache.getModel(7), nullValue());
        assertThat(nonBlockingCache.getModel(888), nullValue());
    }

    /**
     * Test update
     */
    @Test
    public void whenUpdateExistBaseModelThenBaseModelUpdated() {
        Base model = nonBlockingCache.getModel(1);
        assertThat(nonBlockingCache.getModel(1).getName(), is("Sashok"));
        assertThat(nonBlockingCache.getModel(1).getVer(), is(0));
        model.setName("Vasya");
        nonBlockingCache.update(model);
        assertThat(nonBlockingCache.getModel(1).getName(), is("Vasya"));
        assertThat(nonBlockingCache.getModel(1).getVer(), is(1));
        model.setName("Pedro");
        nonBlockingCache.update(model);
        assertThat(nonBlockingCache.getModel(1).getVer(), is(2));
        assertThat(nonBlockingCache.getModel(1).getName(), is("Pedro"));
    }

    /**
     * Test update in threads -
     */
    @Test
    public void nonblockingOptimisticExceptionTest() {
        Base modelForTestThreads = nonBlockingCache.getModel(1);
        nonBlockingCache.add(modelForTestThreads);

        Runnable r = () -> {
            while(!Thread.currentThread().isInterrupted()) {
                modelForTestThreads.setVer(modelForTestThreads.getVer() + 1);
                try {
                    nonBlockingCache.update(modelForTestThreads);
                } catch (OptimisticException e) {
                    optimisticExceptionIsOn = true;
                    break;
                }
            }
        };

        Thread firstThread = new Thread(r);
        Thread secondThread = new Thread(r);

        firstThread.start();
        secondThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        firstThread.interrupt();
        secondThread.interrupt();

        assertTrue(optimisticExceptionIsOn);
    }
}