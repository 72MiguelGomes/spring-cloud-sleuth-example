### SpringCloudSleuth Example

This project is an example of SpringCloudSleuth (https://github.com/spring-cloud/spring-cloud-sleuth).

#### Example

Log:
````
2018-02-23 07:28:09.710 DEBUG [sleuthExample,fd305bdff9f1f761,fd305bdff9f1f761,false] 30010 --- [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : DispatcherServlet with name 'dispatcherServlet' processing GET request for [/welcome]
2018-02-23 07:28:09.710 DEBUG [sleuthExample,fd305bdff9f1f761,fd305bdff9f1f761,false] 30010 --- [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Last-Modified value for [/welcome] is: -1
2018-02-23 07:28:09.711  INFO [sleuthExample,fd305bdff9f1f761,fd305bdff9f1f761,false] 30010 --- [nio-8080-exec-3] com.sleuth.example.controllers.Welcome   : create welcome message
2018-02-23 07:28:09.712 DEBUG [sleuthExample,fd305bdff9f1f761,fd305bdff9f1f761,false] 30010 --- [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Null ModelAndView returned to DispatcherServlet with name 'dispatcherServlet': assuming HandlerAdapter completed request handling
2018-02-23 07:28:09.712 DEBUG [sleuthExample,fd305bdff9f1f761,fd305bdff9f1f761,false] 30010 --- [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Successfully completed request
````

Http response:

```curl
curl http://localhost:8080/welcome?name=miguel -v
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /welcome?name=miguel HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.54.01
> Accept: */*
>
< HTTP/1.1 200
< X-B3-TraceId: fd305bdff9f1f761
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 14
< Date: Thu, 22 Feb 2018 07:51:52 GMT
<
* Connection #0 to host localhost left intact
```

``X-B3-TraceId:`` Provides the traceId to help debugging

#### How to Run

Install:
```
mvn clean install
```

Run:
```
mvn spring-boot:run
```

