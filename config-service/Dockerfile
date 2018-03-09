FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/config-service-0.0.1-SNAPSHOT.jar app.jar
# https://blog.csanchez.org/2017/05/31/running-a-jvm-in-a-container-without-getting-killed/
ENV JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -XshowSettings:vm"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]