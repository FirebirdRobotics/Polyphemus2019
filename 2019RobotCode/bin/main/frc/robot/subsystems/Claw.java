/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;

public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static Talon clawMotor;
  Timer clawTime;
  

  public Claw() {

    clawMotor = new Talon(RobotMap.hatchSystemPort);
    clawTime = new Timer();

  }
                                //---
  //                   2       /      \
  //            ______________   3/4
  //          /                \      /
  //         /                  \\---
  //     1  /
  //       /
  //      /
  //     /
  //  1 = first arm, 2 = second arm, 3 = flat w/ target
  //

  public void place() {
    // (re)set elevator to lowest pos.
    // make arm 1 straight up
    // make arm 2 straight down
    // put 3 straight/flat
    // drive
    clawTime.reset();
    clawTime.start();

    
    while(clawTime.get() < 2){
      Robot.driveTrain.camDrive(.2, .2);
    }
    close();

    

    while(clawTime.get() < 3){
      Robot.driveTrain.camDrive(-.2, -.2);
    }
    open();
  }

  public void stationPickup() {
    clawTime.reset();
    clawTime.start();
    //center on tape

    //drivetrain.camDrive(.2, .2);
    //drivetrain.camDrive(-.2, -.2);

    close();
    while(clawTime.get() < 2){
      Robot.driveTrain.camDrive(.2, .2);
    }

    open();
    while(clawTime.get() < 3){
      Robot.driveTrain.camDrive(-.2, -.2);
    }
   

  }

  public void ballPickup(){
    //WILL NOT HAVE A CONTROL ASSOCIATED WITH IT UNTIL IT HAS A DROPOFF
    //does not have vision
    //would be one button for setting the arm to the spot it is wanted in and
      //another for the actual pickup button

    //ANGLE DOWN
      //ele system ballpickup position for arm and everything
      close();
  }

  public void ballDrop(){
    //needs to have thje arm in the right spot
    
    open();
  }

 //cant happen with current claw public void groundPickup() {
    //flatten #3
    //lower as low as possible
    //pick back up

  //}

  public void open() {
    clawTime.reset();
    clawTime.start();
    while(clawTime.get() <= .5) {
      clawMotor.set(.3);
    }
  }

  public void close() {
    clawTime.reset();
    clawTime.start();
    while(clawTime.get() <= .5) {
      clawMotor.set(-.3);
    }
  }

  @Override
  public void initDefaultCommand() {
    // create a command that sets the hatch system back to default
    // setDefaultCommand(new SetHatchSystemDefault());
  }
}