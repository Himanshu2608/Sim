package javadoor;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email_test {
	public static String sender_mail;
	public static String ottp;
	public Email_test(String temp,String otp) {
		sender_mail=temp;
		ottp=otp;

        final String username = "simsimiiita@gmail.com";
        final String password = "simsimsim";
        final String to_mail="physicscarnot@gmail.com";
        
        
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    
                    InternetAddress.parse("simsimiiita@gmail.com,"+sender_mail)
            );
            message.setSubject("SIM SIM OTP");
            message.setText("Dear user,"
                    + "\n\n OTP for registration is " + ottp);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
		
	}
	
    public static void main(String[] args) {
    	//Email_test temp=new Email_test("iit2020025@iiita.ac.in","1223");
    	
	}


}
