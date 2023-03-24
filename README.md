## N11 Web Test Automation 

Visit https://www.n11.com page. Go to the Login page and write Login related manual test cases (functional, Ui, security etc.). Only Login cases are required, no need to cover Sing up cases.

## Success and Failure Login Scenarios

1. [x] **TestCase:1 --> Success Login Scenario**
2. [x] **TestCase:2 --> Empty E-Mail and Empty Password**
3. [x] **TestCase:3 --> Empty E-Mail and Password**
4. [x] **TestCase:4 --> E-Mail and Empty Password**
5. [x] **TestCase:5 --> E-Mail and Invalid Password**
6. [x] **TestCase:6 --> Password Character Count Invalid**


    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <log4j.version>1.7.30</log4j.version>
    </properties> 
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.17.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.17.1</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${log4j.version}</version>
        </dependency>
    </dependencies>

    <build>
        <testResources>
            <testResource>
                <directory>/src/test/resources</directory>
            </testResource>
        </testResources>
        <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
            <plugins>
                <plugin>
                    <!-- https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin -->
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.9.0</version>
                    <configuration>
                        <source>${maven.compiler.source}</source>
                        <target>${maven.compiler.target}</target>
                        <compilerVersion>${maven.compiler.source}</compilerVersion>
                    </configuration>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>