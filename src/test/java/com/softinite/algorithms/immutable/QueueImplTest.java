package com.softinite.algorithms.immutable;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for QueueImpl
 * Created by Softinite on 2016-03-08.
 */
public class QueueImplTest {

    private Queue<String> queue;

    @BeforeMethod
    public void setup() {
        queue = new QueueImpl<>();
    }

    @Test
    public void headIsTheOneToBeReturnedByDequeue() {
        String one = "One";
        String two = "Two";
        String three = "Three";
        Queue<String> oneQueue = new QueueImpl<>(one);
        Queue<String> twoQueue = oneQueue.enQueue(two);
        Queue<String> threeQueue = twoQueue.enQueue(three);

        Assert.assertNotEquals(oneQueue, twoQueue);
        Assert.assertNotEquals(twoQueue, threeQueue);
        Assert.assertNotEquals(threeQueue, oneQueue);

        Assert.assertEquals(oneQueue.head(), one);
        Assert.assertEquals(twoQueue.head(), one);
        Assert.assertEquals(threeQueue.head(), one);

        Queue<String> emptyQueue = oneQueue.deQueue();
        Assert.assertTrue(emptyQueue.isEmpty());

        Queue<String> oneQueueP = twoQueue.deQueue();
        Assert.assertEquals(oneQueueP.head(), two);
        Assert.assertNotEquals(oneQueue, oneQueueP);

        Queue<String> twoQueueP = threeQueue.deQueue();
        Assert.assertEquals(twoQueueP.head(), two);
        Assert.assertNotEquals(twoQueue, twoQueueP);
        oneQueueP = twoQueueP.deQueue();
        Assert.assertEquals(oneQueueP.head(), three);
        Assert.assertNotEquals(oneQueueP, oneQueue);
        emptyQueue = oneQueueP.deQueue();
        Assert.assertTrue(emptyQueue.isEmpty());

    }

    @Test
    public void afterDequeingLastElementTheOriginalQueueIsNotEmptyButTheNewOneIs(){
        Queue<String> oneQueue = new QueueImpl<>("One");
        Queue<String> emptyQueue = oneQueue.deQueue();
        Assert.assertNotEquals(oneQueue, emptyQueue);
        Assert.assertFalse(oneQueue.isEmpty());
        Assert.assertTrue(emptyQueue.isEmpty());
    }

    @Test
    public void afterEnqueuingOneElementTheOriginalQueueIsStillEmptyButNotTheNewOne() {
        Queue<String> oneQueue = queue.enQueue("1");
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(oneQueue.isEmpty());
    }

    @Test
    public void isEmptyReturnsTrueByDefault() {
        Assert.assertTrue(queue.isEmpty());
    }

}
