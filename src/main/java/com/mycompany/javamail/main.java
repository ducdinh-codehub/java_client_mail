/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javamail;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Duc
 */
public class main {
    public static String user;
    public static String pass;
    public static JTextField ReAcc = new JTextField(35);
    public static JTextField Cc = new JTextField(35);
    public static JTextArea Content = new JTextArea();
    public static void main(String args[]) throws FileNotFoundException, IOException{
        File file = new File("D:\\java_small_project\\javaMail\\src\\main\\java\\com\\mycompany\\javamail\\accInfor.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        
        while((str = br.readLine()) != null){
            user = str.split(" ")[0];
            pass = str.split(" ")[1];            
        }
        
        System.out.println("Hello world");
        JFrame mainFrame = new JFrame("Main frame");
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
            
        
        JPanel mainPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        
        
        
        JLabel ReAccLabel = new JLabel();
        ReAccLabel.setText("Account");

        JLabel CcLabel = new JLabel();
        CcLabel.setText("CC");
        
        JLabel ContentLabel = new JLabel();
        ContentLabel.setText("Content");
        
        Content.setColumns(35);
        JButton SendingBtb = new JButton();
        SendingBtb.setText("Sending");
        SendingBtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Properties prop = new Properties();
                prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                prop.put("mail.smtp.auth", true);
                prop.put("mail.smtp.starttls.enable", true);
                prop.put("mail.smtp.host", "smtp.gmail.com");
                prop.put("mail.smtp.port", "587");
                
                Session sess =  Session.getInstance(prop, new javax.mail.Authenticator(){
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                        return new javax.mail.PasswordAuthentication(user,pass);
                    }
                });
                
                try{
                    /*
                    ReAcc
                    Cc
                    Content
                    */
                    Message mess = new MimeMessage(sess);
                    mess.setFrom(new InternetAddress("no-reply@gmail.com"));
                    mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ReAcc.getText()));
                    mess.setSubject(Cc.getText());
                    mess.setText(Content.getText());
                    
                    Transport.send(mess);
                    
                    System.out.println("Success");
                    
                    
                }
                catch(Exception g){
                    System.out.println(g);
                }
            }
        });
        
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(ReAccLabel, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(ReAcc, gbc);
        
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
