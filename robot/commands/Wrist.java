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

public class Wrist extends Command {

  double joystickValue;

  public Wrist() {
    super();
    requires(Robot.wristSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    joystickValue = Robot.oi.xboxControllerTwo.getY(Hand.kRight);

    if(joystickValue < 0) {
      Robot.wristSystem.setWrist(joystickValue * -RobotMap.wristSpeed);
      // System.out.println("wrist up");
    } else if(joystickValue > 0) {
      Robot.wristSystem.setWrist(joystickValue * -RobotMap.wristSpeed);
      // System.out.println("wrist down");
    } else {
      Robot.wristSystem.setWrist(0.0);
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
    Robot.wristSystem.setWrist(0.0);
    System.out.println("wrist stopped");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
