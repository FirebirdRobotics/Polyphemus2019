/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Claw extends Command {
  public Claw() {
    super();
    requires(Robot.claw);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // code for old claw (using motor)
    // if(Robot.oi.xboxControllerTwo.getTriggerAxis(Hand.kLeft) != 0){
    //   Robot.claw.setClaw(RobotMap.clawSpeed);
    //   // System.out.println("open claw");
    // }else if(Robot.oi.xboxControllerTwo.getTriggerAxis(Hand.kRight) != 0){
    //   Robot.claw.setClaw(-RobotMap.clawSpeed);
    //   // System.out.println("close claw");
    // }else{
    //   Robot.claw.setClaw(0.0);
    // }

    if(Robot.claw.clawSolenoid.get() == Value.kReverse) {
      Robot.claw.setClaw(Value.kForward);
    } else if(Robot.claw.clawSolenoid.get() == Value.kForward) {
      Robot.claw.setClaw(Value.kReverse);
    } else {
      Robot.claw.setClaw(Value.kOff);
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
    // Robot.claw.setClaw(0.0);
    Robot.claw.setClaw(Value.kOff);
    System.out.println("claw stopped");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
