# Usando JRE 21 do Eclipse Temurin (mais leve que JDK)
FROM eclipse-temurin:21-jre

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiando o JAR compilado para o container
COPY ./target/delivery-ms-user-0.0.1-SNAPSHOT.jar .

# Comando para executar o JAR
CMD ["java", "-jar", "delivery-ms-user-0.0.1-SNAPSHOT.jar"]
