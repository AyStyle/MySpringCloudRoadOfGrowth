FROM openjdk:11

ENV WORKDIR=/application/java

WORKDIR ${WORKDIR}

COPY ./target/user-server-0.0.1-SNAPSHOT.jar ${WORKDIR}

ENTRYPOINT ["java" , "-jar" , "user-server-0.0.1-SNAPSHOT.jar"]
