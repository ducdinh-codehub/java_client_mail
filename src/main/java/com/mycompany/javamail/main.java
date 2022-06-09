/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javamail;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Duc
 */
public class main {
    public static void main(String args[]){
        System.out.println("Hello world");
        JFrame mainFrame = new JFrame("Main frame");
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
            
        
        JPanel mainPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        
        JTextField MyAccount = new JTextField(35);
        
        JLabel MyAccountLabel = new JLabel();
        MyAccountLabel.setText("Your account");
        JTextField MyPassword = new JPasswordField(35);
        JLabel MyPasswordLabel = new JLabel();
        MyPasswordLabel.setText("Your password");
        JLabel CcLabel = new JLabel();
        CcLabel.setText("CC");
        JTextField Cc = new JTextField(35);
        JLabel ContentLabel = new JLabel();
        ContentLabel.setText("Content");
        JTextArea Content = new JTextArea();
        Content.setColumns(35);
        JButton SendingBtb = new JButton();
        SendingBtb.setText("Sending");
        
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(MyAccountLabel, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(MyAccount, gbc);
        
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        mainPanel.add(MyPasswordLabel, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        mainPanel.add(MyPassword, gbc);
        
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(CcLabel, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(Cc, gbc);
        
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(ContentLabel, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 75;
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(Content, gbc);
        
        gbc.weighty = 0.3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(SendingBtb, gbc);
        
        mainFrame.add(mainPanel);
        mainFrame.setSize(550, 380);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        
    }
}
