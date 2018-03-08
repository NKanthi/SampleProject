#Baseimg
FROM openjdk:7

#dirs and stuff
WORKDIR /app
ADD ./src/dockerDemo /app

#compiles java code
RUN javac Main.java
CMD ["java", "Main"]
