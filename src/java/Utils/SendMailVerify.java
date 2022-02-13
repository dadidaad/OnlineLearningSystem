package Utils;

import Bean.AccountBean;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author win
 */
public class SendMailVerify {

    /**
     * Generate a CAPTCHA String consisting of random lowercase & uppercase
     * letters, and numbers.
     */
    public String generateCaptchaString() {
        int length = 6;
        Random rand = new Random();
        StringBuffer captchaStringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int baseCharNumber = Math.abs(rand.nextInt()) % 62;
            int charNumber = 0;
            if (baseCharNumber < 26) {
                charNumber = 65 + baseCharNumber;
            } else if (baseCharNumber < 52) {
                charNumber = 97 + (baseCharNumber - 26);
            } else {
                charNumber = 48 + (baseCharNumber - 52);
            }
            captchaStringBuffer.append((char) charNumber);
        }

        return captchaStringBuffer.toString();
    }

    //send email to the user email
    public boolean sendEmail(AccountBean user) {
        boolean test = false;

        String toEmail = user.getMail();
        String fromEmail = "dathp.http@gmail.com";
        String password = "vtdhp9x00";

        try {

            // your host email smtp server details
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "25");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message mess = new MimeMessage(session);

            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            //set email subject
            mess.setSubject("User Email Verification");

            //set message text
            mess.setText("Thanks for using Tutor.\nPlease verify your account using this code: " + user.getToken());
            //send the message
            Transport.send(mess);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

//    public static void main(String[] args) {
//        SendMailVerify m = new SendMailVerify();
//        AccountBean x = new AccountBean();
//        x.setMail("dathp.proxy@gmail.com");
//        x.setToken(m.generateCaptchaString());
//        System.out.println(m.sendEmail(x));
//    }
}
