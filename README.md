# demo-spring-int

A demonstration of how to use Spring Integration. 

# Usage

1. Install [Apache ActiveMQ](http://activemq.apache.org/). If you have Homebrew installed on macOS, you can go `brew install activemq` to install it.
    1. I was using version 5.14.5 of ActiveMQ when I wrote this.
2. Start ActiveMQ. On macOS Sierra, just go `activemq start`.
3. Browse to the [ActiveMQ Console](http://localhost:8161/admin). Username and password are admin/admin.
4. Create a Queue named VisitQueue.
5. Cd into the root of this project.
6. Publish 10 messages to VisitQueue, pausing for one second between each:
    1. ``activemq producer --destination queue://VisitQueue --messageCount 10 --sleep 1000 --payloadUrl file:///`pwd`/visit.json``.
7. Build and run demo-spring-int:
    1. `./gradlew build`.
    2. `java -jar build/libs/demo-spring-int-0.0.1-SNAPSHOT.jar`.
8. Watch the two files in  /tmp/si/ as demo-spring-int writes to them. 