# Microservices with Docker, Spring Boot, Spring Cloud

***

This is a demonstration of an application built with multiple collaborating microservices with service registartion and discovery. The following elements are combined together to produce a simple Product Master Data application.

* Spring Cloud Netflix
* Service Gateway - Zuul
* Service Discovery/Registry - Eureka
* Client Side Load Balancing - Ribbon
* Circuit Breaker - Hystrix
* Java Microservices with Spring Boot

![Microservices Architecture](https://github.com/spkash-co-in/microservices-primer/blob/master/microservices-arch.jpg)

# Running the Demo
Docker containers are used to package the whole environment.
Each service runs in a docker container.
The whole setup is orchestrated using Docker Compose.
To run the code you'll need to have the following installed on your machine.
I've tested the setup on my Windows machine.

* Java SDK 8
* Docker (I'm using version 1.13.1)
* Docker-compose (I'm using version 1.11.1)

The following container names are used for this demo. If you have containers with any of the following names please remove them before proceeding.

* discovery-service 
* gateway-service 
* product-service 
* pricing-service 

# Steps 
## Step 1: 
Create an new empty directory 
## Step 2: 
You can run the demo with just the docker-compose.yml file. 
Download the docker-compose file from this location

`https://github.com/spkash-co-in/microservices-primer/blob/master/docker-compose.yml`

The docker compose file wires up the whole setup.
You can fire it up with the following command.

`docker-compose up`

That's all. Give docker a few minutes to download the required images from dockerhub and to spin up the setup. If you wish to watch for the containers started by docker use the following command. 

`docker ps`

You'll see lots of downloading and logging output in the terminal window as the docker images are downloaded and run.

There are four docker images in total 
* discovery-service
* gateway-service
* product-service
* pricing-service


Once the instances are up and running (this can take some time at first) you can start testing the microservice setup.

## Step 3
Point your browser to look up the microservices registered with Eureka

`http://localhost:9000/`

![Microservices Architecture](https://github.com/spkash-co-in/microservices-primer/blob/master/eureka-snapshot.JPG)

You should see three services registered 
* Gateway Service
* Product Service
* Pricing Service



## Step 4
Now we are ready to test the gateway. Use a REST client like Postman or cURL, I use RESTClient.

### Query the gateway for Products 
### (Route : Gateway Service -> Product Service)
![Query Products](https://github.com/spkash-co-in/microservices-primer/blob/master/query-products.JPG)
A list of available products are returned
![Query Products](https://github.com/spkash-co-in/microservices-primer/blob/master/result-products.JPG)

### Query the gateway for price of a product 
### (Route : Gateway Service -> Pricing Service)
![Query Price](https://github.com/spkash-co-in/microservices-primer/blob/master/query-prices.JPG)
The price of the product is returned
![Query Price](https://github.com/spkash-co-in/microservices-primer/blob/master/result-prices.JPG)


### Query the gateway for prices through products 
### (Route : Gateway Service -> Product Service -> Pricing Service)
![Query Products with Prices](https://github.com/spkash-co-in/microservices-primer/blob/master/query-products-prices.JPG)
Now with this request you can see the Products service has communicated with the Prices service and returned a combined list which has both the products and prices.
![Query Products with Prices](https://github.com/spkash-co-in/microservices-primer/blob/master/result-products-prices.JPG)

## Step 5

Now download the cleanup script from this location

`https://github.com/spkash-co-in/microservices-primer/blob/master/docker-purge.bat`

Finally bring down the setup with this command. (Note: If you are working on a non-windows machine make the required script with the contents of docker-purge.bat)


`docker-purge`


 
