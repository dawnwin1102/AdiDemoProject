# Purpose
This is a demo project for the follow requirement:
We want to create a service that given an origin city will return a list of itineraries , one based in the less number of
connections and the second based in the less time
## Core service:
- Route Query Service
This is the service which provide itineraries calculator function.
- Route Portal
This is the UI for user to select route
## None Functional Service
We will use Spring Cloud to implement microservice architecture.
For this purpose we will use services list below:
- Discovery Server(Eureka)
- Api Gateway Server(Spring Cloud Gateway)
- Login Server(Simple demo for issuing JWT token for API Gateway auth)

# System Diagram
![DemoDiagram.jpg](https://leowebsite.blob.core.windows.net/images/DemoDiagram.jpg)

# RouteService
- For demo project we use sqlite as our db to store route info.
- Integrate with swagger-ui.
- As our calculator service it export 4 apis:
1. getAllRoute: this api will provide all route in db.
2. getShortestPath: this api will return itineraries of less time.
3. getLeastTransitRoute : this api will return itineraries of less connections.
4. getItineraries: this api will integrate itineraries of less time and 
itineraries of less connections result then return.
# RoutePortal
- This is a simple website for user to select origin city and  destiny city then show the result.
- Use feign client to communicate with Route Service
# DiscoveryServer
- This is an eureka server as our registry center
# Gateway-Springcloud
- This is Api gateway server
# Login Server
-This Server just set up for a simple way to grant a JWT token and use it to auth with Api gateway

# Run locally
1. Clone the project from git hub.
2. Use mvn build each project.
3. Start 3 core service: discoveryserver,routeservice,routeportal(this is a microservice implemention so wen run more than one instance of each service, discoveryserver and robin will handle the load balance for us)
4. Go to Eureka endpoint:http://localhost:8761/ and all service registered in eureka will displayed as below:
![image.png](https://leowebsite.blob.core.windows.net/images/eureka.png)
5.There is 2 way to access route portal
1)Via apigateway:/apigateway/8060(Author)
2)Type the url of route portal:http://localhost:8081/
(Api Gateway's AuthorizeFilter is set to off for easily test via route portal. If open it the login service need to start and get JWT token then attach it in request head)
6. Just select Orginal City and Destiny City then submit in portal, result will show below:
![image.png](https://leowebsite.blob.core.windows.net/images/routeportal.png)
7. Start gateway-springcloud service will provide the api gateway ability，and with login-server can auth request to apis
# TODO
This is just a simple demo for microservice implemention, for future development we should add features list as below:
- Add Spring Cloud Config to provides server-side and client-side support for externalized configuration in a distributed system.
- Add Redis to reduce request times to DB.
- Setup ELK system to store and anaylize logs 
- Setup Zipkin server and Spring Cloud Sleuth for Monitoring Microservices
- Setup a Oauth server as a center author service to author our apis
- Create docke files to build docker image and run in docker

