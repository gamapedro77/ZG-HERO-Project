package com.linketinder.services;

import com.linketinder.model.Candidato;
import com.linketinder.model.Vaga;
import com.linketinder.repository.CandidatoRepository;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.client.HttpClient;


import javax.inject.Singleton;
import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;

import java.util.Map;
import java.util.Properties;
@Singleton
public class EmailSender {

    String senha;


    private final CandidatoRepository candidatoRepository;

    public EmailSender(CandidatoRepository candidatoRepository, @Value("${email.senha}") String senha) {
        this.candidatoRepository = candidatoRepository;
        this.senha = senha;
    }

    private static Properties getProperties() {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        return props;
    }

    private Session getSession() {

        return Session.getDefaultInstance(getProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("linketinder@gmail.com", senha);
            }
        });
    }
    public ArrayList<String> getEmails() {
        Iterable<Candidato> candidatos = candidatoRepository.findAll();

        ArrayList<String> emails = new ArrayList<>();
            candidatos.forEach(candidato -> {
                emails.add(candidato.getEmail());
            });
        return emails;
    }
    public void sendEmail(Vaga vaga) {
        try {
            System.out.println(senha);
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(getSession());

            // Set From: header field of the header.
            message.setFrom(new InternetAddress("linketinder@gmail.com"));

            // Set To: header field of the header.
            ArrayList<String> emails = getEmails();
            emails.forEach(email -> {
                try {
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            });


            // Set Subject: header field
            message.setSubject("Veja esta nova vaga no linketinder!");

            // Send the actual HTML message, as big as you like
            message.setContent("<h1>"+ vaga.getNome()+ "</h1>", "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
