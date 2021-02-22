import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaTest2 {
    public static void main(String[] args) {
        String topic = "test-topic";// topic name

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");//用于建立与 kafka 集群连接的 host/port 组。
        props.put("group.id", "testGroup2");// Consumer Group Name
        props.put("auto.commit.interval.ms", "1000");// 自动提交 offset 到 zookeeper 的时间间隔，时间是毫秒
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        Consumer<String, String> consumer = new KafkaConsumer(props);
        consumer.subscribe(Arrays.asList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("partition = %d, offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
        }

    }
}
