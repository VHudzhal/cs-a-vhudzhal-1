package com.shpp.cs.vhudzal.HG.test;

public class FailureResult extends TestResult {
    public static final FailureResult INSTANCE = new FailureResult();

    public ResultTypeHolder.ResultType getType() {
        return ResultTypeHolder.ResultType.FAILURE;
    }

    public String toString() {
        return "This test failed.  This means that there is a bug somewhere in your code.";
    }
}
