/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
//i think this has two motors but idk, i think we are running out of ports
 

public class elbow extends Subsystem {
  static TalonSRX elbow;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public elbow(){   
    elbow = new TalonSRX(RobotMap.elbowPort);
  } 

  public void low(){

  }

  public void mid(){

  }
  public void high(){

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
