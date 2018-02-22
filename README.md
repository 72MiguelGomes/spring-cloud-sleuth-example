###SpringCloudSleuth Example

This project is an example of SpringCloudSleuth (https://github.com/spring-cloud/spring-cloud-sleuth).

####Example

Log:
````
2018-02-22 07:51:52.592  INFO [sleuthExample,1c9e98fcb8680659,1c9e98fcb8680659,false] 21972 --- [nio-8080-exec-1] com.sleuth.example.controllers.Welcome   : create welcome message
````

Http response:

```curl
curl http://localhost:8080/welcome?name=miguel -v
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /welcome?name=miguel HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.54.0
> Accept: */*
>
< HTTP/1.1 200
< X-B3-TraceId: 1c9e98fcb8680659
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 14
< Date: Thu, 22 Feb 2018 07:51:52 GMT
<
* Connection #0 to host localhost left intact
```

``X-B3-TraceId:`` Provides the traceId to help debugging

####Hot to Run

Install:
```
mvn clean install
```

Run:
```
mvn spring-boot:run
```

