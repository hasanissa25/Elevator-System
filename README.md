# SYSC 3303 Lab 5 Group 2

#### Hasan [@hasanissa25](https://github.com/hasanissa25)
#### George [@george-carleton](https://github.com/george-carleton)
#### Komiljon [@komiljon27](https://github.com/komiljon27)
#### Jack [@JackTurner98](https://github.com/JackTurner98)

## Instructions:
1.
2.
3.
4. View actions in console window

## FILES:

## Breakdown of Responsibilities

### Iteration 0 & 1
Professor Emails:
- Milestone descrption : "For this iteration, focus on a state machine for controlling the elevator and testing its operation.  Each elevator needs an arrival sensor.  You can either do one sensor per elevator per floor, or one sensor per elevator that returns a floor value.  I'll leave that up to you, though the cheapskate in me would lead me to use one sensor per elevator to save on sensors and wires.  Don't forget the elevator controller has to open and close the doors (and even turn lights on and off as necessary).  It's also up to you if the scheduler is a state machine or not (though it's likely easier as an extended state machine, where state is encoded in more than one instance variable) in the grand scheme of things).  The fun part comes later in the project where information has to be shared among elevators to optimize their scheduling.  Don't be surprised if you have to move stuff around (refactor).  It's all part of the grand scheme of things"

- Upon further reflection, it is best to put the arrival sensor in the elevator subsystem, not the floor subsystem (the project description is also undergoing iterative development).  You have a couple of choices regarding elevator movement from the scheduler.  Either the scheduler tells the elevator to go to floor N and the elevator signals the scheduler that it has arrived, or the elevator signals the scheduler when it arrives at each floor and the scheduler tells it to stop (or maybe both).  Your choice, but bear in mind that while an elevator is in motion, a floor request may come in (life is complicated).   You don't need to deal with the complication at this time, but don't paint yourself into a corner, otherwise, you will have to refactor your code later on.
Also, for this iteration, you don't need to handle the input file.  It is easier to develop JUnit test for the elevator state machine itself to check all transitions, and another test to ensure that messages are being passed successfully between the scheduler and the elevator.  The latter test should amount to "request elevator at floor N, expect elevator arrival, go to floor M, expect elevator arrival".  There is no need to incorporate time in this iteration, nor is there a need to handle floor requests while the elevator is "moving" between floors.  
If you have done more, I seem to recall that you should be using version control (Git, Subversion, Mercurial, Visual source safe, ClearCase, CVS (eww), bazaar, bit keeper,  GNU arch, Montone, DARCS... ) so here's your chance to use branching. 
 
- Google drive folder for the project: http://bit.ly/2HGr5Yl
- UML Class Diagram: https://bit.ly/2sUjB9y
- State Machine Diagram Elevator: http://bit.ly/2RozLSu
- State Machine Diagram Floor: http://bit.ly/2Wqvems
- State machine diagram for the scheduler and elevator subsystems
- “README.txt” file explaining the names of your files, set up instructions, etc. 
- Detailed set up and test instructions, including test files used

## Hasan
- Project Document study to help with the uml: https://docs.google.com/document/d/1BHV_G2eLSaxyXDfcedn_ym8igDu5b2ToxtycJc_ceD0/edit?usp=sharing

George
- 

## Komiljon
- Google Drive
  - [x] State Machine Diagram For Elevator: 
    - http://bit.ly/2RozLSu
  - [ ] State Machine Diagram For Floor: 
    - http://bit.ly/2Wqvems
    

Jack
-


