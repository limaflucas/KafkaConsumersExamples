package br.com.limaflucas.KafkaConsumersExamples.adapters.web.models;

import lombok.Data;

@Data
public class RegularMessage {

    private String topic;
    private String message;
}
