# Team 3019 Robot Code, 2018-2019 FRC Season
Robot Template Type: Command-Based
 
## Current Code Location:
The current code is located in the ***bin directory***, not the src directory (src directory is not updated & file directories are weird so idk)

## Full List of Macros:
- Climb
- PlaceHatchLowMacro
- PlaceHatchMiddleMacro
- PickupHatchStationMacro
- PickupBallMacro
- TapeVisionRoutine
- BallVisionRoutine

## Control Ideas/OI (for now):
##### XBOX1 = MOVEMENT
##### XBOX2 = ELEVATOR, ARM, CLAW, etc. (everything else)

----XBOX1----
 
- Left Joystick = drive
- Back button = climb
- left bumper = bump left
- right bumper = bump right
- right trigger = cargo vision routine
- left trigger = tape vision routine
 
----XBOX2----
 
- left joystick = arm
- right joystick = wrist
- right trigger = claw out
- left trigger = claw in
- left bumper = ele down manual
- right bumper = ele up manual
- A button = set arm to hatch low macro
- B button = set arm to hatch middle macro
- X button = hatch station pickup macro
- Y button = place/release hatch macro & drive back
- start button? = dance macro (?)

## Stuff we want to display on the SmartDashboard//Shuffleboard:
- [ ] camera feed (vision stuff) 
- [ ] type of drive
- [ ] distance from robot (or camera) to detected field element
- [ ] eagle-eye view of robot & pathing (arrow showing where the robot might go next)

## Stuff to do/Improvements:
- Ball pickup
- SetLowestPosition macro-
   a) put a method in each subsystem to do that & just run it in climb macro file
   b) make a new command file to do that
- Distance detection
- Dance function
- Make a document w/ what to do when code doesn't work (ex. check firmware, PCM must be id 0)
- Maybe a document showing off our code to judges (vision, macros, etc.)

## Other stuff (idk):
Read this to install the CTR-Electronics Phoenix software framework (for CAN motors/motor controllers):
https://phoenix-documentation.readthedocs.io/en/latest/index.html

This is me updating the readme to test something with the git bash terminal, sorry if it annoys you branden

whoa i think im starting to figure this out

