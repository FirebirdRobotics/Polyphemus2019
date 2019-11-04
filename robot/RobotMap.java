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
   // Speed Constants (be careful with these)
   public static double driveSpeed = 1.0;
   public static double turnSpeed = 0.8;
   public static double eleSpeed = 0.5;
   public static double shoulderSpeed = 0.5;
   public static double wristSpeed = 0.35;
   public static double clawSpeed = 0.35; // changed from 0.35 to ???
   public static double visionSpeed = 0.2;   
   // public static double climbSpeed = 0.2; // currently setting it manually
   public static double bumpSpeed = 0.2;
   public static double startDriveSpeed = 0.25;
   public static double startDriveSpeed2 = 0.75; // temporary
 
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
   public static int frontOut = 2;
   public static int backIn = 3;
   public static int backOut = 1;
   public static int pnuematicClawPort = 4;

   // for certain motors, dont know if works without
   public static int kTimeoutMs = 30;
}
