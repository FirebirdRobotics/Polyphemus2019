/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Shoulder extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  static TalonSRX shoulder;

  public void Shoudler(){
    // shoulder = new TalonSRX(RobotMap.shoulderPort);
  }

  public void low(){
    //check for encoder count and move

    //will look similar to elevator and elbow
  }

  public void mid(){
    //check for encoder and move
  }

  public void high(){
    //check for encoder and move

    //see above comment n 
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
