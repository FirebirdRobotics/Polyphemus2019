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

public class Elevator extends Command {
  public Elevator() {
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
    if(Robot.oi.xboxControllerTwo.getBumper(Hand.kRight)) {
      Robot.elevatorSystem.setElevator(RobotMap.eleSpeed);
      // System.out.println("elevator up");
    } else if(Robot.oi.xboxControllerTwo.getBumper(Hand.kLeft)) {
      Robot.elevatorSystem.setElevator(-RobotMap.eleSpeed);
      // System.out.println("elevator down");
    } else {
      Robot.elevatorSystem.setElevator(0.0);
      // System.out.println("elevator stopped");
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.elevatorSystem.setElevator(0.0);
    System.out.println("elevator stopped");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
