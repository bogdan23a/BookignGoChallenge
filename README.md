# BookingGoChallenge

I did my project in eclipse using a json library and can also be run from the terminal as described below:


# Download the project

git clone https://github.com/bogdan23a/BookignGoChallenge.git


# PART 1

Compile: 

cd src/

javac -cp ../json-20180813.jar Part1.java

Run:

cd bin/

java -cp .:../json-20180813.jar Part1 {dave/cheapeast} {pickup latitude} {pickup longitude} {dropoff latitude} {dropoff longitude} {the number of passangers}


The first argument {dave/cheapest} decides if the program will search only for the Dave car rides or if it will find the cheapest of the 3 suppliers.


The program will check each supplier in turn and if there is an error from one of the it will return the string "Connection error!" and continue to search for rides from other suppliers, finnaly returning cheapest rides from available sources.
