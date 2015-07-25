package com.arcologydesigns.Views;

import javax.swing.*;

/**
 * Created by bss64 on 7/14/2015.
 */

public class StudentInfoForm extends JDialog {
    private JLabel studentNameLabel;
    private JPanel studentInfoPanel;

    public StudentInfoForm() {
        // Set title and default close operation
        setTitle("Student Information");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


        // Add the panels to the JFrame
        add(studentInfoPanel);

        // Set the size of the JFrame and make it visible
        setSize(600, 400);
        setVisible(true);
    }

    public void setStudentNameLabel(String studentNameLabel) {
        this.studentNameLabel.setText(studentNameLabel);
    }
}
