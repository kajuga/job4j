package ru.job4j.nonblockingcache;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class NonBlockingCacheTest {
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
     * Test update in threads
     */
    @Test
    public void whenRun2ThreadsForUpdateOneObjectInCacheThenVersionChanged() {
        AtomicReference <Exception> ex = new AtomicReference <>();
        Thread threadOne = new Thread(() -> {
            int counter = 0;
            while (counter < 10) {
                counter++;
                Base model = nonBlockingCache.getModel(1);
                model.setName("Semen");
//                Base modelCopy = new Base(model.id, model.name);
//                modelCopy.countVersion();
//                modelCopy.setName("Atos");
                try {
                    nonBlockingCache.update(model);
                } catch (OptimisticException e) {
                    ex.set(e);
                }
//
//                model = nonBlockingCache.getModel(2);
//                model.setName("Barbos");
//                nonBlockingCache.update(model);
            }
        });


        Thread threadTwo = new Thread(() -> {
            int counter = 0;
            while (counter < 10) {
                counter++;
                Base model = nonBlockingCache.getModel(1);
                Base modelCopy = new Base(model.id, model.name);
                modelCopy.countVersion();
                modelCopy.setName("Atos");

//                model.setName("BAtos");
                try {
                    nonBlockingCache.update(modelCopy);
                } catch (OptimisticException e) {
                    ex.set(e);
                }
            }
        });
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(nonBlockingCache.getModel(1).getName(), is("Semen"));
//        assertThat(cache.get(2).getName(), is("Oleg"));
        assertThat(nonBlockingCache.getModel(1).getVer(), is(10));
//        assertThat(nonBlockingCache.get(2).getVersion(), is(10));
    }
}

