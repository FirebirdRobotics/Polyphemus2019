/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Claw;

/**
 * Add your docs here.
 */
public class ClawSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static VictorSPX clawMotor;
  public static Solenoid clawSolenoid;

  public ClawSystem() {
    // leave the one that's not in use commented out
    // clawMotor = new VictorSPX(RobotMap.clawPort);
    clawSolenoid = new Solenoid(RobotMap.pnuematicClawPort);
  }

  public void setClaw(double speed) {
    clawMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setPneumaticClaw(Boolean value) {
    clawSolenoid.set(value);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Claw());
  }
}
