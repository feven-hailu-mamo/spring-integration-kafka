# spring-integration-kafka
spring boot integration with apache kafka
- Start zookeeper: D:\Apache-Kafka\kafka_2.12-2.5.0\bin\windows>zookeeper-server-start.bat D:\Apache-Kafka\kafka_2.12-2.5.0\config\zookeeper.properties
- Start apache kafka:D:\Apache-Kafka\kafka_2.12-2.5.0\bin\windows>kafka-server-start.bat D:\Apache-Kafka\kafka_2.12-2.5.0\config\server.properties
- Create topic: D:\Apache-Kafka\kafka_2.12-2.5.0\bin\windows>kafka-topics.bat--create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic topicName
- List all available topics: D:\Apache-Kafka\kafka_2.12-2.5.0\bin\windows>kafka-topics.bat --list --zookeeper localhost:2181
- 
