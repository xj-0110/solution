package com.xj.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Test {



    public static void main(String[] args) throws InterruptedException {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        lists.add(list);
        System.out.println(lists.toString());
        Collections.swap(list,0,1);
        System.out.println(lists.toString());

        ReentrantLock reentrantLock =new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.lockInterruptibly();

    }

}

