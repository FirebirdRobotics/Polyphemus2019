/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;

public class VisionRoutine extends Command {
  public VisionRoutine() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.visionSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.oi.xboxControllerOne.getTriggerAxis(Hand.kLeft) != 0){
      Robot.visionSystem.tapeVisionRoutine(RobotMap.visionSpeed);
      System.out.println("completed tape vision routine");
    }else if(Robot.oi.xboxControllerOne.getTriggerAxis(Hand.kRight) != 0){
      Robot.visionSystem.cargoVisionRoutine(RobotMap.visionSpeed);
      System.out.println("completed cargo vision routine");
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}