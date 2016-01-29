# embedded_jetty

The project provides a prototype to return dynamic content from an application server without the overhead of having to install additional software. This will be used as a starting point to further quickly develop web application prototypes.

There are also the rudiments of a standalone app to generate an HTTP Post that I need to flesh out.

####Advantages

* No installation of webserver 
* Bundling of application with tools for testing
      

## Requirements

* maven

## Instructions

Clone this git repository

	git clone git@github.com:username/embedded_jetty.git

Execute the maven pom

	cd embedded_jetty
	mvn jetty:run

Call the engine from the browser

	http://localhost:8080/

## Enhancing

This project will probably serve as a basis for other code. The best way to do this is to move it away from its original source and work with it.

