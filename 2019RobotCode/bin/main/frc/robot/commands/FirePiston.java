/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.subsystems.Solenoids;

public class FirePiston extends Command {
  public FirePiston() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.solenoids);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // this code might be in here or it might be in initialize, idk for now
    // btw these '_systems' are NOT the actual names, they are just examples
    // and can be replaced with the names of the actual subsystems (same with methods):

    // Robot.elevatorSystem.raiseElevator([insert speed here], [insert time here]);
    // Thread.sleep(1000);
    // Robot.armSystem.setMotors([speed], [time]);
    Robot.solenoids.fire();
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
