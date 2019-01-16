/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;



import edu.wpi.first.wpilibj.command.Command;

public class StiltMacro extends Command {
  public StiltMacro() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    // requires(Stilts);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    //do nothing
    //gonna need to reset and start a timer for stilt timing
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //in english what i want to accomplish is drive forward at a currently undetermined speed and drop the first stilt at the proper distance away from the wall
    //then i will after a proper time drop the other stilt 
    //the second stilt should ideally drop when the front wheels are on the platform already

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //this doesnt matter the game will be over
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //please dont interrupt this command
  }
}
