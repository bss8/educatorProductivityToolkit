package com.arcologydesigns.emailService;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static java.lang.System.*;

/**
 * com.arcologydesigns.emailServicedesigns.Mail created by Borislav S. on 7/1/2015 @ 10:00 PM.
 */
public class Mail {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;
    static boolean isMessageValid;

    public Mail() {
        isMessageValid = false;
    }

    public static boolean generateAndSendEmail(String _toField, String _ccField, String _subject, String _message)
            throws MessagingException {
        // STEP_1: specify ports and connection info / server properties
        out.println("\n 1st ===> setup com.arcologydesigns.emailServicedesigns.Mail Server Properties..");
        mailServerProperties = getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        out.println("com.arcologydesigns.emailServicedesigns.Mail Server Properties setup successfully...");

        if ( !_toField.equals("-") ) {

            // STEP_2: get a mail session and fill an email message with necessary info (subject, to, cc, from)
            out.println("\n\n 2nd ===> get com.arcologydesigns.Mailns.emailService.Mail Session..");
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            if(!_toField.contains(";")) {
                generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(_toField));
            } else {
                String split[] = _toField.split(";");
                for(String s : split) {
                    generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(s));
                }
            }

            // make CC field optional
            if (!_ccField.equals("-")) {
                generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(_ccField));
            }
            // message subject
            generateMailMessage.setSubject(_subject);

            generateMailMessage.setContent(_message, "text/html");
            out.println("com.arcologydesigns.Mailns.emailService.Mail Session created successfully...");

            // STEP_3: transport the message
            out.println("\n\n 3rd ===> Get Session and Send mail");
            Transport transport = getMailSession.getTransport("smtp");

            // Enter a correct Gmail UserID and Password
            // using 2FA (2 factor authentication), thus the password is App Specific and not a string literal
            transport.connect("smtp.gmail.com", "defaultbusinessacct01@gmail.com", "loaphdmteeaeasak");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();

            isMessageValid = true;

        } else {
            isMessageValid = false;
            out.printf("Message contains blank fields. All fields are required.");
        }

        return isMessageValid;

    }  //end generateAndSendEmail
}  //end class com.arcologydesigns.emailServicedesigns.Mail