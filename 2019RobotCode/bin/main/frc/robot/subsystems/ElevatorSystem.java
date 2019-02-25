/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.Shoulder;
import frc.robot.commands.Wrist;


//Look at TalonSRX set(ControlMode.Position, EncoderTicks); !!!! asdlkfnbsdxlkfvnlxskdncvx lkzdnvxclk 
public class ElevatorSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

    public static TalonSRX elevatorMotor;

    public DigitalInput elevatorState;

    static Encoder eleEncoder;

    public ElevatorSystem() {
        // define motors
        elevatorMotor = new TalonSRX(RobotMap.elevatorPort);   

        // create DigitalInput
        elevatorState = new DigitalInput(RobotMap.elevatorPort);

        // set motors inverted if needed
        elevatorMotor.setInverted(true);

        // 0 and 1 are the port numbers for the two digital inputs and false tells the encoder to not invert the counting direction.
        //if then encoders are counting the wrong way, switch the false to true instead of changing all the < & > operators
       
        elevatorMotor.configFactoryDefault();

        // initQuadrature();

        elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);

        elevatorMotor.setSensorPhase(true);
    }

    public void printEncoders(){
        int elePos = elevatorMotor.getSelectedSensorPosition(0);
    
        System.out.println("elevator Position: " + elePos + " ");
    }
    
    
        // public void initQuadrature() {
        //     /* get the absolute pulse width position */
        //     int pulseWidth = elevatorMotor.getSensorCollection().getPulseWidthPosition();
    
        //     /**
        //      * If there is a discontinuity in our measured range, subtract one half
        //      * rotation to remove it
        //      */
        //     if (kDiscontinuityPresent) {
    
        //         /* Calculate the center */
        //         int newCenter;
        //         newCenter = (kBookEnd_0 + kBookEnd_1) / 2;
        //         newCenter &= 0xFFF;
    
        //         /**
        //          * Apply the offset so the discontinuity is in the unused portion of
        //          * the sensor
        //          */
        //         pulseWidth -= newCenter;
        //     }
    
        //     /**
        //      * Mask out the bottom 12 bits to normalize to [0,4095],
        //      * or in other words, to stay within [0,360) degrees 
        //      */
        //     pulseWidth = pulseWidth & 0xFFF;
    
        //     /* Update Quadrature position */
        //     elevatorMotor.getSensorCollection().setQuadraturePosition(pulseWidth, RobotMap.kTimeoutMs);
        // }
    //im going to write one method with an input @PARAMETER string 
    //that is going to be used to determine what level it is

    /*
     _____
     |   |     ----------3
     |   |   /  2         \
     |   |  /              ----         //btw im not of good as a text artist as brandon 
     |   | /              |    |        //but i wanted this year to help visualize
  0  |   |1
    */
//0 - elevator
//1 - shoulder
//2 - elbow *    has 2 motors :((((     * ...will figure out l8r...
//3 wrist hopefully one motor
//i wanna die ya, still do

public void setElevator(double speed){
    elevatorMotor.set(ControlMode.PercentOutput, speed);
}

//This WILL NOT RUN yet because no values have been given to the needed encoder thingies in RobotMap
    public void setArm(String s) {

        //this compares the input to the different levels
        //low, mid, hi
        //then runs that part of the if else blocks for it
        //and all of the loops have a bit of tollerance but no more than +- 5 counts, this can and most likely will be adjusted

        if(s == "low") {
            // done?
            /*
            test list for low:
            elevator below needed with 
                shoudler above and elbow above
                shoudler above and elbow below
                shoulder below and elbow above
                shoudler below and elbow below
            elevator above with
                shoudler above and elbow above
                shoudler above and elbow below
                shoulder below and elbow above
                shoudler below and elbow below
            */
            while(eleEncoder.get() > RobotMap.lowEle + 5 || eleEncoder.get() < RobotMap.lowEle - 5) {
                if(eleEncoder.get() > RobotMap.lowEle) {
                    elevatorMotor.set(ControlMode.PercentOutput, RobotMap.eleSpeed);
                } else if(eleEncoder.get() < RobotMap.lowEle) {
                    elevatorMotor.set(ControlMode.PercentOutput,-RobotMap.eleSpeed);
                }
            }
           /* while(elbowEncoder.get() < RobotMap.lowElbow - 3 || elbowEncoder.get() > RobotMap.lowElbow +3){
                if(elbowEncoder.get() < RobotMap.lowElbow){
                    elbowMotor.set(.3);
                }else if(elbowEncoder.get() > RobotMap.lowElbow){
                    elbowMotor.set(-.3);
                }else{
                    //do nothing
                }
             }*/

    } else if(s == "mid") {
        /*
        test list for mid:
            elevator below needed with 
                shoudler above and elbow above
                shoudler above and elbow below
                shoulder below and elbow above
                shoudler below and elbow below
            elevator above with
                shoudler above and elbow above
                shoudler above and elbow below
                shoulder below and elbow above
                shoudler below and elbow below
        */
            while(eleEncoder.get() > RobotMap.midEle + 5 || eleEncoder.get() < RobotMap.midEle - 5) {
                if(eleEncoder.get() > RobotMap.midEle) {
                    elevatorMotor.set(ControlMode.PercentOutput,RobotMap.eleSpeed);
                } else if(eleEncoder.get() < RobotMap.midEle) {
                    elevatorMotor.set(ControlMode.PercentOutput,-RobotMap.eleSpeed);
                }
            }
           /* while(elbowEncoder.get() < RobotMap.midElbow - 3 || elbowEncoder.get() > RobotMap.midElbow +3){
                if(elbowEncoder.get() < RobotMap.midElbow){
                    elbowMotor.set(.3);
                }else if(elbowEncoder.get() > RobotMap.midElbow){
                    elbowMotor.set(-.3);
                }else{
                    //do nothing
                }
            }*/
        }

        //High is commented out cuz, well, we dont have it anymore

        // if(s == "hi"){

        // /*
        //     test list for hi:
        //     elevator below needed with 
        //         shoudler above and elbow above
        //         shoudler above and elbow below
        //         shoulder below and elbow above
        //         shoudler below and elbow below
        //     elevator above with
        //         shoudler above and elbow above
        //         shoudler above and elbow below
        //         shoulder below and elbow above
        //         shoudler below and elbow below
        // */
        //     while(eleEncoder.get() > RobotMap.hiEle + 5 || eleEncoder.get() < RobotMap.hiEle - 5){
        //         if(eleEncoder.get() > RobotMap.hiEle){
        //             elevatorMotor.set(.5);
        //         }else if(eleEncoder.get() < RobotMap.hiEle){
        //             //i dont think this case will ever happen but idk yet ?!?!?!?!
        //             elevatorMotor.set(-.5);
        //         }else{
        //             //dop nothing, loop will be exited
        //         }
        //     }
        //     while(shoulderEncoder.get() < RobotMap.hiShoulder || shoulderEncoder.get() > RobotMap.hiShoulder){
        //         if(shoulderEncoder.get() > RobotMap.hiShoulder){
        //                 //this motor holds a lot of weight but seems stable to me, thats why it is fast\
        //                 //but then again im just an programmer
        //             shoulderMotor.set(-.5);
        //         }else if (shoulderEncoder.get() < RobotMap.hiShoulder){
        //             shoulderMotor.set(.5);
        //         }else{
        //             //do nothing
        //         }
        //     }
            
        //    /* while(elbowEncoder.get() < RobotMap.hiElbow - 3 || elbowEncoder.get() > RobotMap.hiElbow +3){
        //         if(elbowEncoder.get() < RobotMap.hiElbow){
        //             elbowMotor.set(.3);
        //         }else if(elbowEncoder.get() > RobotMap.hiElbow){
        //             elbowMotor.set(-.3);
        //         }else{
        //             //do nothing
        //         }
        //     }*/
        // }
        //add a ("climb") so that we can put ele low, shoudler up, elbow down
        //^^^ will makes the Center of gravity as close to the bottom and middle as possible
        if(s == "climb") {
            while(eleEncoder.get() > RobotMap.climbEle + 5 || eleEncoder.get() < RobotMap.climbEle - 5) {
                if(eleEncoder.get() > RobotMap.climbEle) {
                    elevatorMotor.set(ControlMode.PercentOutput,RobotMap.eleSpeed);
                } else if(eleEncoder.get() < RobotMap.climbEle) {
                    elevatorMotor.set(ControlMode.PercentOutput,-RobotMap.eleSpeed);
                }
            }
        }
        if(s == "ballPick") {
            while(eleEncoder.get() > RobotMap.ballPickEle + 5 || eleEncoder.get() < RobotMap.ballPickEle - 5) {
                if(eleEncoder.get() > RobotMap.ballPickEle) {
                    elevatorMotor.set(ControlMode.PercentOutput,RobotMap.eleSpeed);
                } else if(eleEncoder.get() < RobotMap.ballPickEle) {
                    elevatorMotor.set(ControlMode.PercentOutput,-RobotMap.eleSpeed);
                }
            }
        } 
        if(s == "lowBall") {
            while(eleEncoder.get() > RobotMap.lowBallEle + 5 || eleEncoder.get() < RobotMap.lowBallEle - 5) {
                if(eleEncoder.get() > RobotMap.lowBallEle) {
                    elevatorMotor.set(ControlMode.PercentOutput,RobotMap.eleSpeed);
                } else if(eleEncoder.get() < RobotMap.lowBallEle) {
                    elevatorMotor.set(ControlMode.PercentOutput,-RobotMap.eleSpeed);
                }
            }
        }
        if(s == "midBall") {
            while(eleEncoder.get() > RobotMap.midBallEle + 5 || eleEncoder.get() < RobotMap.midBallEle - 5) {
                if(eleEncoder.get() > RobotMap.midBallEle) {
                    elevatorMotor.set(ControlMode.PercentOutput,RobotMap.eleSpeed);
                } else if(eleEncoder.get() < RobotMap.midBallEle) {
                    elevatorMotor.set(ControlMode.PercentOutput,-RobotMap.eleSpeed);
                }
            }
        }
    }

    public void resetElevatorDefault() {
        // set elevator to default using encoder count
        elevatorMotor.set(ControlMode.Position, RobotMap.elevatorDefault);
    }

    @Override
    public void initDefaultCommand() {
    }
}

