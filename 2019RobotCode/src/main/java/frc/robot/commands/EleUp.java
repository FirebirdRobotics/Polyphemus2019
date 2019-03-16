// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands;

// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.Robot;
// import frc.robot.RobotMap;

// public class EleUp extends Command {
//   public EleUp() {
//     super();
//     requires(Robot.elevatorSystem);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   protected void initialize() {
//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   protected void execute() {
//     // double stickValue = Robot.oi.xboxControllerOne.getY(Hand.kRight);
//     // Robot.elevatorSystem.moveElevator((stickValue) * RobotMap.eleSpeed);
//     Robot.elevatorSystem.setElevator(RobotMap.eleSpeed);
    
//   }

//   // Make this return true when this Command no longer needs to run execute()
//   boolean done = false;
//   @Override
//   protected boolean isFinished() {
//     // return !Robot.elevatorSystem.elevatorState.get();
//     if(Robot.elevatorSystem.elevatorState.get()) {

//       if(Robot.elevatorSystem.elevatorMotor.getActiveTrajectoryVelocity() != 0) {
        
//         done = false;
//         // Thread.sleep(200);
//       }else{
//         done = true;
//       }
//     }
//     return done;
    
//   }

//   // Called once after isFinished returns true
//   @Override
//   protected void end() {
//     Robot.elevatorSystem.setElevator(0.0);
//     System.out.println("elevator stopped");
//   }

//   // Called when another command which requires one or more of the same
//   // subsystems is scheduled to run
//   @Override
//   protected void interrupted() {
//   }
// }
