/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Solenoids extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  DoubleSolenoid frontPiston;
  DoubleSolenoid backPiston;
  Timer climbTime;
  public Boolean climbSequenceOver;

  public Solenoids() {
    frontPiston = new DoubleSolenoid(RobotMap.frontIn, RobotMap.frontOut);
    backPiston = new DoubleSolenoid(RobotMap.backIn, RobotMap.backOut);
    climbTime = new Timer();
    climbSequenceOver = false;
  }

  public void frontPistonsUp(){
    frontPiston.set(DoubleSolenoid.Value.kForward);
  }

  public void frontPistonsDown(){
    frontPiston.set(DoubleSolenoid.Value.kReverse);
  }

  public void backPistonsUp(){
    backPiston.set(DoubleSolenoid.Value.kForward);
  }

  public void backPistonsDown(){
    backPiston.set(DoubleSolenoid.Value.kReverse);
  }

  public void climb() {
    /*
        RESET POSITION OF ROBOT
    */

    // front pistons sequence
    frontPiston.set(DoubleSolenoid.Value.kForward);
    climbTime.start();
        while(climbTime.get() < 0.1) {
            Robot.driveTrain.autoDrive(0.25);
        }
        Robot.driveTrain.autoDrive(0);
    climbTime.reset();
    frontPiston.set(DoubleSolenoid.Value.kReverse);
    backPiston.set(DoubleSolenoid.Value.kForward);

    // back pistons sequence
    climbTime.start();
        while(climbTime.get() < 0.4) {
            Robot.driveTrain.autoDrive(0.75);
        }
        Robot.driveTrain.autoDrive(0);
    climbTime.reset();
    backPiston.set(DoubleSolenoid.Value.kReverse);

    // final drive onto platform sequence
    climbTime.start();
        while(climbTime.get() < 0.5) {
            Robot.driveTrain.autoDrive(0.75);
        }
        Robot.driveTrain.autoDrive(0);
    climbTime.reset();

    climbSequenceOver = true;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
