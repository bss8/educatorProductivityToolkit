package com.arcologydesigns.Views;

import com.sun.javafx.scene.control.Keystroke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import static java.awt.event.ActionEvent.*;

/**
 * EducatorMainForm created by Borislav S. on 7/11/2015 @ 9:57 PM.
 */
public class EducatorMainForm extends JFrame {

   private ImageIcon img;
   private JPanel educatorMainPanel;
   private JLabel userIdLabel;
   private JButton importDataButton;
   private JPanel mainContentPanel;
   private JPanel userIdPanel;
   private JLabel helpText1;
   private JLabel helpText2;
   private JTextField httpsDocsGoogleComTextField3;
   private JTextField httpsDocsGoogleComTextField2;
   private JTextField httpsDocsGoogleComTextField1;
   private JTextField httpsDocsGoogleComTextField;
   private JLabel helpText3;
   private String imgUrl;
   private JPopupMenu pmenu;

   private class MenuItemAction extends AbstractAction {

      public MenuItemAction(String text, Icon icon,
                            Integer mnemonic) {
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
            break;
         case 'I':
            imgUrl = "images/educator_logo_instructor.jpg";
            break;
         case 'G':
            imgUrl = "images/educator_logo_guest.jpg";
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
      Icon iconNew =  UIManager.getIcon("FileChooser.newFolderIcon");
      Icon iconSave =  UIManager.getIcon("FileView.floppyDriveIcon");
      Icon iconOpen =  UIManager.getIcon("Tree.timeFactor");
      Icon iconExit = UIManager.getIcon("InternalFrame.closeIcon");

      Icon iconOptions = UIManager.getIcon("FileChooser.detailsViewIcon");

      Icon iconHelp = UIManager.getIcon("OptionPane.questionIcon");


      JMenuBar menubar = new JMenuBar();

      JMenu fileMenu = new JMenu("File");
      fileMenu.setMnemonic(KeyEvent.VK_F);

      JMenuItem newMi = new JMenuItem(new MenuItemAction("New", iconNew, KeyEvent.VK_N));
      JMenuItem openMi = new JMenuItem(new MenuItemAction("Open", iconOpen, KeyEvent.VK_O));
      JMenuItem saveMi = new JMenuItem(new MenuItemAction("Save", iconSave, KeyEvent.VK_S));

      JMenuItem optionsMi = new JMenuItem(new MenuItemAction("Options", iconOptions, KeyEvent.VK_O));
      JMenuItem nimbusMi = new JMenuItem(new MenuItemAction("Nimbus LaF", null, null));
      JMenuItem metalMi = new JMenuItem(new MenuItemAction("Metal LaF", null, null));
      JMenuItem systemMi = new JMenuItem(new MenuItemAction("System LaF", null, null));

      JMenuItem documentationMi = new JMenuItem(new MenuItemAction("Documentation", iconHelp, KeyEvent.VK_H));
      JMenuItem aboutMi = new JMenuItem("About");
      aboutMi.setMnemonic(KeyEvent.VK_A);
      aboutMi.setToolTipText("Learn about the EPT application and access GitHub URL");
      aboutMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, CTRL_MASK));

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

      JMenu viewMenu = new JMenu("View");
      viewMenu.setMnemonic(KeyEvent.VK_V);

      JMenu toolsMenu = new JMenu("Tools");
      toolsMenu.add(optionsMi);
      toolsMenu.add(nimbusMi);
      toolsMenu.add(metalMi);
      toolsMenu.add(systemMi);

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

      JMenu helpMenu = new JMenu("Help");
      helpMenu.add(documentationMi);
      helpMenu.add(aboutMi);

      JCheckBoxMenuItem sbarMi = new JCheckBoxMenuItem("Show statubar");
      sbarMi.setMnemonic(KeyEvent.VK_S);
      sbarMi.setDisplayedMnemonicIndex(5);
      sbarMi.setSelected(true);

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

      viewMenu.add(sbarMi);
      menubar.add(fileMenu);
      menubar.add(viewMenu);
      menubar.add(toolsMenu);
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

} // end class EducatorMainForm
