Talk Me :: Sample WebSocket API Usage Sample in JEE 7
=====================================================

Basic JEE 7 WebSocket sample.

Pre requisite
-------------

In order to run this project, you'll need :

- Java SDK 7 minimum
- Apache Maven 3 minimum

Note: This sample should run on any application server implementing the Java API for WebSocket 1.0 (JSR 356).
It was build with Apache Tomcat 8.0.0.RC5 but runs on Apache Tomcat 7.0.47.

How to Build ?
--------------

Run the following command :

    $> mvn install

How to Run ?
------------

Run the following command :

    $> mvn tomcat7:run

Browse the following URL : http://localhost:8080/

Enjoy!

TODO
----

- As a user, when I join I can show all the previously joined users.
- A more pretty UI (Bootstrap ? Angular JS ?)
