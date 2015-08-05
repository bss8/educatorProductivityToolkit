package com.arcologydesigns.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton emailStudentButton;

    public StudentInfoForm() {
        createGUI();
        setActionListeners();
    }

    private void createGUI() {
        // Set title and default close operation
        setTitle("Student Information");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


        // Add the panels to the JFrame
        add(studentInfoPanel);

        // Set the size of the JFrame and make it visible
        setSize(600, 400);
        setVisible(true);
    }

    private void setActionListeners() {
        emailStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailForm emailStudentForm = new EmailForm("Email " + getStudentNameLabel());
                emailStudentForm.setToText(getStudentEmail());

            }
        });
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

    public String getStudentEmail() {
        return studentEmail.getText();
    }

    public String getStudentAddress() {
        return studentAddress.getText();
    }

    public String getStudentID() {
        return studentID.getText();
    }

    public String getStudentPhone() {
        return studentPhone.getText();
    }

    public String getStudentNameLabel() {
        return studentNameLabel.getText();
    }
}
