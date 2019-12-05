package com.ozka.test;

import org.junit.*;
import com.ozka.main.*;
import static org.junit.Assert.*;

public class TestUserLinkedListTPrimary {

    private UserLinkedListT listT;

    private static final String STRING_A = new String("StringA");
    private static final String STRING_B = new String("StringB");

    private void addObjectsToList(Object... objects) {
        for (Object object : objects) {
            listT.add(object);
        }
    }

    @Before
    public void setUp() throws Exception {
        listT = new UserLinkedListT<String>();
    }


    //-------add and size testing---------

    @Test
    public void addObjectToListAndCheckThatSizeIsOne() {
        addObjectsToList(STRING_A);
        assertEquals(1, listT.size());
    }

    @Test
    public void addTwoObjectsToListAndCheckThatSizeIsTwo() {
        addObjectsToList(STRING_A, STRING_B);
        assertEquals(2, listT.size());
    }

    //-------add and contains testing---------

    @Test
    public void addObjectToListAndCheckThatContainsShowsItExistsInList(){
        addObjectsToList(STRING_A);
        assertEquals(true, listT.contains(STRING_A));
    }

    //-------add, remove, contains and size testing---------

    @Test
    public void addTwoObjectsToListThenDeleteOneAndCheckThatContainsShowTheOtherOneExistsInList(){
        addObjectsToList(STRING_A, STRING_B);
        listT.remove(STRING_A);
        assertEquals(true, listT.contains(STRING_B));
        assertEquals(1, listT.size());
    }


    @Ignore
    @After
    public void cleanUp(){
        listT = null;
    }
}