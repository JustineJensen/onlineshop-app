# Use Maven to build the project
FROM maven:3-openjdk-17 AS maven
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use OpenJDK 17 for runtime
FROM openjdk:17 AS runtime
WORKDIR /app
ENV PORT=8080
ENV SPRING_PROFILE=production

# Specify the JAR file correctly. The JAR file is created in the target folder by default.
ARG JAR_FILE=target/storeproject-0.0.1-SNAPSHOT.jar

# Copy the JAR from the Maven build stage to the runtime container
COPY --from=maven /app/${JAR_FILE} /app/app.jar

# Run the jar file with Spring profiles and server port
ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "-Dspring.profiles.active=${SPRING_PROFILE}", "app.jar"]
