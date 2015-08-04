package com.arcologydesigns.Views;

import javax.swing.*;

/**
 * Created by bss64 on 7/14/2015.
 * edited by arnissim on 7/28/2015
 */

public class StudentInfoForm extends JDialog {
    private JPanel studentInfoPanel;
    private JLabel studentNameLabel;
    private JLabel studentPhone;
    private JLabel studentID;
    private JLabel studentAddress;
    private JLabel studentEmail;

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

    public void setStudentPhone(String studentPhone) {
        this.studentPhone.setText(studentPhone);
    }

    public void setStudentID(String studentID) {
        this.studentID.setText(studentID);
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress.setText(studentAddress);
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail.setText(studentEmail);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
