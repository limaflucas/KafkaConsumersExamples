package br.com.limaflucas.KafkaConsumersExamples.adapters.web;


import br.com.limaflucas.KafkaConsumersExamples.adapters.web.models.RegularMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RestEntryPoint {

    @Value(value = "${application.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping(path = "message")
    public void sendMessage(@RequestBody RegularMessage regularMessage) {

        log.info("Received message: {}", regularMessage);
        this.kafkaTemplate.send(regularMessage.getTopic(), regularMessage.getMessage(), regularMessage.getMessage());
    }
}
