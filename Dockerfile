FROM clojure:openjdk-11-lein as build
WORKDIR /app
COPY project.clj /app/
RUN lein deps
COPY . /app
RUN lein uberjar

FROM openjdk:11-jre-slim
COPY --from=build /app/target/uberjar/clojure-k8s-demo-0.1.0-SNAPSHOT-standalone.jar /app/app.jar
EXPOSE 3000
CMD ["java", "-jar", "/app/app.jar"]
