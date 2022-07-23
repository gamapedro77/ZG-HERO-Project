package ms.vagas

import ms.vagas.Vaga
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.clients.producer.ProducerRecord

import javax.inject.Singleton


class KafkaSender {

    private static producer = new KafkaProducer<String, String>(properties());

    private static Properties properties() {
        def properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }

    private static sendRecord(Vaga vaga) {
        ProducerRecord<String, String> record = new ProducerRecord<>("vagas", vaga.toString())
        producer.send(record)
    }
}
