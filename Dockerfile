FROM FROM tomcat

COPY target/com.customer-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
