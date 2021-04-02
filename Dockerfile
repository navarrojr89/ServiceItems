FROM openjdk:11
VOLUME /tmp
ADD ./target/service-items-1.0.0-SNAPSHOT.jar service-items.jar
ENTRYPOINT ["java", "-jar", "/service-items.jar"]