/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Elevator;

/**
 * Add your docs here.
 */
public class ElevatorSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static TalonSRX elevatorMotor;
  static Encoder eleEncoder;
  
  public ElevatorSystem() {
    // define motors
    elevatorMotor = new TalonSRX(RobotMap.elevatorPort);   

    // set motors inverted if needed
    elevatorMotor.setInverted(true);

    // 0 and 1 are the port numbers for the two digital inputs and false tells the encoder to not invert the counting direction.
    //if then encoders are counting the wrong way, switch the false to true instead of changing all the < & > operators
       
    elevatorMotor.configFactoryDefault();

    // initQuadrature();

    elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);

    elevatorMotor.setSensorPhase(true);
  }

  public void setElevator(double speed) {
    elevatorMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Elevator());
  }
}
