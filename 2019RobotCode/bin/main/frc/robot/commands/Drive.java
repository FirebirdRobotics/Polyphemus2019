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
	public Drive(double move, double turn){
		super();
		requires(Robot.driveTrain);
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
    
    // just in case we have the drivetrain going backwards (whether it be electrical or programming)
    // we have this code to change the value of the move
		if (RobotMap.orientForward) {
			move = -Robot.oi.xboxController.getY(Hand.kLeft);
			turn = Robot.oi.xboxController.getX(Hand.kLeft);
		} else {
			move = Robot.oi.xboxController.getY(Hand.kLeft);
			turn = Robot.oi.xboxController.getX(Hand.kLeft);
		}

		// stick only
		Robot.driveTrain.arcadeDrive(move * RobotMap.DRIVE_SCALE_FACTOR, -turn * RobotMap.TURN_SCALE_FACTOR);

    // add other methods to drive (located in DriveTrain) here (ex. curvature drive) - use this link:
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
