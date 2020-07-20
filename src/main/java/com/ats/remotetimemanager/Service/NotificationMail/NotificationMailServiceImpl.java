package com.ats.remotetimemanager.Service.NotificationMail;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

@Service
public class NotificationMailServiceImpl implements NotificationMailService{

    @Autowired
    private JavaMailSender javaMAilSender;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void sendNotification(User user, String password) throws MailException {
        // send mail
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("no-reply@remoteMonitoring.com");
        mail.setSubject("Remote Monitoring");
        if (!userRepository.findAll().isEmpty()) {
            mail.setText("Hello " + user.getFirstName() + " " + user.getName() + ",\n you have been added to " + user.getDepartment().getDepName() + " department by your employer.\n \nHere are your login credentials:\nCIN: " + user.getCin() + "\nPassword: " + password + "\n \n you can change your password once you are logged in.");
        } else {
            mail.setText("Hello " + user.getFirstName() + " " + user.getName() + ",\n your application is all set up.\n \nHere are your login credentials:\nCIN: " + user.getCin() + "\nPassword: " + password + "\n \n you can change your password once you are logged in.\n \n Thank you for choosing Remote Monitoring application.");
        }
        javaMAilSender.send(mail);
    }

    public void sendFeedback(Data data){
       /* // send mail
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("vapeordie123@gmail.com");
        mail.setFrom("no-reply@vapeOrdie.com");
        mail.setSubject("User message");
        mail.setText("User Email: "+data.getEmail()+"\n"+"Message: "+data.getMessage());
        javaMAilSender.send(mail);*/
    }
}
