FROM openjdk
EXPOSE 8080
ADD /target/Favourite.jar /Favourite.jar
ENTRYPOINT ["java","-jar","Favourite.jar"]