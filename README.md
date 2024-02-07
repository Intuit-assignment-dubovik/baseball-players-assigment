## Running instructions
1. Download ZIP from GitHub
2. Unzip
3. Enter the folder with project
4. Run command `mnv package`. All Unit Tests should be performed and as a result there will be created JAR file baseball-0.0.1.jar
5. Run command `java -jar target/baseball-0.0.1.jar --spring.profiles.active=h2`. As a result the application will start on the port 8080
6. By using Postman or any other Restful client integration test can be performed according to the API
   - GET /api/players - returns the list of all players.
   - GET /api/players/{playerID} - returns a single player by ID.
7. To run application in Docker container with PostgreSQL `docker-compose up` command should be used.