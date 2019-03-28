/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;

public class Solenoids extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

    DoubleSolenoid frontPiston;
    DoubleSolenoid backPiston;
    Timer climbTime;

    //IF THERE IS AN ERROR THIS IS IT
    // ElevatorSystem ele;
    
    public Solenoids() {

        frontPiston = new DoubleSolenoid(RobotMap.frontIn, RobotMap.frontOut);
        backPiston = new DoubleSolenoid(RobotMap.backIn, RobotMap.backOut);
        climbTime = new Timer();
        //THIS TOO
        // ele = new ElevatorSystem();
      
        // elevator = new Talon(RobotMap.elevatorPort);    
    
    }

    public void climb() {

        /*
            LOWER EVERYTING TO BOTTOM AND CENTER?!?!?!
        */

        // NOTE: to create this macro, what we will do is increase the TIMER by 0.05 every run
        // we will also only test one part at a time (ex. front pistons sequence first, then both front pistons sequence and back pistons sequence, etc.)

        // front pistons sequence
        frontPiston.set(DoubleSolenoid.Value.kForward);
        climbTime.start();
            while(climbTime.get() < 0.1){
                Robot.driveTrain.autoDrive(0.25);
            }
            Robot.driveTrain.autoDrive(0);
        climbTime.reset();
        frontPiston.set(DoubleSolenoid.Value.kReverse);
        backPiston.set(DoubleSolenoid.Value.kForward);

        // back pistons sequence
        climbTime.start();
            while(climbTime.get() < 0.1){
                Robot.driveTrain.autoDrive(0.75);
            }
            Robot.driveTrain.autoDrive(0);
        climbTime.reset();
        backPiston.set(DoubleSolenoid.Value.kReverse);

        // drive on sequence
        climbTime.start();
            while(climbTime.get() < 0.1){
                Robot.driveTrain.autoDrive(0.75);
            }
            Robot.driveTrain.autoDrive(0);
        climbTime.reset();
    }

    public void frontPistonsUp(){
        frontPiston.set(DoubleSolenoid.Value.kForward);
    }

    public void frontPistonsDown(){
        frontPiston.set(DoubleSolenoid.Value.kReverse);
    }

    public void backPistonsUp(){
        backPiston.set(DoubleSolenoid.Value.kForward);
    }

    public void backPistonsDown(){
        backPiston.set(DoubleSolenoid.Value.kReverse);
    }

    @Override
    public void initDefaultCommand() {
    }
}

