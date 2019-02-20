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
        
            frontPiston.set(DoubleSolenoid.Value.kForward);
             climbTime.start();
                while(climbTime.get() < 2){
                    Robot.driveTrain.autoDrive(.2);
                }
             climbTime.reset();
            frontPiston.set(DoubleSolenoid.Value.kReverse);

            backPiston.set(DoubleSolenoid.Value.kForward);
             climbTime.start();
                while(climbTime.get() < 2){
                    Robot.driveTrain.autoDrive(.2);
                }
            //  climbTime.stop();
            backPiston.set(DoubleSolenoid.Value.kReverse);
            while(climbTime.get() < 2){
             Robot.driveTrain.autoDrive(.2);
            }
            Robot.driveTrain.autoDrive(0);
    }

    public void frontPistonsUp(){
        frontPiston.set(DoubleSolenoid.Value.kForward);
    }

    @Override
    public void initDefaultCommand() {
    }
}

