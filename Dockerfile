
FROM ubuntu:20.04
RUN apt-get update --yes && \
    env DEBIAN_FRONTEND=noninteractive apt-get install openjdk-11-jdk mariadb-client --yes --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*

# assumes that the project has already been built
# by cmd: mvn clean package -DskipTests
COPY target/DBIOVerify-*.jar DBIOVerify.jar
COPY target/lib/*.jar /lib/

ENTRYPOINT ["java", "-jar", "DBIOVerify.jar"]