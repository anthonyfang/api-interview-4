# API tests coding challenge

1) Download this file: https://my.pcloud.com/publink/show?code=XZCte67ZLGAaFgfyl0XXqzarhktJeX1dx4fV
or here: https://pan.baidu.com/s/1T-xLdBcZWEfm9SoiENuM-w  passcode: ureg
This is a jar file jar with API application.

2) edit .m2/settings.xml and add
```xml
  <mirrors>
    <mirror>
      <id>alimaven</id>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>
    </mirror>
  </mirrors>
```
3) To run the jar you need to type (copy-paste might cause an error “Error: Could not find or load main class ?jar”) following command:<br/>
java –jar spring-boot-web-0.0.1-SNAPSHOT.jar

4) Here you can find complete description of API (Swagger) that you should use:
http://localhost:8080/swagger-ui.html#/product45controller
