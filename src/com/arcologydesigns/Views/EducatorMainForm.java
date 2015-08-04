package com.arcologydesigns.Views;

import com.arcologydesigns.GoogleIntegration.SpreadsheetIntegration;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import static java.awt.event.ActionEvent.*;

/**
 * EducatorMainForm created by Borislav S. on 7/11/2015 @ 9:57 PM.
 */
public class EducatorMainForm extends JFrame {
   private char userType;
   private ImageIcon img;
   private JPanel educatorMainPanel;
   private JLabel userIdLabel;
   private JButton importDataButton;
   private JPanel mainContentPanel;
   private JPanel userIdPanel;
   private JLabel helpText1;
   private JLabel helpText2;
   private JTextField assignmentsTextField;
   private JTextField classesTextField;
   private JTextField studentsTextField;
   private JTextField instructorsTextField;
   private JLabel helpText3;
   private JLabel instructorsLabel;
   private JLabel studentsLabel;
   private JLabel classesLabel;
   private JLabel assignmentsLabel;
   private String imgUrl;
   private JPopupMenu pmenu;

   /**
    * MenuItemAction class serves to create a menu item with a label, a visual icon, and a mnemonic.
    * Mnemonics offer a way to use the keyboard to navigate the menu hierarchy, increasing the accessibility of programs.
    * */
   private class MenuItemAction extends AbstractAction {

      public MenuItemAction(String text, Icon icon, Integer mnemonic) {
         super(text);

         putValue(SMALL_ICON, icon);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         System.out.println(e.getActionCommand());
      }
   }

   public EducatorMainForm(char userType) {
      educatorMainPanel.setSize(300, 300);
      //setLocationRelativeTo(null);

      switch (userType) {
         case 'S':
            imgUrl = "images/educator_logo_student.jpg";
            this.userType = userType;
            break;
         case 'I':
            imgUrl = "images/educator_logo_instructor.jpg";
            this.userType = userType;
            break;
         case 'G':
            imgUrl = "images/educator_logo_guest.jpg";
            this.userType = userType;
            break;
         default:
            imgUrl = "images/educator_logo_guest.jpg";
            System.out.print("Invalid user type.");
            break;
      }

      createAndShowGUI();
      createPopupMenu();
      createMenuBar();


      importDataButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            try {
               SpreadsheetIntegration loadClassData = new SpreadsheetIntegration(getClassesTextField(), 'C');
               SpreadsheetIntegration loadAssignmentData = new SpreadsheetIntegration(getAssignmentsTextField(), 'A');
               SpreadsheetIntegration loadStudentData = new SpreadsheetIntegration(getStudentsTextField(), 'S');
               SpreadsheetIntegration loadInstructorData = new SpreadsheetIntegration(getInstructorsTextField(), 'I');
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      });
   }

   private void createAndShowGUI() {

      // Set title and default close operation
      setTitle("Educator Productivity Toolkit - EPT v0.1");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


      // Set a background for JFrame
      ClassLoader cldr = this.getClass().getClassLoader();

      URL imageURL = cldr.getResource(imgUrl);
      if (imageURL != null) {
         img = new ImageIcon(imageURL);
      }

      setContentPane(new JLabel(img));

      // Set some layout, say FlowLayout
      setLayout(new FlowLayout());

      // Set the background, black with 125 as alpha value. This is less transparent
      if(educatorMainPanel != null) {
         educatorMainPanel.setBackground(new Color(33, 71, 116, 165));
         mainContentPanel.setBackground(new Color(33, 71, 116, 165));

         // Set some size to the panels
         educatorMainPanel.setPreferredSize(new Dimension(1920, 600));
         //p2.setPreferredSize(new Dimension(250,150));

         // Add the panels to the JFrame
         add(educatorMainPanel);
      }

      // Set the size of the JFrame and make it visible
      setExtendedState(JFrame.MAXIMIZED_BOTH);  // set to full screen
      setVisible(true);
   } // end createAndShowGUI()

   /**
    * This method creates a right-click context menu for the application.
    * */
   private void createPopupMenu() {

      pmenu = new JPopupMenu();

      JMenuItem maxMi = new JMenuItem("Maximize");
      maxMi.setOpaque(true);

      maxMi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
               setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
         }
      });

      pmenu.add(maxMi);

      JMenuItem quitMi = new JMenuItem("Quit");
      quitMi.setOpaque(true);
      quitMi.setBackground(Color.CYAN);
      quitMi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });

      /**
       * Lambda expression alternative to above function:
       * quitMi.addActionListener((e) -> { System.exit(0); });
       * Only available in Java 8
       * */

      pmenu.add(quitMi);

      /**
       * Listen for a right-click event (Button3) and get the coordinates to display the popup menu
       * */
      addMouseListener(new MouseAdapter() {
         @Override
         public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
               pmenu.show(e.getComponent(), e.getX(), e.getY());
            }
         }
      });
   }

   private void createMenuBar() {
      //Icons for File menu
      Icon iconNew =  UIManager.getIcon("FileChooser.newFolderIcon");
      Icon iconSave =  UIManager.getIcon("FileView.floppyDriveIcon");
      Icon iconOpen =  UIManager.getIcon("Tree.timeFactor");
      Icon iconExit = UIManager.getIcon("InternalFrame.closeIcon");

      //Icons for Options menu item in Tools menu
      Icon iconOptions = UIManager.getIcon("FileChooser.detailsViewIcon");

      //Icons for documentation menu item in Help menu
      Icon iconHelp = UIManager.getIcon("OptionPane.questionIcon");

      //create a menu bar for the application
      JMenuBar menubar = new JMenuBar();

      JMenu fileMenu = new JMenu("File");
      fileMenu.setMnemonic(KeyEvent.VK_F);
      //Menu items for File menu
      JMenuItem newMi = new JMenuItem(new MenuItemAction("New", iconNew, KeyEvent.VK_N));
      JMenuItem openMi = new JMenuItem(new MenuItemAction("Open", iconOpen, KeyEvent.VK_O));
      final JMenuItem saveMi = new JMenuItem(new MenuItemAction("Save", iconSave, KeyEvent.VK_S));
      JMenuItem exitMi = new JMenuItem("Exit", iconExit);

      exitMi.setMnemonic(KeyEvent.VK_E);
      exitMi.setToolTipText("Exit application");
      exitMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, CTRL_MASK));

      exitMi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            System.exit(0);
         }
      });

      fileMenu.add(newMi);
      fileMenu.add(openMi);
      fileMenu.add(saveMi);
      fileMenu.addSeparator();
      fileMenu.add(exitMi);

      JMenu toolsMenu = new JMenu("Tools");
      //Menu items for Tools menu
      JMenuItem optionsMi = new JMenuItem(new MenuItemAction("Options", iconOptions, KeyEvent.VK_O));
      JMenuItem nimbusMi = new JMenuItem(new MenuItemAction("Nimbus LaF", null, null));
      JMenuItem metalMi = new JMenuItem(new MenuItemAction("Metal LaF", null, null));
      JMenuItem systemMi = new JMenuItem(new MenuItemAction("System LaF", null, null));

      toolsMenu.add(optionsMi);
      toolsMenu.add(nimbusMi);
      toolsMenu.add(metalMi);
      toolsMenu.add(systemMi);

      JMenu helpMenu = new JMenu("Help");
      //Menu items for Help menu
      JMenuItem documentationMi = new JMenuItem(new MenuItemAction("Documentation", iconHelp, KeyEvent.VK_H));
      JMenuItem aboutMi = new JMenuItem("About");
      aboutMi.setMnemonic(KeyEvent.VK_A);
      aboutMi.setToolTipText("Learn about the EPT application and access GitHub URL");
      aboutMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, CTRL_MASK));
      JCheckBoxMenuItem sbarMi = new JCheckBoxMenuItem("Show instructions");
      sbarMi.setMnemonic(KeyEvent.VK_S);
      sbarMi.setDisplayedMnemonicIndex(5);
      sbarMi.setSelected(true);

      helpMenu.add(sbarMi);
      helpMenu.add(documentationMi);
      helpMenu.add(aboutMi);

      JMenu information = new JMenu("Information/Details");
      JMenuItem currentUserInfo = new JMenuItem("Current User Info");
      currentUserInfo.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if(userType == 'S') {
               StudentInfoForm studentInfoForm = new StudentInfoForm();
               studentInfoForm.setStudentID(userIdLabel.getText());
            }
            else if(userType == 'I') {
               InstructorInfoForm instructorInfoForm = new InstructorInfoForm();
            }
         }
      });
      information.add(currentUserInfo);

      JMenu analytics = new JMenu("Analytics");
      JMenuItem runAnalytics = new JMenuItem("Run Analytics");
      analytics.add(runAnalytics);

      JMenu viewMenu = new JMenu("View");
      viewMenu.setMnemonic(KeyEvent.VK_V);

      optionsMi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            OptionsForm.main();
         }
      });

      nimbusMi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            OptionsForm.changeLaf(EducatorMainForm.this, "nimbus");
         }
      });

      metalMi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            OptionsForm.changeLaf(EducatorMainForm.this, "metal");
         }
      });

      systemMi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            OptionsForm.changeLaf(EducatorMainForm.this, "system");
         }
      });

      sbarMi.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.DESELECTED) {
               helpText1.setVisible(false);
               helpText2.setVisible(false);
               helpText3.setVisible(false);
            } else {
               helpText1.setVisible(true);
               helpText2.setVisible(true);
               helpText3.setVisible(true);
            }
         }
      });

      //add menu items to the menu bar and set the menu
      menubar.add(fileMenu);
      menubar.add(viewMenu);
      menubar.add(toolsMenu);
      menubar.add(information);
      menubar.add(analytics);
      menubar.add(Box.createHorizontalGlue());
      menubar.add(helpMenu);

      setJMenuBar(menubar);
   }

   public void setUserIdLabel(String _userIdLabel) {
      this.userIdLabel.setText(_userIdLabel);
   }

   public void setImageURL(String _imageURL) {
      imgUrl = _imageURL;
   }

   public String getAssignmentsTextField() {
      return assignmentsTextField.getText();
   }

   public String getClassesTextField() {
      return classesTextField.getText();
   }

   public String getStudentsTextField() {
      return studentsTextField.getText();
   }

   public String getInstructorsTextField() {
      return instructorsTextField.getText();
   }
} // end class EducatorMainForm
