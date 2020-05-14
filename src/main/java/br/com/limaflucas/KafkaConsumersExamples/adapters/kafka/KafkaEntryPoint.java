package br.com.limaflucas.KafkaConsumersExamples.adapters.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "${application.kafka.topic}")
public class KafkaEntryPoint {

    @KafkaHandler
    public void readEvent(String event) {
        log.info("Consumed event: {}", event);
    }
}
