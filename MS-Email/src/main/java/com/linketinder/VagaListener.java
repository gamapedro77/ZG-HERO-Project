package com.linketinder;

import com.linketinder.model.Email;
import com.linketinder.model.Vaga;
import com.linketinder.repository.CandidatoRepository;
import com.linketinder.services.EmailSender;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.MessageBody;
import jakarta.inject.Inject;

/**
 * kafka-streams requires at least one listener
 */
@KafkaListener(groupId = "ExampleListener")
public class VagaListener {
    private final EmailSender emailSender;

    public VagaListener(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Topic("vagas")
    void example(@MessageBody Vaga vaga) {
        emailSender.sendEmail(vaga);
    }
}
