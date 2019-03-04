# SYSC 3303 Lab 5 Group 2

#### Hasan [@hasanissa25](https://github.com/hasanissa25)
#### George [@george-carleton](https://github.com/george-carleton)
#### Jack [@JackTurner98](https://github.com/JackTurner98)

## Instructions:
1. Extract The zipfolder into Eclipse IDE
2. Run The Simulation
3. View actions in console window

## FILES:
* * ElevatorStateMachine
* * FloorStateMachine
* * SchedulerStateMachine
* * UML
* * RunInstructions
* * Code

- Google drive folder for the project: http://bit.ly/2HGr5Yl
- UML Class Diagram: http://bit.ly/2Sip2Oa
- State Machine Diagram Elevator: http://bit.ly/2RozLSu
- State Machine Diagram Floor: http://bit.ly/2Tmf1gb
- State machine diagram for the scheduler and elevator subsystems
- “README.txt” file explaining the names of your files, set up instructions, etc. 
- Detailed set up and test instructions, including test files used


## Breakdown of Responsibilities

## Iteration 0 & 1

### Hasan
- UML CLass Diagram
- System Design
- Software Code


### George
- Transfer UML to framework code
- Software Code
- Google Drive
  - State Machine Diagram For Elevator: 
    - http://bit.ly/2RozLSu
  - State Machine Diagram For Floor: 
    - http://bit.ly/2Tmf1gb
  - State Machine Diagram for Scheduler:
    - http://bit.ly/2Siks2q   

### Jack
- Software Code

## Iteration 2

### Hasan
- Integration testing: put the system together and test all scenarios
- black box testing
- Simulator: set simulation environment and give access to tests as a passenger e.g pressing floor buttons,observing lamps, observing floors the elevator is at...
- j unit testing: identity all the methods needed for tests: Which floor the elevator is currently at, access elevator object and compare to what the scheduler thinks its at  
- The map tracks multiple elevators 

### George
Elevator:
  - Send arrival sensor data to scheduler over network 
  - Arrival sensor needs to stop at max floor
  - Ability to receive stop motor commands
  - Modify elevator requests to the scheduler to support 	multiple passengers
  - Add j unit testing

### Jack
Scheduler:
  - update to allow for multiple passengers per elevator(must have the elevator request code finished first)
  - Support multiple elevators : processFloorButtonRequest
  - implement todo elevatorButtonRequest in the run() method 
  - implement the todo: processArrivalSensorData
  
## Iteration 3

### Hasan

### George

### Jack
