/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_VictorSPX leftFrontMotor;
	WPI_TalonSRX leftRearMotor;
	WPI_TalonSRX rightFrontMotor;
	WPI_VictorSPX rightRearMotor;
	DifferentialDrive dd;
	SpeedControllerGroup left;
	SpeedControllerGroup right;

  public Drivetrain() {
    super();

    // define motors
		leftFrontMotor = new WPI_VictorSPX(RobotMap.leftFront);
		leftRearMotor = new WPI_TalonSRX(RobotMap.leftBack);
		rightFrontMotor = new WPI_TalonSRX(RobotMap.rightFront);
		rightRearMotor = new WPI_VictorSPX(RobotMap.rightBack);
		
		// set motors inverted if needed
		leftFrontMotor.setInverted(false);
		leftRearMotor.setInverted(false);
		rightFrontMotor.setInverted(false);
		rightRearMotor.setInverted(false);

		
		// create motor controller groups
		left = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
		right = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);

		// set motor controller groups inverted if needed
		left.setInverted(true);
		right.setInverted(true);
		
		dd = new DifferentialDrive(left, right);
		dd.setSafetyEnabled(false);
		dd.setDeadband(0.1);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		dd.arcadeDrive(moveSpeed * RobotMap.driveSpeed, rotateSpeed * RobotMap.turnSpeed);
	}
	
	public void curvatureDrive(double moveSpeed, double rotateSpeed) {
		dd.curvatureDrive(moveSpeed * RobotMap.driveSpeed, rotateSpeed * RobotMap.turnSpeed, true);
	}

	public void tankDrive(double leftSpeed, double rightSpeed) {
		dd.tankDrive(leftSpeed, rightSpeed);
	}

	public void camDrive(double leftSpeed, double rightSpeed) {
		left.set(-leftSpeed);
		right.set(rightSpeed);
	}
	
	public void autoDrive(double speed) {
		left.set(-speed);
		right.set(speed);
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Drive());
  }
}
