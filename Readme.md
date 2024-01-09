## Build a project using gradle 


### gradle commands 

- ./gradlew build -> to build the jar file
- ./gradlew run -> runs all the files
- ./gradlew clean -> cleans the target dir

Gradle jar is generated in 'build\lib' dir

- java -jar 'jar-path' -> runs the jar file

### Note about fat jar

A fat jar is jar file that includes all required libraries inside it.
far jars are easy to distribute & deploy as they don't require anything other then
Java runtime env(JRE) to run.

### Adding external dependency to gradle & jar file
```
dependecies{
implementation("com.squareup.okhttp3:okhttp:4.12.0") 
}

tasks.withType<Jar>{
from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}
```

### Assignment-01
Problem statement:
Given 2 files, each of the files has a bunch of numbers in them arranged 
randomly.
You are tasked to sorted them up & store the result in a separate file
which is sorted.


### Running individual method as modules
```
 java -jar 'path-to-jar' [obj-name]
 ex: java -jar .\build\libs\Java-Project-Scaler-1.0-SNAPSHOT.jar file
```
 - file is an object name.

### Transfer of data
- Serialization
    - Converting Java Objects to JSON which can be processed by API calls
- Deserialization
  - And converting JSON response API calls back to Java Objects






