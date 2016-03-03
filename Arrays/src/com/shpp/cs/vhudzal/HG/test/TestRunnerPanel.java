package com.shpp.cs.vhudzal.HG.test;

import acm.gui.TablePanel;
import com.shpp.cs.vhudzal.HG.test.gui.TestPanel;

import java.util.*;

public class TestRunnerPanel extends TablePanel {
    private final List tests;
    private final Map panels;
    private static final int HORIZONTAL_GAP = 5;

    public TestRunnerPanel(TestSuite... tests) {
        this(Arrays.asList(tests));
    }

    public TestRunnerPanel(List tests) {
        super(1, tests.size(), 5, 0);
        this.panels = new HashMap();
        this.tests = new ArrayList(tests);
        Iterator var3 = tests.iterator();

        while (var3.hasNext()) {
            TestSuite suite = (TestSuite) var3.next();
            TestPanel panel = new TestPanel(suite);
            this.panels.put(suite, panel);
            this.add(panel, "anchor=NORTH");
        }

    }

    public void runTests() {
        Iterator var2 = this.tests.iterator();

        while (var2.hasNext()) {
            final TestSuite suite = (TestSuite) var2.next();
            Iterator var4 = suite.iterator();

            while (var4.hasNext()) {
                final TestCase teest = (TestCase) var4.next();
                (new Thread() {
                    public void run() {
                        ((TestPanel) TestRunnerPanel.this.panels.get(suite)).testCompleted(teest, teest.resultOf());
                    }
                }).start();
            }
        }

    }
}
