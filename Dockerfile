# DOCKERFILE PARA CRIAR UMA IMAGEM DA API.
Get-Command java | Select-Object -ExpandProperty Source# Configuração do Docker para facilitar implantação e o gerenciamento em qualquer ambiente de nuvem que suporte containers.

# Imagem base para a construção da aplicação utlizando o temurin com o maven.
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Criação do diretório da aplicação.
RUN mkdir /opt/app

# Copia o conteúdo do diretório atual para o diretório da aplicação.
COPY . /opt/app

# Define o diretório de trabalho.
WORKDIR /opt/app

# Executa o comando para limpar e construir a aplicação.
RUN mvn clean package

# Imagem base para a execução da aplicação utlizando o temurin com o alpine.
FROM eclipse-temurin:21-jre-alpine

# Criação do diretório da aplicação.
RUN mkdir /opt/app

# Copia o arquivo jar gerado na imagem anterior para o diretório da aplicação.
COPY --from=build  /opt/app/target/app.jar /opt/app/app.jar

# Define o diretório de trabalho.
WORKDIR /opt/app

# Define a variável de ambiente para o perfil de execução da aplicação (dev, tst, prd).
ENV PROFILE=prd

# Expõe a porta 8080 para acesso a aplicação.
EXPOSE 8080

# Comando de execução da aplicação que concatena a variável de ambiente com o perfil de execução da aplicação.
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]