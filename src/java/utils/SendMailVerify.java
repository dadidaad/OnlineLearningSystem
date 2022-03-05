/*
 * Copyright(C) 2022, FPT University.
 * OLS
 * Online Learning System
 * SendMailVerify
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-11      1.0                 Dajtvox          
 */
package utils;

import bean.AccountBean;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * The class contains method generate random captcha and send mail, support for
 * send captcha verify to user if sign up or reset password The method will
 * throw an object of <code>java.Execption</code> if there is any error
 * occurring when send mail
 * <p>
 * Bugs: Still not have yet
 *
 * @author Dajtvox
 */
public class SendMailVerify {


    /**
     * Generate a CAPTCHA String consisting of random lowercase & uppercase
     * letters, and numbers.
     *
     * @return
     */
    public String generateCaptchaString() {
        int length = 6;
        SecureRandom rand = new SecureRandom();
        StringBuilder captchaStringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int baseCharNumber = abs(rand.nextInt()) % 62;
            int charNumber = 0;
            if (baseCharNumber < 26) {
                charNumber = 65 + baseCharNumber;
            } else if (baseCharNumber < 52) {
                charNumber = 97 + (baseCharNumber - 26);
            } else {
                charNumber = 48 + (baseCharNumber - 52);
            }
            captchaStringBuilder.append((char) charNumber);
        }

        return captchaStringBuilder.toString();
    }

    /**
     * Fail-fast wrapper for {@link Math#abs(int)}
     *
     * @param x
     * @return the absolute value of x
     * @throws ArithmeticException when a negative value would have been
     * returned by {@link Math#abs(int)}
     */
    public static int abs(int x) throws ArithmeticException {
        if (x == Integer.MIN_VALUE) {
            // fail instead of returning Integer.MAX_VALUE
            // to prevent the occurrence of incorrect results in later computations
            throw new ArithmeticException("Math.abs(Integer.MIN_VALUE)");
        }
        return Math.abs(x);
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
            pr.put("mail.smtp.ssl.checkserveridentity", true);
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
            StringBuilder sb = new StringBuilder();
            sb.append("Thanks for using TutorDuo.\n");
            sb.append("You sign up our serive with user name is ").append(user.getUsername()).append(".\n");
            sb.append("Please verify your account using this code: ").append(user.getToken());
            //set message text
            mess.setText(sb.toString());
            //send the message
            Transport.send(mess);

            test = true;

        } catch (MessagingException ex) {
            Logger.getLogger(SendMailVerify.class.getName()).log(Level.SEVERE, null, ex);
        }

        return test;
    }

}
