# SYSC 3303 Lab 5 Group 2

#### Hasan [@hasanissa25](https://github.com/hasanissa25)
#### George [@george-carleton](https://github.com/george-carleton)
#### Jack [@JackTurner98](https://github.com/JackTurner98)

## INSTRUCTIONS:
1. git pull the repository above
2. Import project into Eclipse
	- Select 'File' menu
	- Select 'Import' menu item
	- Under 'General' select 'Projects From File System'
	- Select 'Archive'
	- Locate pulled repo
	- Click 'Finish'
3. From within the project run the PassengerSimulator.java located in
	- sysc3303 -> group2 -> elevatorsystem -> simulator -> PassengerSimulator.java
4. View actions in console window

## FILES:
common:
- networking
  * Message.java
  * NetworkUtility.java
  * RequestType.java
* Direction.java
* DirectionLamps.java
* ElevatorState.java
* Utility.java

elevator:
* ArrivalSensor.java
* Elevator.java
* ElevatorButton.java
* ElevatorDoor.java
* ElevatorLamp.java
* ElevatorMotor.java
* ElevatorMotorEnum.java
* ElevatorServer.java

floor:
* Floor.java
* FloorButton.java
* FloorClient.java
* FloorLamp.java

scheduler:
- test
  * SchedulerTest.java
* Scheduler.java
* SchedulerHost.java
* ServiceRequest.java

simulator:
- test
  * SystemIntegrationTest.java
* PassengerSimulator.java
* SimulationEvent.java

## RESOURCES:

- Google drive folder for the project: http://bit.ly/2HGr5Yl
- UML Class Diagram: http://bit.ly/2Sip2Oa
- State Machine Diagram Elevator: http://bit.ly/2RozLSu
- State Machine Diagram Floor: http://bit.ly/2Tmf1gb
- State Machine Diagram for Scheduler: http://bit.ly/2Siks2q

## Breakdown of Responsibilities

## Iteration 5
The last stage of the project is to add a display console showing where each of the elevators is in real time and
displaying any faults (if any). The idea is to have output suitable for the concierge sitting at the desk in the
front lobby to refer to. This part of the project can be part of the floor subsystem if you so choose, or you may
want to develop a separate subsystem altogether. 

- Hasan

- George

- Jack

## Iteration 4
For this part, you will have to measure the performance of the scheduler subsystem. To do so, you will have to
run the scheduler on a separate computer than the floor and elevator subsystems. You will have to repeat the
measurements several times and with sufficient traffic in order to find, minimally, the mean and variance of the
time the scheduler takes to service a request. Using these numbers, use Rate Monotonic Analysis to assign
priorities to tasks as necessary. Deadlines for various events are as follows: 

- Hasan

- George

- Jack

## Iteration 3
For this iteration, you will be adding code for detecting and handling faults. To this end, you will have to add
timing events so that if the timer goes off before an elevator reaches a floor, then your system should assume a
fault (either, the elevator is stuck between floors, or the arrival sensor at a floor has failed). Similarly, you
should detect whether a door opens or not, or is stuck open. In iteration 5 below, your elevator status output
should show these faults. A door which has not closed should be regarded as a transient fault, so your system
should be able to handle this situation gracefully. However, the floor timer fault should be regarded as a hard
fault and should shut down the corresponding elevator.

You must submit code to enable us to see that your elevator scheduler can deal properly with the faults shown
above (i.e., you must be able to inject these faults into the system). I suggest that you inject these faults using the
input file (so you will have to modify its format and be able to show to us how it works). 

- Hasan
  - 

- George
  - Timing diagram showing error scenarios
  - Any unchanged diagrams from the previous iterations UML class diagram

- Jack
  -

## Iteration 2
For this iteration, you are to coordinate the movement of cars such that each car carries roughly the same
number of passengers as all of the others and so that the waiting time for passengers at floors is minimized.
Hint: if a passenger wants to go down and there is an elevator above the passenger, then that elevator should
service the passenger rather than having a second elevator go up instead. The state machines for each car should
execute independently of each other, but they will all have to share their position with the scheduler. The
scheduler will choose which elevator will be used to service a given request.

- Hasan
  - Integration testing: put the system together and test all scenarios
  - black box testing
  - Simulator: set simulation environment and give access to tests as a passenger e.g pressing floor buttons,observing lamps, observing floors the elevator is at...
  - j unit testing: identity all the methods needed for tests: Which floor the elevator is currently at, access elevator object and compare to what the scheduler thinks its at  
  - The map tracks multiple elevators 

- George
  - Send arrival sensor data to scheduler over network 
  - Arrival sensor stopping at max floor
  - Ability to receive stop motor commands
  - Modify elevator requests to the scheduler to support multiple passengers
  - Add j unit testing

- Jack
  - update to allow for multiple passengers per elevator(must have the elevator request code finished first)
  - Support multiple elevators : processFloorButtonRequest
  - implement todo elevatorButtonRequest in the run() method 
  - implement the todo: processArrivalSensorData

## Iteration 0 & 1
- Hasan
  - UML CLass Diagram
  - System Design
  - Software Code
- George
  - Transfer UML to framework code
  - Software Code
  - State Machine Diagrams
- Jack
  - Software Code
