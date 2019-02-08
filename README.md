# Conference Management

You are planning a code campaigning conference and have received many entries for presentations which have passed the entry criteria but you're having trouble slotting them into the time constraints of the day -- there are so many possibilities! So, you write a program to do it for you.

- The conference has multiple tracks each of which has a morning and afternoon session.
- Each session contains multiple talks.
- First sessions begin at 9am and must finish by 12 noon, for lunch.
- Second sessions begin at 1pm and must finish in time for the networking event.
- The networking event can start no earlier than 4:00 and no later than 5:00.
- No presentation topic has numbers in it.
- All talk lengths are either in minutes (not hours) or lightning (5 minutes).
- Presenters will be very punctual; there needs to be no gap between sessions.

Note that depending on how you choose to complete this problem, your solution may give a different ordering or combination of talks into tracks. This is acceptable; you don’t need to exactly duplicate the sample output given here.
 
## TestScheduleConference input:

        Writing Fast Tests Against Enterprise Rails - 60min
        Overdoing it in Python - 45min
        Lua for the Masses - 30min
        Ruby Errors from Mismatched Gem Versions - 45min
        Common Ruby Errors - 45min
        Rails for Python Developers - lightning
        Communicating Over Distance - 60min
        Accounting-Driven Development 45min
        Woah 30min
        Sit Down and Write - 30min
        Pair Programming vs Noise - 45min
        Rails Magic - 60min
        Ruby on Rails: Why We Should Move On - 60min
        Clojure Ate Scala (on my project) - 45min
        Programming in the Boondocks of Seattle - 30min
        Ruby vs. Clojure for Back-End Development - 30min
        Ruby on Rails Legacy App Maintenance - 60min
        A World Without HackerNews - 30min
        User Interface CSS in Rails Apps - 30min


## Output Generated from attached code:

    Track 1:
    09:00AM Writing Fast Tests Against Enterprise Rails - 60min
    10:00AM Overdoing it in Python - 45min
    10:45AM Lua for the Masses - 30min
    11:15AM Ruby Errors from Mismatched Gem Versions - 45min
    12:00PM Lunch
    01:00PM Common Ruby Errors - 45min
    01:45PM Rails for Python Developers - lightning
    01:50PM Communicating Over Distance - 60min
    02:50PM Accounting-Driven Development 45min
    03:35PM Woah 30min
    04:05PM Sit Down and Write - 30min
    05:00PM Networking Event
    
    Track 2:
    09:00AM Pair Programming vs Noise - 45min
    09:45AM Rails Magic - 60min
    10:45AM Ruby on Rails: Why We Should Move On - 60min
    12:00PM Lunch
    01:00PM Clojure Ate Scala (on my project) - 45min
    01:45PM Programming in the Boondocks of Seattle - 30min
    02:15PM Ruby vs. Clojure for Back-End Development - 30min
    02:45PM Ruby on Rails Legacy App Maintenance - 60min
    03:45PM A World Without HackerNews - 30min
    04:15PM User Interface CSS in Rails Apps - 30min
    05:00PM Networking Event

## Notes
- The input and output file pathnames are passed as arguments to the main: java -cp . -jar Conference-Management-1.0-SNAPSHOT.jar talksinput.txt talksoutput.txt.
Better argument processing should be considered for production environment.
- I made a conscious design decision to AVOID sorting by size the talks read in from the input text file. This is to prevent a lopsided distribution of talks by size in the sessions. Sorting the talks by size initially will result in talks of longer duration concentrated at the beginning of the sessions if the talks are sorted in descending order for instance. Not sorting gives the user more control over how the talks are distributed by size. It would be interesting to experiment with randomizing the order of talks by size before processing to secure a more even distribution of talk durations if indeed this is a requirement.

## Build, Deploy Run
- To build and deploy from ./Conference-Management-Ade-Lucas: mvn clean install
- Builds and deploys to: ./Conference-Management-Ade-Lucas/deployment
- cd ./Conference-Management-Ade-Lucas/deployment
- ./run.sh
- Runs the program and produces ./Conference-Management-Ade-Lucas/deployment/talksoutput.txt



















