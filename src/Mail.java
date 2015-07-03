import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Mail created by Borislav S. on 7/1/2015 @ 10:00 PM.
 */
public class Mail {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    public static void generateAndSendEmail() throws AddressException, MessagingException {

        // Step1: specify ports and connection info / server properties
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties setup successfully...");

        // Step2: get a mail session and fill an email message with necessary info (subject, to, cc, from)
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("bss64@txstate.edu"));
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("ajn21@txstate.edu"));
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("arnissim@gmail.com"));

        //generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("arnissim@gmail.com"));
        generateMailMessage.setSubject("Greetings from Group4-RR-MailServer!");
        String emailBody = "TLS Test email for JavaMail API example (for the next project)"
                + "<br><br>Mail Session created successfully (I hope)..."
                + "<br><br> Please let me know if you see this message"
                + "<br><br> Regards, <br>Boris";
        generateMailMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session created successfully...");

        // Step3: transport the message
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter a correct Gmail UserID and Password
        // using 2FA (2 factor authentication), thus the password is App Specific and not a string literal
        transport.connect("smtp.gmail.com", "defaultbusinessacct01@gmail.com", "loaphdmteeaeasak");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
}