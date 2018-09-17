set DEVSPACE_DIR=D:\devspace\repository
SET JAVA_HOME=D:\Java\JDK_v1.8.0_101\


"%JAVA_HOME%\bin\java" -Dspring.profiles.active=dev -jar %DEVSPACE_DIR%\com\metroservice\metro-ui-service\0.0.1-SNAPSHOT\metro-ui-service-0.0.1-SNAPSHOT-spring-boot.jar
