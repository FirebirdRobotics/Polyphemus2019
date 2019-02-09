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

    static Talon elevator;
    private static int lowCount;
    private static int midCount;
    private static int highCount;

    public ElevatorSystem(){

        elevator = new Talon(RobotMap.elevatorPort);    
    
    }

    public void lowLevel(){
        /*
            if(Robot.eleEncoder.get() < RobotMap.lowCount){
                while(Robot.eleEncoder.get() < RobotMap.lowCount){
                    elevatorMotor.set(.5);
                }
            }else if(Robot.eleEncoder.get() > RobotMap.lowCount)){
                while(Robot.eleEncoder.get() > RobotMap.lowCount)
                elevatorMotor.set(-.5);
            }else{
                //do nothing
            }
        */

    }

    public void midLevel(){
        /*
            if(Robot.eleEncoder.get() < RobotMap.midCount){
                while(Robot.eleEncoder.get() < RobotMap.midCount){
                    elevatorMotor.set(.5);
                }
            }else if(Robot.eleEncoder.get() > RobotMap.midCount)){
                while(Robot.eleEncoder.get() > RobotMap.midCount)
                elevatorMotor.set(-.5);
            }else{
                //do nothing
            }
        */
    }

    public void highLevel(){
        /*
            if(Robot.eleEncoder.get() < RobotMap.highCount){
                while(eleEncoder.get() < RobotMap.highCount){
                    elevatorMotor.set(.5);
                }
            }else if(Robot.eleEncoder.get() > RobotMap.highCount)){
                while(Robot.eleEncoder.get() > RobotMap.highCount)
                elevatorMotor.set(-.5);
            }else{
                //do nothing
            }
        */
    }
    @Override
    public void initDefaultCommand() {
        // create a command that sets the elevator height back to default
        // setDefaultCommand(new SetElevatorDefault());

        /*

            while(switch.get  = false)
                elevatorMotor.set(-.7);
            Robot.eleEncoder.Reset();

        */
    }
}

