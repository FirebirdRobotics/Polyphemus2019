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
import frc.robot.commands.*;


public class Solenoids extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

    DoubleSolenoid frontPiston;
    DoubleSolenoid backPiston;
    Timer climbTime;
    


    public Solenoids(){

        frontPiston = new DoubleSolenoid(RobotMap.frontIn, RobotMap.frontOut);
        backPiston = new DoubleSolenoid(RobotMap.backIn, RobotMap.backOut);
        climbTime = new Timer();
      
        // elevator = new Talon(RobotMap.elevatorPort);    
    
    }

    public void climb(){
        
            frontPiston.set(DoubleSolenoid.Value.kForward);
             climbTime.start();
                while(climbTime.get()< 3){
                    Robot.driveTrain.autoDrive(.2);
                }
             climbTime.reset();
            frontPiston.set(DoubleSolenoid.Value.kReverse);

            backPiston.set(DoubleSolenoid.Value.kForward);
             climbTime.start();
                while(climbTime.get()< 3){
                    Robot.driveTrain.autoDrive(.2);
                }
            backPiston.set(DoubleSolenoid.Value.kReverse);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new FirePiston());
    }
}

