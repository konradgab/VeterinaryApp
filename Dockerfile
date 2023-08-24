# Używamy gotowego obrazu Javy 11
FROM openjdk:11-jre-slim

# Tworzymy katalog w kontenerze
WORKDIR /app

# Kopiujemy plik JAR aplikacji do kontenera
COPY build/libs/veterinaryapp-0.0.1-SNAPSHOT.jar /app/veterinaryapp-0.0.1-SNAPSHOT.jar

# Definiujemy punkt wejścia dla kontenera
ENTRYPOINT ["java", "-jar", "/app/veterinaryapp-0.0.1-SNAPSHOT.jar"]
