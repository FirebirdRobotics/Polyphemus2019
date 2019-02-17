/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class VisionSystem extends Subsystem {
  // Vision Stuff
  private boolean driverVision, tapeVision, cargoVision, cargoSeen, tapeSeen;
  private NetworkTableEntry tapeDetected, cargoDetected, tapeYaw, cargoYaw, videoTimestamp, driveWanted, tapeWanted, cargoWanted;
  private double targetAngle;
  NetworkTableInstance instance;
  NetworkTable chickenVision;
  long yawValue;
  int timeInt;

  public VisionSystem() {
    // Vision
    instance = NetworkTableInstance.getDefault();
    chickenVision = instance.getTable("ChickenVision");

    tapeDetected = chickenVision.getEntry("tapeDetected");
    tapeYaw = chickenVision.getEntry("tapeYaw");
    cargoDetected = chickenVision.getEntry("cargoDetected");
    cargoYaw = chickenVision.getEntry("cargoYaw");

    driveWanted = chickenVision.getEntry("Driver");
    tapeWanted = chickenVision.getEntry("Tape");
    cargoWanted = chickenVision.getEntry("Cargo");

    videoTimestamp = chickenVision.getEntry("VideoTimestamp");

    tapeVision = cargoVision = false;
    driverVision = true;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void tapeVisionRoutine(double left, double right) {
    timeInt = 0;
    double rawYaw = tapeYaw.getDouble(0);
      while (rawYaw > 2.0 || rawYaw < -2.0) {
        yawValue = (long) Math.abs(rawYaw);
        System.out.println("----");
        System.out.println("rawYaw: " + rawYaw);
        System.out.println("absYaw: " + yawValue);
          if (rawYaw < -2.0) { // if negative (on right)
              // put left backwards & right forwards (rotate counter-clockwise)
              Robot.driveTrain.camDrive(-left, right);
              System.out.println("tapeYaw is on left");
              System.out.println("timeInt: " + timeInt);
          }
          else if (rawYaw > 2.0) { // if positive (on right)
              // put left forwards & right backwards (rotate clockwise)
              Robot.driveTrain.camDrive(left, -right);
              System.out.println("tapeYaw is on right");
              System.out.println("timeInt: " + timeInt);
          }
          if (timeInt++ >= 20) {
            Robot.driveTrain.camDrive(0, 0);
            System.out.println("pausing motors");
            return;
          }
          // use sleeps to control how long robot is running/stopping motors
          try {
            Thread.sleep(yawValue * 25); // how long robot runs motors
            Robot.driveTrain.camDrive(0, 0);

            // IMPORTANT: THIS SLEEP MUST BE LONG ENOUGH FOR THE ROBOT TO ACTUALLY PAUSE
            Thread.sleep(500); // how long robot sets motors to 0

            System.out.println("pausing motors");
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          rawYaw = tapeYaw.getDouble(0);
      }
      // stop motors after exiting while loop
      Robot.driveTrain.camDrive(0, 0);
      System.out.println("final yaw: " + tapeYaw.getDouble(0));
      System.out.println("final rawYaw: " + rawYaw);
  }

  public void ballVisionRoutine(double left, double right) {
    timeInt = 0;
    double rawYaw = cargoYaw.getDouble(0);
      while (rawYaw > 2.0 || rawYaw < -2.0) {
        yawValue = (long) Math.abs(rawYaw);
        System.out.println("----");
        System.out.println("rawYaw: " + rawYaw);
        System.out.println("absYaw: " + yawValue);
          if (rawYaw < -2.0) { // if negative (on right)
              // put left backwards & right forwards (rotate counter-clockwise)
              Robot.driveTrain.camDrive(-left, right);
              System.out.println("cargoYaw is on left");
              System.out.println("timeInt: " + timeInt);
          }
          else if (rawYaw > 2.0) { // if positive (on right)
              // put left forwards & right backwards (rotate clockwise)
              Robot.driveTrain.camDrive(left, -right);
              System.out.println("cargoYaw is on right");
              System.out.println("timeInt: " + timeInt);
          }
          if (timeInt++ >= 20) {
            Robot.driveTrain.camDrive(0, 0);
            System.out.println("pausing motors");
            return;
          }
          // use sleeps to control how long robot is running/stopping motors
          try {
            Thread.sleep(yawValue * 25); // how long robot runs motors
            Robot.driveTrain.camDrive(0, 0);

            // IMPORTANT: THIS SLEEP MUST BE LONG ENOUGH FOR THE ROBOT TO ACTUALLY PAUSE
            Thread.sleep(500); // how long robot sets motors to 0

            System.out.println("pausing motors");
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          rawYaw = cargoYaw.getDouble(0);
      }
      // stop motors after exiting while loop
      Robot.driveTrain.camDrive(0, 0);
      System.out.println("final yaw: " + cargoYaw.getDouble(0));
      System.out.println("final rawYaw: " + rawYaw);
  }

  /*
  Drive TOWARDS THE TAPE STRAIGHT LINE?!
  public double l = .2;
  public double r = .2; 
  Timer camTime = new Timer();
  public void driveToward(){
    camTime.start();
    Robot.driveTrain.camDrive(l, r);
      while(camTime.get() < 3){
        if(tapeYaw.getDouble(0) <= -1){
          r += .1;
          l -= .1;
          Robot.driveTrain.camDrive(l, r);
        }else if(tapeYaw.getDouble(0) >= 1){
          r -= .1;
          l += .1;
          Robot.driveTrain.camDrive(l, r);
        } else Robot.driveTrain.camDrive(.2, .2);
        
      }
  }
  */ 
}