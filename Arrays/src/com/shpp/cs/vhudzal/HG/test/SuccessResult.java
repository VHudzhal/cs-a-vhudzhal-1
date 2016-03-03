package com.shpp.cs.vhudzal.HG.test;


public class SuccessResult extends TestResult {
    public static final SuccessResult INSTANCE = new SuccessResult();

    public ResultTypeHolder.ResultType getType() {
        return ResultTypeHolder.ResultType.SUCCESS;
    }

    public String toString() {
        return "Test passed!  Nice job!";
    }
}
