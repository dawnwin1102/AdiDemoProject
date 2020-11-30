# Purpose
This is a demo project for the follow requirement:
We want to create a service that given an origin city will return a list of itineraries , one based in the less number of
connections and the second based in the less time
# System Design
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
2. Use mvn build whole project.
3. Start each service.
4. Go to Eureka endpoint:http://localhost:8761/ and all service registered in eureka will displayed as below:
![image.png](https://leowebsite.blob.core.windows.net/images/eureka.png)
5.There is 2 way to access route portal
1)Via apigateway:/apigateway/8060(Author)
2)Type the url of route portal:http://localhost:8081/
(Api Gateway's AuthorizeFilter is set to off for easily test via route portal. If open it the login service need to start and get JWT token then attach it in request head)
5. Just select Orginal City and Destiny City then submit in portal, result will show below:
![image.png](https://leowebsite.blob.core.windows.net/images/routeportal.png)

