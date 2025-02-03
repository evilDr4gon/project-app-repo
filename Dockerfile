# prueba a mi amigo
FROM vegardit/graalvm-maven:latest-java21 AS graalvm

COPY . /app
WORKDIR /app

RUN mvn package -Dnative

FROM registry.fedoraproject.org/fedora-minimal

WORKDIR /app

COPY --from=graalvm /app/target/*-runner /app/application
RUN chmod 770 /app

EXPOSE 8080
ENTRYPOINT ["./application", "-Dquarkus.http.host=0.0.0.0"]

