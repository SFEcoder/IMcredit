FROM java
ADD target/eurake-server.jar /opt/eurake-server.jar
EXPOSE 8761
ENTRYPOINT java -Xmx128m -Xms128m -Djava.security.egd=file:/dev/./urandom -Duser.timezone=Asia/Shanghai -Dfile.encoding=UTF-8 -jar /opt/eurake-server.jar
