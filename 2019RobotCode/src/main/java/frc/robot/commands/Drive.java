/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

  double move;
	double turn;

	public Drive() {
		super();
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // create the type of drive
    // Robot.driveTrain.arcadeDrive(move * RobotMap.driveSpeed, turn * RobotMap.turnSpeed);
    Robot.driveTrain.arcadeDrive(move, turn);

    // these variables need to be defined as the xbox stick:
    // when the xbox stick is 0, then the robot is not moving
    move = Robot.oi.xboxControllerOne.getY(Hand.kLeft);
    turn = -Robot.oi.xboxControllerOne.getX(Hand.kLeft);

    // place move and turn values onto smartdashboard
    // SmartDashboard.putNumber("move", move);
    // SmartDashboard.putNumber("turn", turn);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
