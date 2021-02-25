FROM java
ADD target/zuul-gateway.jar /opt/zuul-gateway.jar
EXPOSE 8040
ENTRYPOINT java -Xmx128m -Xms128m -Djava.security.egd=file:/dev/./urandom -Duser.timezone=Asia/Shanghai -Dfile.encoding=UTF-8 -jar /opt/zuul-gateway.jar
