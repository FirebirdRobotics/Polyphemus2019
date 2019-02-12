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
  // Timer timer;

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

    // timer = new Timer();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void visionRoutine(double left, double right) {
    // timer.start();
    // System.out.println("vision routine, yaw is: " + tapeYaw.getDouble(0));
      while (tapeYaw.getDouble(0) >= 2.00 || tapeYaw.getDouble(0) <= -2.00) {
        
          if (tapeYaw.getDouble(0) <= -2.00) { // if negative (on right)
              // put left backwards & right forwards (rotate counter-clockwise)
              Robot.driveTrain.camDrive(left, -right);
              System.out.println("negative values");
          } else if (tapeYaw.getDouble(0) >= 2.00) { // if positive (on right)
              // put left forwards & right backwards (rotate clockwise)
              Robot.driveTrain.camDrive(-left, right);
              System.out.println("positive values");
          }
          // if (timer.get() > 3.0) {
          //   break;
          // }
      }
  }
}
