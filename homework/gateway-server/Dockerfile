FROM openjdk:11

ENV WORKDIR=/application/java

WORKDIR ${WORKDIR}

COPY ./target/gateway-server-0.0.1-SNAPSHOT.jar ${WORKDIR}

ENTRYPOINT ["java","-jar","gateway-server-0.0.1-SNAPSHOT.jar"]