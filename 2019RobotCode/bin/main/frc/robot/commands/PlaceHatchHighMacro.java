/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PlaceHatchHighMacro extends Command {
  public PlaceHatchHighMacro() {
    // going to 'require(Robot.subsystem);' for elevator subsystem 
    // and whatever hatch claw/holder/thrower systems (arm & pistons)
    super();
    requires(Robot.elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.elevator.setArm("hi");
    // this code might be in here or it might be in initialize, idk for now
    // btw these '_systems' are NOT the actual names, they are just examples
    // and can be replaced with the names of the actual subsystems (same with methods):

    // Robot.elevatorSystem.raiseElevator([insert speed here], [insert time here]);
    // Thread.sleep(1000);
    // Robot.armSystem.setMotors([speed], [time]);
    // Thread.sleep(1000);
    // Robot.hatchSystem.activateReleasePistons([speed], [time]);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
    // stop all methods (not sure if there's any code necessary, just a reminder to double-check)
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
