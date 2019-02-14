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
  // Scale Factors
  public static double DRIVE_SCALE_FACTOR = 0.1;
  public static double TURN_SCALE_FACTOR = 1.0;

  // CAN Motor Controller Ports (Drivetrain)
	// public static int leftFront = 0;
	// public static int leftBack = 1;
	// public static int rightFront = 2;
  // public static int rightBack = 3;
  public static int tempLeftMotor = 1;
  public static int tempRightMotor = 6;
  
  // also for Drivetrain
  public static boolean orientForward = false;

  // PWM Ports
  public static int elevatorPort = 7; // temporary
  public static int hatchSystemPort = 8; // temporary
  public static int frontIn = 0; // solenoids
  public static int frontOut = 1; // solenoids
  public static int backIn = 2; // solenoids
  public static int backOut = 3; // solenoids
  public static int elbowPort = 4; // pivot at the elbow of the arm
  public static int shoulderPort = 5; //shoulder, motor connected directly to elevator box

  //encoderCounts
    //all #s are psuedo until we have the robot
    //these need to be given values before the placeHatch method can be called because it relies on comparing to these vals
  public static int lowEle;
  public static int midEle;
  public static int hiEle;

  public static int lowShoulder;
  public static int midShoulder;
  public static int hiShoulder;

  public static int lowElbow;
  public static int midElbow;
  public static int hiElbow;

}
