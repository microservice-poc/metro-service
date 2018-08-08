set DEVSPACE_DIR=D:\devspace\repository
SET JAVA_HOME=D:\Java\JDK_v1.8.0_101\


"%JAVA_HOME%/bin/java" -jar %DEVSPACE_DIR%\com\metroservice\metro-route-service\0.0.1-SNAPSHOT\metro-route-service-0.0.1-SNAPSHOT-spring-boot.jar

@echo off
rem "%JAVA_HOME%/bin/java" -Dserver.port=8101 -jar %DEVSPACE_DIR%\com\metroservice\metro-route-service\0.0.1-SNAPSHOT\metro-route-service-0.0.1-SNAPSHOT-spring-boot.jar

rem "%JAVA_HOME%/bin/java" -Dserver.port=8102 -jar %DEVSPACE_DIR%\com\metroservice\metro-route-service\0.0.1-SNAPSHOT\metro-route-service-0.0.1-SNAPSHOT-spring-boot.jar
