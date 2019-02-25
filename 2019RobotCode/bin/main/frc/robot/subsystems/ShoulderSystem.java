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

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Shoulder;

/**
 * Add your docs here.
 */
public class ShoulderSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static TalonSRX shoulderMotor;
  static Encoder shoulderEncoder;


  public ShoulderSystem() {
    // define motors
    shoulderMotor = new TalonSRX(RobotMap.shoulderPort);

    // set motors inverted if needed
    shoulderMotor.setInverted(false);

    shoulderMotor.configFactoryDefault();
    shoulderMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
    shoulderMotor.setSensorPhase(true);

  }

  public void printEncoders(){
    int shldrPos = shoulderMotor.getSelectedSensorPosition(0);

    System.out.println("shoulder position: " + shldrPos + " ");
  }
  
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
        while(shoulderEncoder.get() < RobotMap.lowShoulder || shoulderEncoder.get() > RobotMap.lowShoulder) {
            if(shoulderEncoder.get() > RobotMap.lowShoulder) {
                    //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                    //but then again im just an programmer
                shoulderMotor.set(ControlMode.PercentOutput,-RobotMap.shoulderSpeed);
            } else if (shoulderEncoder.get() < RobotMap.lowShoulder) {
                shoulderMotor.set(ControlMode.PercentOutput,RobotMap.shoulderSpeed);
            } else {
                //do nothing
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
        while(shoulderEncoder.get() < RobotMap.midShoulder || shoulderEncoder.get() > RobotMap.midShoulder){
            if(shoulderEncoder.get() > RobotMap.midShoulder){
                    //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                    //but then again im just an programmer
                shoulderMotor.set(ControlMode.PercentOutput,-RobotMap.shoulderSpeed);
            }else if (shoulderEncoder.get() < RobotMap.midShoulder){
                shoulderMotor.set(ControlMode.PercentOutput,RobotMap.shoulderSpeed);
            }else{
                //do nothing
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
    if(s == "climb"){
        while(shoulderEncoder.get() < RobotMap.climbShoulder || shoulderEncoder.get() > RobotMap.climbShoulder){
            if(shoulderEncoder.get() > RobotMap.climbShoulder){
                    //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                    //but then again im just an programmer
                shoulderMotor.set(ControlMode.PercentOutput,-RobotMap.shoulderSpeed);
            }else if (shoulderEncoder.get() < RobotMap.climbShoulder){
                shoulderMotor.set(ControlMode.PercentOutput,RobotMap.shoulderSpeed);
            }else{
                //do nothing
            }
        }
    }
    if(s == "ballPick"){
        while(shoulderEncoder.get() < RobotMap.ballPickShoulder || shoulderEncoder.get() > RobotMap.ballPickShoulder){
            if(shoulderEncoder.get() > RobotMap.ballPickShoulder){
                    //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                    //but then again im just an programmer
                shoulderMotor.set(ControlMode.PercentOutput,-RobotMap.shoulderSpeed);
            }else if (shoulderEncoder.get() < RobotMap.ballPickShoulder){
                shoulderMotor.set(ControlMode.PercentOutput,RobotMap.shoulderSpeed);
            }else{
                //do nothing
            }
        }

    }if(s == "lowBall"){
       
        while(shoulderEncoder.get() < RobotMap.lowBallShoulder || shoulderEncoder.get() > RobotMap.lowBallShoulder){
            if(shoulderEncoder.get() > RobotMap.lowBallShoulder){
                    //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                    //but then again im just an programmer
                shoulderMotor.set(ControlMode.PercentOutput,-RobotMap.shoulderSpeed);
            }else if (shoulderEncoder.get() < RobotMap.lowBallShoulder){
                shoulderMotor.set(ControlMode.PercentOutput,RobotMap.shoulderSpeed);
            }else{
                //do nothing
            }
        }
    
    }if(s == "midBall"){
        while(shoulderEncoder.get() < RobotMap.midBallShoulder || shoulderEncoder.get() > RobotMap.midBallShoulder){
            if(shoulderEncoder.get() > RobotMap.midBallShoulder){
                    //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                    //but then again im just an programmer
                shoulderMotor.set(ControlMode.PercentOutput,-RobotMap.shoulderSpeed);
            }else if (shoulderEncoder.get() < RobotMap.midBallShoulder){
                shoulderMotor.set(ControlMode.PercentOutput,RobotMap.shoulderSpeed);
            }else{
                //do nothing
            }
        }
    }
  }

  public void setShoulder(double speed){
    shoulderMotor.set(ControlMode.PercentOutput, speed);
  }

  public void resetShoulderDefault() {
    // set shoulder to default using encoder count
    shoulderMotor.set(ControlMode.Position, RobotMap.shoulderDefault);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Shoulder());
  }
}
