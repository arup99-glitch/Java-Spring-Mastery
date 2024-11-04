package arup.practice.spring_mastery.logging;

public class LoginDocumentation {
    public static final String HOW_TO_RUN_LOGGING_SET_UP = """
            For using log4j2, we need to exclude Logback from our starter dependency and add the dependency for log4j2 as follows:
            
            
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
                <exclusions>
                    <exclusion>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-starter-logging</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-log4j2</artifactId>
            </dependency>
            
            
            Next, we need to define the configuration file for Log4j2. When spring boot finds a file with any of the following names, It automatically overrides it over default configuration.
            
            log4j2-spring.xml
            log4j2.xml
            Now let’s create a simple log4j2-spring.xml file as follows:
            
            
            
            <?xml version="1.0" encoding="UTF-8"?>
            
            <Configuration>
            
                <!-- Setting up log path and log file name -->
                <Properties>\s
                <property name="LOG_PATH" value="./logs" />
                <property name="LOG_FILE_NAME" value="application-log4j2" />
                </Properties>
               \s
                <!-- Setting up logging pattern for console logging -->
                <Appenders>
                    <Console name="ConsoleOutput" target="SYSTEM_OUT">
                        <PatternLayout
                            pattern="%style{%d{ISO8601}}{white} %highlight{%-5level} [%style{%t}{bright,yellow}] : %msg%n%throwable"
                            disableAnsi="false" />
                    </Console>
            
                    <!-- Setting the filename and logging pattern for log file. Also setting\s
                         up a rolling policy with rolling done daily and when file size is 10MB -->
                    <RollingFile name="LogFile"
                        fileName="${LOG_PATH}/${LOG_FILE_NAME}.log"
                        filePattern="${LOG_PATH}/$${date:yyyy-MM}/application-log4j2-%d{dd-MMMM-yyyy}-%i.log.gz">
                        <PatternLayout>
                            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level : %msg%n
                            </pattern>
                        </PatternLayout>
                        <Policies>
                            <OnStartupTriggeringPolicy />
                            <SizeBasedTriggeringPolicy size="10 MB" />
                            <TimeBasedTriggeringPolicy />
                        </Policies>
                    </RollingFile>
                </Appenders>
            
                <Loggers>
                 \s
                    <!-- Logging at INFO level -->
                    <Root level="info">
                        <AppenderRef ref="ConsoleOutput" />
                        <AppenderRef ref="LogFile" />
                    </Root>
            
                    <!-- Logging at TRACE level -->
                    <logger name="com.log" level="trace" additivity="false">
                        <appender-ref ref="LogFile" />
                        <appender-ref ref="ConsoleOutput" />
                    </logger>
            
                </Loggers>
            
            </Configuration>
            
            
            On running the application, and visiting the page http://localhost:8080/log , we receive the following console output:
            """;
}
