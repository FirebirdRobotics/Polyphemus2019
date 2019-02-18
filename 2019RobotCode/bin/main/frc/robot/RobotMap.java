/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // Speed Constants
  public static double driveSpeed = 0.7;
  public static double turnSpeed = 0.3;
  public static double eleSpeed = .1;
  public static double shoulderSpeed = .2;
  public static double wristSpeed = .2;
  public static double clawSpeed = .2;
  public static double visionSpeed = .1;

  // CAN Motor Controller Ports (Drivetrain)
	public static int rightFront = 1;
  public static int rightBack = 2;
	public static int leftFront = 3;
	public static int leftBack = 4;

  // PWM Ports
  public static int shoulderPort = 5;
  public static int elevatorPort = 6;
  public static int wristPort = 7;
  public static int clawPort = 8;

  // Solenoids
  public static int frontIn = 0;
  public static int frontOut = 1;
  public static int backIn = 2;
  public static int backOut = 3;

  //encoderCounts
  //all #s are psuedo until we have the robot
  //these need to be given values before the placeHatch method can be called because it relies on comparing to these vals
  public static int lowEle = 50;
  public static int midEle = 100;
  public static int hiEle = 200; //cant do hi
  public static int climbEle = 50;

  public static int lowShoulder = 50;
  public static int midShoulder = 100;
  public static int hiShoulder = 120; // cant do hi
  public static int climbShoulder = 50;

  public static int lowWrist = 50;
  public static int midWrist = 50;
  public static int climbWrist = 50;

  /*public static int lowElbow;
  public static int midElbow;
  public static int hiElbow;
  */
  public static int lowBallEle = 50;
  public static int lowBallShoulder = 50;
  public static int lowBallWrist = 50;

  public static int midBallEle = 50;
  public static int midBallShoulder = 50;
  public static int midBallWrist = 50;

  public static int ballPickEle = 50;
  public static int ballPickShoulder = 50;
  public static int ballPickWrist = 50;


  //cant do ball hi

  public static int kTimeoutMs = 30;
}
