#Jumia Task
 
Tested with
* Java 11
* Spring Boot 2.4.0.RELEASE
* Maven
  
## How to run this?
```bash
$ git clone https://github.com/nelalfy/JumiaTask.git
$ cd com.customer
$ mvn clean package

access Welcome page http://localhost:8081/hello
access All customers page http://localhost:8081/customers/getCustomers
access Filter by country code page http://localhost:8081/customers/Countryfilter

//dockerize

// create a docker image
$ sudo docker build -t spring-boot:1.0 .
// run it
$ sudo docker run -d -p 8080:8080 -t spring-boot:1.0

access Welcome page http://localhost:8081/hello
access All customers page http://localhost:8081/customers/getCustomers
access Filter by country code page http://localhost:8081/customers/Countryfilter
