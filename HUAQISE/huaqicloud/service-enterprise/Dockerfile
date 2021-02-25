FROM java
ADD target/service-enterprise.jar /opt/service-enterprise.jar
EXPOSE 8001
ENTRYPOINT java -Xmx128m -Xms128m -Djava.security.egd=file:/dev/./urandom -Duser.timezone=Asia/Shanghai -Dfile.encoding=UTF-8 -jar /opt/service-enterprise.jar
