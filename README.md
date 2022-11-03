# DBIOVerify
check if db read/write is valid


# Getting Started

Requirements:
* Java 11 or above
* Maven (sudo apt install maven on Ubuntu)
* The DBMS that you want to test


The following commands create a JAR, and start to test

```shell
mvn clean package -DskipTests
cd target
java -jar DBIOVerify-*.jar
```

