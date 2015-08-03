package com.arcologydesigns.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Boris on 8/1/2015.
 */
public class OptionsForm extends JDialog {

   public static void main() {
      SwingUtilities.invokeLater(new Runnable() {

         @Override
         public void run() {
            final JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            JButton btnDemo = new JButton("JButton");
            JSpinner spnDemo = new JSpinner();
            JComboBox<String> cmbDemo = new JComboBox<String>();
            cmbDemo.addItem("One");
            cmbDemo.addItem("Two");
            cmbDemo.addItem("Three");

            JMenuBar mBar = new JMenuBar();
            frame.setJMenuBar(mBar);
            JMenu mnuLaf = new JMenu("Look and feel");
            JRadioButtonMenuItem mniNimbus = new JRadioButtonMenuItem(
                    "Nimbus");
            JRadioButtonMenuItem mniMetal = new JRadioButtonMenuItem(
                    "Metal");
            JRadioButtonMenuItem mniSystem = new JRadioButtonMenuItem(
                    "Systems");

            ButtonGroup btnGroup = new ButtonGroup();
            btnGroup.add(mniNimbus);
            btnGroup.add(mniMetal);
            btnGroup.add(mniSystem);
            mBar.add(mnuLaf);
            mnuLaf.add(mniNimbus);
            mnuLaf.add(mniMetal);
            mnuLaf.add(mniSystem);

            mniNimbus.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  changeLaf(frame, "nimbus");
               }
            });
            mniMetal.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  changeLaf(frame, "metal");
               }
            });
            mniSystem.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  changeLaf(frame, "system");
               }
            });

            DefaultTableModel model = new DefaultTableModel(
                    new Object[][] {}, new String[] { "First", "Second" });
            model.addRow(new Object[] { "Some text", "Another text" });
            JTable table = new JTable(model);
            panel.add(btnDemo);
            panel.add(spnDemo);
            panel.add(cmbDemo);
            frame.add(panel, BorderLayout.NORTH);
            frame.add(new JScrollPane(table), BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

         }
      });
   }

   public static void changeLaf(JFrame frame, String laf) {
      if (laf.equals("metal")) {
         try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(frame.getRootPane());
            frame.pack();
            frame.revalidate();
            frame.repaint();
         } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
         }
      }
      if (laf.equals("nimbus")) {
         try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frame.getRootPane());
            frame.pack();
            frame.revalidate();
            frame.repaint();
         } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
         }
      }
      if (laf.equals("system")) {
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(frame.getRootPane());
            frame.pack();
            frame.revalidate();
            frame.repaint();
         } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
         }
      }

      SwingUtilities.updateComponentTreeUI(frame);
   }
}