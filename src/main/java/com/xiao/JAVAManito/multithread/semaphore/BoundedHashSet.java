package com.xiao.JAVAManito.multithread.semaphore;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by unclexiao on 14/06/2018.
 */
public class BoundedHashSet {
    private final Set set;
    private Semaphore semaphore;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet(bound));
        this.semaphore = new Semaphore(bound);
    }


    public void add(Object o) {
        boolean wasAdd = false;
        try {
            this.semaphore.acquire();
            wasAdd = this.set.add(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!wasAdd) {
                //如果没有添加成功
                this.semaphore.release();
            }
        }
    }

    public void remove(Object o) {
        boolean wasRemoved = false;
        wasRemoved = this.set.remove(o);
        if (wasRemoved) {
            this.semaphore.release();
        }
    }
}
