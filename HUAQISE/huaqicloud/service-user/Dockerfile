FROM java
ADD target/service-user.jar /opt/service-user.jar
EXPOSE 8000
ENTRYPOINT java -Xmx128m -Xms128m -Djava.security.egd=file:/dev/./urandom -Duser.timezone=Asia/Shanghai -Dfile.encoding=UTF-8 -jar /opt/service-user.jar
