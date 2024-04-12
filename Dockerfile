FROM openjdk:23-slim
COPY target/hyremap-company-ms-0.0.1-SNAPSHOT.jar hyremap-company-ms-0.0.1.jar
ENTRYPOINT ["java","-jar","/hyremap-company-ms-0.0.1.jar"]
