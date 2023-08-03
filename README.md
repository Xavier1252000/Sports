# Sports
RESTful api development using the spring boot and hibernate

all the apis are created as per the given urls.
1.   localhost:8080/add-sports
2.   localhost:8080/get-sports
3.   localhost:8080/create-team
4.   localhost:8080/get-team?city=bhopal
5.   localhost:8080/get-teams

/add-sports
a. Should accept sports data like name,isTeamGame, minPlayer , maxPlayer
b. All the sports data should be saved to mysql database
c. Create database or tables in your own local machine
2. /get-sports
a. Should return all the sports saved in first endpoint
b. All the users must returned from the database
3. /create-team
a. Should accept team details like: teamName,city, noOfPlayingPlayers, and
sportsId.
b. Implement proper association (foreign) key between team and user table
c. Team records should get stored in the team table along with sportId.
4. /get-teams
a. Should return all the teams record along with sports name (Note: in place of
sportsId , sportsName should be displayed)

5. /get-team?city=Bhopal
a. Should return all the teams recond having city bhopal and must return the
same details as return in 4 point
