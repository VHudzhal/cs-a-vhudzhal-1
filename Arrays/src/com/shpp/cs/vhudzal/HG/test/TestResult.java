package com.shpp.cs.vhudzal.HG.test;

public abstract class TestResult {
    public abstract ResultTypeHolder.ResultType getType();

    public static TestResult success() {
        return SuccessResult.INSTANCE;
    }

    public static TestResult failure() {
        return FailureResult.INSTANCE;
    }

    public static TestResult exception(Exception e) {
        return new ExceptionResult(e);
    }
}
