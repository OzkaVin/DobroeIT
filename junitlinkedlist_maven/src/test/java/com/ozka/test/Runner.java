package com.ozka.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class Runner {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses
                (TestUserLinkedListTSuite.class);
        System.out.println(result.getRunCount());
    }
}
