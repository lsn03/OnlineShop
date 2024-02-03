FROM openjdk:17-jdk-alpine
LABEL authors="sergey"
COPY target/SpringSecurityOfficial-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
EXPOSE 8080 5005

# Run the JAR file
ENTRYPOINT ["java","-jar","/app.jar"]