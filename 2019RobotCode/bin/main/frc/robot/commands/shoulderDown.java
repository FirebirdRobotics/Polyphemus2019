/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class shoulderDown extends Command {
  public shoulderDown() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    super();
    requires(Robot.elevatorSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // double stickValue = Robot.oi.xboxControllerOne.getY(Hand.kLeft);
    // Robot.elevatorSystem.moveShoulder((stickValue) * RobotMap.shoulderSpeed);
    Robot.elevatorSystem.shoulderDown();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !Robot.elevatorSystem.shoulderState.get();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.elevatorSystem.shoulderStop();
    System.out.println("Shoulder stopping");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
