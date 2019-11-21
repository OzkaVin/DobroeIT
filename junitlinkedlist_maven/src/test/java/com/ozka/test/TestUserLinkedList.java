package com.ozka.test;

import org.junit.*;
import com.ozka.main.*;

public class TestUserLinkedList {

    private UserLinkedList list;

    private static final Object OBJECT_A = new Object();
    private static final Object OBJECT_B = new Object();


    private void addObjectsToList(Object... objects){
        for(Object object : objects){
            list.add(object);
        }
    }

    @Before
    public void setUp() throws Exception {
        list = new UserLinkedList();
    }

    //-------size testing-----------------

    @Test
    public void checkEmptyListSizeIsNull(){
        Assert.assertEquals(0, list.size());
    }

    //-------add and size testing---------

    @Test
    public void addObjectToListAndCheckThatSizeIsOne(){
        addObjectsToList(OBJECT_A);
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void addTwoObjectsToListAndCheckThatSizeIsTwo(){
        addObjectsToList(OBJECT_A, OBJECT_B);
        Assert.assertEquals(2, list.size());
    }

    //-------add and contains testing---------

    @Test
    public void addObjectToListAndCheckThatContainsShowsItExistsInList(){
        addObjectsToList(OBJECT_A);
        Assert.assertEquals(true, list.contains(OBJECT_A));
    }

    //-------add, remove, contains and size testing---------

    @Test
    public void addTwoObjectsToListThenDeleteOneAndCheckThatContainsShowTheOtehrOneExistsInList(){
        addObjectsToList(OBJECT_A, OBJECT_B);
        list.remove(OBJECT_A);
        Assert.assertEquals(true, list.contains(OBJECT_B));
        Assert.assertEquals(1, list.size());
    }


    @Ignore
    @After
    public void cleanUp(){
        list = null;
    }

}