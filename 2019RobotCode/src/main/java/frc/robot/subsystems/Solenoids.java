/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
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
        

        //THIS TOO
            //will add a climb section which pulls shoulder up and elbow in with ele low
            // ele.setArm("climb");    

            // assuming we're starting touching the front of the level 2 platform:
            // front pistons down
            // drive forward for about 1 (?) second, get front wheels on platform
            // STOP DRIVETRAIN
            // back pistons down
            // front pistons up
            // drive forward for about 2 (?) seconds, get middle wheels on platform
            // STOP DRIVETRAIN
            // back pistons up
            // drive forward for about 2 (?) second, get back wheels on platform

            // front pistons sequence
            frontPiston.set(DoubleSolenoid.Value.kForward);
            climbTime.start();
                while(climbTime.get() < 0.35){
                    Robot.driveTrain.autoDrive(0.25);
                }
                Robot.driveTrain.autoDrive(0);
            climbTime.reset();
            frontPiston.set(DoubleSolenoid.Value.kReverse);
            backPiston.set(DoubleSolenoid.Value.kForward);

            // back pistons sequence
            climbTime.start();
                while(climbTime.get() < 0.45){
                    Robot.driveTrain.autoDrive(0.75);
                }
                Robot.driveTrain.autoDrive(0);
            climbTime.reset();
            backPiston.set(DoubleSolenoid.Value.kReverse);

            // drive on sequence
            climbTime.start();
                while(climbTime.get() < 0.6){
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

