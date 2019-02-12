/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystems.*;
import frc.robot.*;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.Encoder;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI oi;
  public static Drivetrain driveTrain;
  public static ElevatorSystem elevator;
  public static HatchSystem hatchSystem;
  public static Solenoids solenoids;
  public static Encoder pivEncoder;
  public static Encoder eleEncoder;
  
  // Vision Stuff
//   private boolean driverVision, tapeVision, cargoVision, cargoSeen, tapeSeen;
//   public static NetworkTableEntry tapeDetected, cargoDetected, tapeYaw, cargoYaw, videoTimestamp, driveWanted, tapeWanted, cargoWanted;
//   private double targetAngle;
//   NetworkTableInstance instance;
//   NetworkTable chickenVision;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    driveTrain = new Drivetrain();
    elevator = new ElevatorSystem();
    hatchSystem = new HatchSystem();
    solenoids = new Solenoids();
    eleEncoder = new Encoder();
    pivEncoder = new Encoder();
    oi = new OI(); // Make sure the OI is initialized LAST

   // Vision
    // instance = NetworkTableInstance.getDefault();
    // chickenVision = instance.getTable("ChickenVision");

    // tapeDetected = chickenVision.getEntry("tapeDetected");
    // cargoDetected = chickenVision.getEntry("cargoDetected");
    // tapeYaw = chickenVision.getEntry("tapeYaw");
    // cargoYaw = chickenVision.getEntry("cargoYaw");

    // driveWanted = chickenVision.getEntry("Driver");
    // tapeWanted = chickenVision.getEntry("Tape");
    // cargoWanted = chickenVision.getEntry("Cargo");

    // videoTimestamp = chickenVision.getEntry("VideoTimestamp");

    // tapeVision = cargoVision = false;
    // driverVision = true;

    // m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    // SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out. 
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    // Vision Code
    // boolean cargoDesired = oi.xboxController.getBumper(Hand.kLeft);
    // boolean tapeDesired = oi.xboxController.getBumper(Hand.kRight);

    // if (cargoDesired) { // If bumper on left side
    //     driveWanted.setBoolean(false);
    //     tapeWanted.setBoolean(false);
    //     cargoWanted.setBoolean(true);
    //     cargoSeen = cargoDetected.getBoolean(false);

    //     if (cargoSeen)
    //         targetAngle = cargoYaw.getDouble(0);
    //     else
    //         targetAngle = 0;
    // } else if (tapeDesired) { // If bumper on right side
    //     driveWanted.setBoolean(false);
    //     tapeWanted.setBoolean(true);
    //     cargoWanted.setBoolean(false);
    //     // Checks if vision sees cargo or vision targets. This may not get called unless
    //     // cargo vision detected
    //     tapeSeen = tapeDetected.getBoolean(false);

    //     if (tapeSeen)
    //         targetAngle = tapeYaw.getDouble(0);
    //     else
    //         targetAngle = 0;
    // } else {
    //     driveWanted.setBoolean(true);
    //     tapeWanted.setBoolean(false);
    //     cargoWanted.setBoolean(false);

    //     targetAngle = 0;
    // }

    // if (tapeDesired) {
    //     visionRoutine(0.2, 0.2);
    // }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    
  }
	
//   public void visionRoutine(double left, double right) {
//     while (tapeYaw.getDouble(0) >= 2.00 || tapeYaw.getDouble(0) <= -2.00) {
//         if (tapeYaw.getDouble(0) <= -2.00) { // if negative (on right)
//             // put left backwards & right forwards (rotate counter-clockwise)
//             driveTrain.camDrive(left, -right);
//         } else if (tapeYaw.getDouble(0) >= 2.00) { // if positive (on right)
//             // put left forwards & right backwards (rotate clockwise)
//             driveTrain.camDrive(-left, right);
//         }
//     }
//   }
}
