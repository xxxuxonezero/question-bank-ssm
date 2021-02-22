import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class KafkaTest {
    public static void main(String[] args) {
        Map<String, Object> props = new HashMap<String, Object>();
        new Properties();
        props.put("zk.connect", "127.0.0.1:2181");//zookeeper 的地址
        props.put("bootstrap.servers", "localhost:9092");//用于建立与 kafka 集群连接的 host/port 组。
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        String topic = "test-topic";
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message 1"));
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message 2"));
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message 3"));

        producer.close();
    }
}
