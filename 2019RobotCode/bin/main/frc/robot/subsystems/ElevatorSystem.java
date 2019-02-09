/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.*;
import frc.robot.*;

public class ElevatorSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

    static Talon elevatorMotor;
    // define elevator encoder
    // define limit switch
    private static int lowCount;
    private static int midCount;
    private static int highCount;

    public ElevatorSystem() {

        elevatorMotor = new Talon(RobotMap.elevatorPort);    
    
    }

    public void lowLevel(){
        // while(Robot.eleEncoder.get() < RobotMap.lowCount) {
        //     elevatorMotor.set(.5);
        // }
        // while(Robot.eleEncoder.get() > RobotMap.lowCount) {
        //     elevatorMotor.set(-.5);
        // }
    }

    public void midLevel(){
        // while(Robot.eleEncoder.get() < RobotMap.midCount) {
        //     elevatorMotor.set(.5);
        // }
        // while(Robot.eleEncoder.get() > RobotMap.midCount) {
        //     elevatorMotor.set(-.5);
        // }
    }

    public void highLevel(){
        // while(Robot.eleEncoder.get() < RobotMap.highCount) {
        //     elevatorMotor.set(.5);
        // }
        // while(Robot.eleEncoder.get() > RobotMap.highCount) {
        //     elevatorMotor.set(-.5);
        // }
    }

    @Override
    public void initDefaultCommand() {
        // create a command that sets the elevator height back to default
        // setDefaultCommand(new SetElevatorDefault());

        // while(switch.get = false)
        //     elevatorMotor.set(-.7);
        // Robot.eleEncoder.reset();
    }
}

