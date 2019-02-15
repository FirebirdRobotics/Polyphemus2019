/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class VisionSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // Vision Stuff
  private boolean driverVision, tapeVision, cargoVision, cargoSeen, tapeSeen;
  private NetworkTableEntry tapeDetected, cargoDetected, tapeYaw, cargoYaw, videoTimestamp, driveWanted, tapeWanted, cargoWanted;
  private double targetAngle;
  NetworkTableInstance instance;
  NetworkTable chickenVision;
  Timer timer;
  long yawValue;
  int timeInt;

  public VisionSystem() {
    // Vision
    instance = NetworkTableInstance.getDefault();
    chickenVision = instance.getTable("ChickenVision");
    tapeDetected = chickenVision.getEntry("tapeDetected");

    //tape yaw, issue?!?!?!?!?!
    tapeYaw = chickenVision.getEntry("tapeYaw");
    // cargoDetected = chickenVision.getEntry("cargoDetected");
    // cargoYaw = chickenVision.getEntry("cargoYaw");

    driveWanted = chickenVision.getEntry("Driver");
    tapeWanted = chickenVision.getEntry("Tape");
    // cargoWanted = chickenVision.getEntry("Cargo");

    videoTimestamp = chickenVision.getEntry("VideoTimestamp");

    tapeVision = cargoVision = false;
    driverVision = true;

    timer = new Timer();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void visionRoutine(double left, double right) {
    // timer.start();
    timeInt = 0;
    // System.out.println("vision routine, yaw is: " + tapeYaw.getDouble(0));
      while (tapeYaw.getDouble(0) > 2.0 || tapeYaw.getDouble(0) < -2.0) {
        yawValue = (long) Math.abs(tapeYaw.getDouble(0));
        System.out.println("----");
        System.out.println("tapeYaw: " + tapeYaw.getDouble(0));
          if (tapeYaw.getDouble(0) < -2.0) { // if negative (on right)
              // put left backwards & right forwards (rotate counter-clockwise)
              Robot.driveTrain.camDrive(left, -right);
              System.out.println("tapeYaw is on left");
              System.out.println("timeInt: " + timeInt);
          }
          else if (tapeYaw.getDouble(0) > 2.0) { // if positive (on right)
              // put left forwards & right backwards (rotate clockwise)
              Robot.driveTrain.camDrive(-left, right);
              System.out.println("tapeYaw is on right");
              System.out.println("timeInt: " + timeInt);
          }
          if (timeInt++ > 10) {
            return;
          }
          // use sleeps to control how long robot is running/stopping motors
          try {
            Thread.sleep(yawValue * 40); // how long robot runs motors
            Robot.driveTrain.camDrive(0, 0);
            Thread.sleep(50); // how long robot sets motors to 0

            System.out.println("stopping motors");
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
      }
      // Set motors to zero after outside of loop
      Robot.driveTrain.camDrive(0, 0);
      System.out.println("final yaw: " + tapeYaw.getDouble(0));
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
