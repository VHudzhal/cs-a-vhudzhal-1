package com.shpp.cs.vhudzal.HG.test.gui;

import acm.gui.TablePanel;
import com.shpp.cs.vhudzal.HG.test.TestCase;
import com.shpp.cs.vhudzal.HG.test.TestResult;
import com.shpp.cs.vhudzal.HG.test.TestSuite;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestPanel extends TablePanel {
    private final TestSuite testSuite;
    private final Map testRows = new HashMap();
    private static final int SPACING = 5;

    public TestPanel(TestSuite suite) {
        super(suite.numTests() + 1, 1, 5, 5);
        this.testSuite = suite;
        JLabel name = new JLabel(suite.getName(), 0);
        this.add(name);
        Iterator var4 = this.testSuite.iterator();

        while (var4.hasNext()) {
            TestCase teest = (TestCase) var4.next();
            TestCaseRow row = new TestCaseRow(teest);
            this.testRows.put(teest, row);
            this.add(row, "anchor=WEST");
        }

        this.setBorder(new LineBorder(Color.BLACK, 1));
    }

    public void testCompleted(TestCase test, TestResult result) {
        ((TestCaseRow) this.testRows.get(test)).setResult(result);
    }
}
