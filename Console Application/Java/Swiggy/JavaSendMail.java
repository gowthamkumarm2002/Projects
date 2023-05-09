package swiggy;

import swiggy.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;


class JavaSendMail {
    
    public void sendMail(String to,String username,String id)throws IOException, ClassNotFoundException, FileNotFoundException,InterruptedException{
        File file4 = new File("Files/UserDetails/BilledDetails.txt");
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;

        LinkedList<UserBill> dlist6 = new LinkedList<UserBill>();
        if(file4.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file4));
            dlist6 = (LinkedList<UserBill>)ois.readObject();
            ois.close();
        }


        String host = "smtp.gmail.com";
        final String user = "swiggybot2@gmail.com";
        final String password = "cxnosmwicmscgcfx";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props,new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });
        float total = 0f;
        String txt = "\t\t\tTHANK YOU FOR ORDER\n\n\t\t\tTRACKING ID : "+id+"\n";
        for(UserBill h:dlist6){
            if(username.equalsIgnoreCase(h.u_name) && h.tracking_id.equals(id)){
                txt += "\n\t\t\t"+h.d_name+"  : "+h.quantity+" : "+h.ori_rate+"\n";
                total += Float.valueOf(h.ori_rate);
            }
        }
        txt += "\n\t\t\t\t  Total Amount : "+total;
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Order Details");
            
            message.setText(txt);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
