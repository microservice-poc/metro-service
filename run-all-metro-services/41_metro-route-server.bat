set DEVSPACE_DIR=D:\devspace\repository
SET JAVA_HOME=D:\Java\JDK_v1.8.0_101\

start  cmd /c "%JAVA_HOME%/bin/java" -Dspring.profiles.active=uat -jar %DEVSPACE_DIR%\com\metroservice\metro-route-service\0.0.1-SNAPSHOT\metro-route-service-0.0.1-SNAPSHOT-spring-boot.jar
