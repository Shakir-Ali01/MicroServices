#start with a base image containing java runtime
From openjdk:17-jdk-slim

#information around who maintains the image
LABEL maintainer="MsBoss.com"

#Add the Application's jar to the image
Copy target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/accounts-0.0.1-SNAPSHOT.jar"]

