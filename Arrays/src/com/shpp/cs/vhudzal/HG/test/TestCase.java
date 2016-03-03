package com.shpp.cs.vhudzal.HG.test;

public abstract class TestCase {
    public abstract String getName();

    public abstract boolean runTest();

    public final TestResult resultOf() {
        try {
            return this.runTest() ? TestResult.success() : TestResult.failure();
        } catch (Exception var2) {
            return TestResult.exception(var2);
        }
    }
}
