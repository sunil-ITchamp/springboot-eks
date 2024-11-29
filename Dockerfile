FROM openjdk:17
ADD build/libs/springboot-eks-0.0.1-SNAPSHOT.jar springboot-eks.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot-eks.jar"]