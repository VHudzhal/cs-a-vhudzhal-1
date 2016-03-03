package com.shpp.cs.vhudzal.HG.test.gui;

import acm.gui.TablePanel;
import com.shpp.cs.vhudzal.HG.test.TestCase;
import com.shpp.cs.vhudzal.HG.test.TestResult;

import javax.swing.*;
import java.awt.*;

public class TestCaseRow extends TablePanel {
    private ResultBox resultBox = new ResultBox();
    private JTextArea text;

    public TestCaseRow(TestCase test) {
        super(1, 2);
        this.text = new JTextArea(test.getName());
        this.text.setEditable(false);
        this.text.setLineWrap(true);
        this.text.setWrapStyleWord(true);
        this.text.setPreferredSize(new Dimension(150, 50));
        this.add(this.resultBox);
        this.add(this.text);
    }

    public void setResult(TestResult result) {
        this.resultBox.setResult(result);
    }
}
