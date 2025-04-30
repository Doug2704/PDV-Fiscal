@echo off
REM Script para abrir terminal com Maven pronto para rodar o PDV Fiscal Web
cd /d "%~dp0"

REM Altere o caminho abaixo para a pasta bin do Maven se necessário
set MAVEN_HOME=C:\maven
set PATH=%MAVEN_HOME%\bin;%PATH%

REM Inicia o Spring Boot
mvn spring-boot:run

pause
