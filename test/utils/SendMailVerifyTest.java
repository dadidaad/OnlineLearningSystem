/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import bean.AccountBean;
import com.icegreen.greenmail.junit.GreenMailRule;
import com.icegreen.greenmail.util.ServerSetupTest;
import com.sun.mail.imap.IMAPStore;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Rule;

/**
 *
 * @author Admin
 */
public class SendMailVerifyTest {

    private SendMailVerify smf;

    public SendMailVerifyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        smf = new SendMailVerify();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGenerateCaptchaString() {
        String captcha = smf.generateCaptchaString();
        assertNotNull(captcha);
        assertEquals(6, captcha.length());

    }

    @Test(expected = ArithmeticException.class)
    public void testAbsMinValue() {
        int x = Integer.MIN_VALUE;
        SendMailVerify.abs(x);
    }

    @Test
    public void testAbsNegativeValue() {
        int x = -2;
        int result = SendMailVerify.abs(x);
        assertEquals(2, result);
    }

    @Test
    public void testAbsPostiveValue() {
        int x = 2;
        int result = SendMailVerify.abs(x);
        assertEquals(2, result);
    }

    @Test
    public void testSendEmail() throws MessagingException {
        AccountBean x = new AccountBean();
        x.setMail("dathp.proxy@gmail.com");
        boolean result = smf.sendEmail(x);
        assertEquals(true, result);
    }

    @Test
    public void testSendEmailEmtpy() throws MessagingException {
        AccountBean x = new AccountBean();
        x.setMail("");
        boolean result = smf.sendEmail(x);
         assertEquals(false, result);
    }

    @Test(expected = NullPointerException.class)
    public void testSendEmailNullMail() throws MessagingException {
        AccountBean x = new AccountBean();
        boolean result = smf.sendEmail(x);
        assertEquals(false, result);
    }

}
