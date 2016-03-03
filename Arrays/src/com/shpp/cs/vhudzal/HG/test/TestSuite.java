package com.shpp.cs.vhudzal.HG.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestSuite implements Iterable {

    private final List testCases;
    private final String name;

    public TestSuite(String name, TestCase... testCases) {
        this(name, Arrays.asList(testCases));
    }

    public TestSuite(String name, List testCases) {
        this.testCases = new ArrayList(testCases);
        this.name = name;
    }

    public int numTests() {
        return this.testCases.size();
    }

    public String getName() {
        return this.name;
    }

    public TestCase getTestCase(int index) {
        return (TestCase) this.testCases.get(index);
    }

    public Iterator iterator() {
        return this.testCases.iterator();
    }
}
