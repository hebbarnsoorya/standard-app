@echo off
SET JAR_NAME=std-app.jar

REM External config files
SET EXT_CONFIG_1=external-application.properties
SET EXT_CONFIG_2=external-application.yaml
SET EXT_CONFIG_3=external-live-run.properties

REM Check JAR
IF NOT EXIST %JAR_NAME% (
    echo ERROR: %JAR_NAME% not found!
    pause
    exit /b
)

REM Build config location string
SET ADDITIONAL_CONFIG=

IF EXIST %EXT_CONFIG_1% (
    echo Found: %EXT_CONFIG_1%
    SET ADDITIONAL_CONFIG=%ADDITIONAL_CONFIG%,file:./%EXT_CONFIG_1%
)

IF EXIST %EXT_CONFIG_2% (
    echo Found: %EXT_CONFIG_2%
    SET ADDITIONAL_CONFIG=%ADDITIONAL_CONFIG%,file:./%EXT_CONFIG_2%
)

IF EXIST %EXT_CONFIG_3% (
    echo Found: %EXT_CONFIG_3%
    SET ADDITIONAL_CONFIG=%ADDITIONAL_CONFIG%,file:./%EXT_CONFIG_3%
)

REM Remove leading comma if needed
IF NOT "%ADDITIONAL_CONFIG%"=="" (
    SET "ADDITIONAL_CONFIG=%ADDITIONAL_CONFIG:~1%"
    SET "CONFIG_PARAM=--spring.config.additional-location=%ADDITIONAL_CONFIG%"
) ELSE (
    SET "CONFIG_PARAM="
)

echo Starting %JAR_NAME% with external config...
java -jar %JAR_NAME% %CONFIG_PARAM%

pause
