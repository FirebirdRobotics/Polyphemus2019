/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.*;

public class Solenoids extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

    DoubleSolenoid piston;

    public Solenoids(){

        piston = new DoubleSolenoid(RobotMap.pistonIn, RobotMap.pistonOut);

        // elevator = new Talon(RobotMap.elevatorPort);    
    
    }

    public void fire(){

            piston.set(DoubleSolenoid.Value.kForward);
            piston.set(DoubleSolenoid.Value.kReverse);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new FirePiston());
    }
}

