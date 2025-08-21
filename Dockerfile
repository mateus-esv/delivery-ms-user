# Usando JRE 21 do Eclipse Temurin (mais leve que JDK)
FROM eclipse-temurin:21-jre

# Diretório de trabalho dentro do container
WORKDIR /ms_user

# Copiando o JAR compilado para o container
COPY ./ms_user/target/ms_usuario.jar .

# Comando para executar o JAR
CMD ["java", "-jar", "ms_usuario.jar"]
