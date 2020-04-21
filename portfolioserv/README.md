
# Portfolio Java API App

Server: localhost
port: 8085

While running the jar regarding the WEB APP (runs on 8080 port), the API App runs apart on 8085 port. Sending CRUD requests through the API to the data base will change the data, these changes can be visualized on the web APP in real time.

#Technologies-Used

Spring boot API App <br />
Spring Web <br />
Spring Test JUnit - Integration testing - under the Test Folder <br />
Spring Data JPA <br />
MySQL <br />

#Running the application

Running the jar file or importing the project into Eclipse and running from the IDE 

#Running the application with the .jar file
Packaging as a jar file -> run the jar with the following command (having the command prompt at the folder containing the jar file): java -jar portfolioserv-1.0.jar jar

#Running the application with Eclipse

# Importing the project from Git repository
1. Cloning from GIT <br />
2. Clone the repository <br />
3. Import the project into eclipse as a git project ->File-> Import -> Git ->Projects from GIT and select the folder where the project was clone from GitHub <br />
4. Once the project has been imported, right click -> maven -> Update project <br />
5. Right click on the project root and  -> Run as -> Maven clean <br />
6. Right click on the project root and  -> Run as -> Maven install <br />
7. Right click on the project root and  -> Run as -> Java Application (or Springboot App if Spring tools functionality is installed.) <br />
8. Once the application is running, open a browser explorer and type the following address: http://localhost:8080/faces/portfolios.xhtml <br />

# Importing the project with .RAR file
1. Importing the project having the project .rar file <br />
2. Extract the .rar file <br />
3. Import the project into eclipse as a git project ->File-> Import -> Maven-> Existing Maven Projects and select the folder where the project was extracted from the .rar file <br />
4. Once the project has been imported, right click -> maven -> Update project <br />
5. Right click on the project root and  -> Run as -> Maven clean <br />
6. Right click on the project root and  -> Run as -> Maven install <br />
7. Right click on the project root and  -> Run as -> Java Application (or Springboot App if Spring tools functionality is installed.) <br />
8. Once the application is running, open a browser explorer and type the following address: http://localhost:8080/faces/portfolios.xhtml <br />

# Executing the API
# Postman 
1. Run the API Application <br />
2. Create and execute the following GET services <br />
http://localhost:8085/ws/portfolios <br />
http://localhost:8085/ws/portfolio/555 <br />
http://localhost:8085/ws/createportfolio/3000/Soccer_Player/image/Juan_Cuadrado/@CuadradoOficial <br />
http://localhost:8085/ws/updateportfolioimg/3000/updateIMG <br />
http://localhost:8085/ws/deleteportfolio/3000/ <br />

# From a Command prompt
1. Run the API Application <br />
2. Execute the following CURL commands
curl http://localhost:8085/ws/portfolios <br />
curl http://localhost:8085/ws/portfolio/555 <br />
curl http://localhost:8085/ws/createportfolio/3000/Soccer_Player/image/Juan_Cuadrado/@CuadradoOficial <br />
curl http://localhost:8085/ws/updateportfolioimg/3000/updateIMG <br />
curl http://localhost:8085/ws/deleteportfolio/3000/ <br />
