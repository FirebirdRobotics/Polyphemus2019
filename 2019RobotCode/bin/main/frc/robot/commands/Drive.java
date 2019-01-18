/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

  double move;
  double turn;

   public Drive(double timeout) {
	super(timeout);
	requires(Robot.driveTrain);
   }

   public Drive() {
	super();
	requires(Robot.driveTrain);
   }
  
   public Drive(double move, double turn, double timeout) {
	this(timeout);
	this.move = move;
	this.turn = turn;
   }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // replace with whatever interface we r using (Shuffleboard?)
    // SmartDashboard.putNumber("move", move);
    // SmartDashboard.putNumber("turn", turn);
    
    // if (RobotMap.orientForward) {
    // 	move = -Robot.oi.xbox.getY(Hand.kLeft);
    // 	turn = Robot.oi.xbox.getX(Hand.kLeft);
    // } else {
    // 	move = Robot.oi.xbox.getY(Hand.kLeft);
    // 	turn = Robot.oi.xbox.getX(Hand.kLeft);
    // }

    // stick only
    Robot.driveTrain.arcadeDrive(move * RobotMap.DRIVE_SCALE_FACTOR, -turn * RobotMap.TURN_SCALE_FACTOR);

    // add other methods to drive here (ex. curvature drive) - use this link:
    // https://wpilib.screenstepslive.com/s/currentCS/m/java/l/914148-driving-a-robot-using-differential-drive
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
