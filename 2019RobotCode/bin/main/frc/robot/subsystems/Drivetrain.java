/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem {
  
  	WPI_TalonSRX leftFrontMotor;
	WPI_TalonSRX leftRearMotor;
	WPI_TalonSRX rightFrontMotor;
	WPI_TalonSRX rightRearMotor;
	DifferentialDrive dd;
	SpeedControllerGroup left;
	SpeedControllerGroup right;
	
	public Drivetrain() {
		super();
		
		leftFrontMotor = new WPI_TalonSRX(RobotMap.leftFront);
		leftRearMotor = new WPI_TalonSRX(RobotMap.leftBack);
		rightFrontMotor = new WPI_TalonSRX(RobotMap.rightFront);
		rightRearMotor = new WPI_TalonSRX(RobotMap.rightBack);
		
		left = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
		left.setInverted(true);
		right = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
		right.setInverted(true);
		
		//Sets max current for talon srxs
		int maxCurr = 25;
		setTalonCurrLimit(leftFrontMotor, maxCurr);
		setTalonCurrLimit(leftRearMotor, maxCurr);
		setTalonCurrLimit(rightFrontMotor, maxCurr);
		setTalonCurrLimit(rightRearMotor, maxCurr);
		
		// dd = new DifferentialDrive(left, right);
		dd = new DifferentialDrive(left, right);
		dd.setSafetyEnabled(false);
		dd.setDeadband(0.1);
	}
	
	//Sets max current/amps for talon srxs
	private void setTalonCurrLimit(WPI_TalonSRX tal,  int amps) {
		tal.configContinuousCurrentLimit(amps, 1000);
		tal.configPeakCurrentLimit(amps, 1000);
		tal.configPeakCurrentDuration(0, 1000);
		tal.enableCurrentLimit(true);
	}

  	@Override
 	public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
	  }
	
	// Below are the various drives that we use throughout the robot code

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
		left.set(leftSpeed);
		right.set(rightSpeed);
	}
	
	public void autoDrive(double speed) {
		left.set(speed);
		right.set(speed);
	}
}
