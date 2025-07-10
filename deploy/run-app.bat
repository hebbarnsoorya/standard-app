@echo off
SETLOCAL ENABLEDELAYEDEXPANSION

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

REM Build spring.config.import string
SET CONFIG_IMPORTS=

IF EXIST %EXT_CONFIG_1% (
    echo Found: %EXT_CONFIG_1%
    SET CONFIG_IMPORTS=!CONFIG_IMPORTS!,optional:file:./%EXT_CONFIG_1%
)

IF EXIST %EXT_CONFIG_2% (
    echo Found: %EXT_CONFIG_2%
    SET CONFIG_IMPORTS=!CONFIG_IMPORTS!,optional:file:./%EXT_CONFIG_2%
)

IF EXIST %EXT_CONFIG_3% (
    echo Found: %EXT_CONFIG_3%
    SET CONFIG_IMPORTS=!CONFIG_IMPORTS!,optional:file:./%EXT_CONFIG_3%
)

REM Remove leading comma
IF NOT "!CONFIG_IMPORTS!"=="" (
    SET "CONFIG_IMPORTS=!CONFIG_IMPORTS:~1!"
)

REM Run the app
echo Starting %JAR_NAME% with config import: !CONFIG_IMPORTS!
java -Dspring.config.import=!CONFIG_IMPORTS! -jar %JAR_NAME%

pause
