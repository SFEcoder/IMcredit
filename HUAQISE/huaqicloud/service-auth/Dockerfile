FROM java
ADD target/service-auth.jar /opt/service-auth.jar
EXPOSE 8002
ENTRYPOINT java -Xmx128m -Xms128m -Djava.security.egd=file:/dev/./urandom -Duser.timezone=Asia/Shanghai -Dfile.encoding=UTF-8 -jar /opt/service-auth.jar
