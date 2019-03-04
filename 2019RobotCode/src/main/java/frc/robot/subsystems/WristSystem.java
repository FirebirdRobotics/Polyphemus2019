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
import frc.robot.commands.Wrist;

/**
 * Add your docs here.
 */
public class WristSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static TalonSRX wristMotor;
  static Encoder wristEncoder;

  public WristSystem(){
    // define motors
    wristMotor = new TalonSRX(RobotMap.wristPort);

    // set motors inverted if needed
    wristMotor.setInverted(false);

    wristMotor.configFactoryDefault();
    wristMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
    wristMotor.setSensorPhase(true);
  }

  public void printEncoders(){
    int wrstPos = wristMotor.getSelectedSensorPosition(0);

    System.out.println("shoulder position: " + wrstPos + " ");
  }

  public void setWrist(double speed) {
    wristMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setWristPreset(String s) {

    //this compares the input to the different levels
    //low, mid, hi
    //then runs that part of the if else blocks for it
    //and all of the loops have a bit of tollerance but no more than +- 5 counts, this can and most likely will be adjusted

    if(s == "low") {
        wristMotor.set(ControlMode.Position, RobotMap.lowWrist);
        System.out.println("set wrist to low (encoder value)");
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
        // while(wristEncoder.get() < RobotMap.lowWrist - 3 || wristEncoder.get() > RobotMap.lowWrist + 3) {
        //     if(wristEncoder.get() > RobotMap.lowWrist) {
        //         //this motor holds a lot of weight but seems stable to me, thats why it is fast\
        //         //but then again im just an programmer
        //     wristMotor.set(ControlMode.PercentOutput,-RobotMap.wristSpeed);
        // } else if (wristEncoder.get() < RobotMap.lowWrist) {
        //     wristMotor.set(ControlMode.PercentOutput,RobotMap.wristSpeed);
        // } else {
        //     //do nothing
        // }
        // }
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
    wristMotor.set(ControlMode.Position, RobotMap.midWrist);
    System.out.println("set wrist to mid (encoder value)");
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
    // */
    //     while(wristEncoder.get() < RobotMap.midWrist - 3 || wristEncoder.get() > RobotMap.midWrist + 5 ){
            
    //             if(wristEncoder.get() > RobotMap.midWrist){
    //                 //this motor holds a lot of weight but seems stable to me, thats why it is fast\
    //                 //but then again im just an programmer
    //             wristMotor.set(ControlMode.PercentOutput, -RobotMap.wristSpeed);
    //         }else if (wristEncoder.get() < RobotMap.midWrist){
    //             wristMotor.set(ControlMode.PercentOutput, RobotMap.wristSpeed);
    //         }else{
    //             //do nothing
    //         }
    //     }
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
    else if(s == "climb"){

        // while(wristEncoder.get() < RobotMap.climbWrist - 3 || wristEncoder.get() > RobotMap.climbWrist + 5 ){
            
                /*if(wristEncoder.get() > RobotMap.midWrist){
                    //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                    //but then again im just an programmer
                wristMotor.set(ControlMode.PercentOutput,-RobotMap.wristSpeed);
            }else if (wristEncoder.get() < RobotMap.midWrist){
                wristMotor.set(ControlMode.PercentOutput,RobotMap.wristSpeed);
            }else{
                //do nothing
            }*/
        // }
        wristMotor.set(ControlMode.Position, RobotMap.climbWrist);
        System.out.println("set wrist to climb (encoder value)");
    }
    //add a ("default") for the beginning of the match so we can basically initialize the starting positions for before the match starts
    else if(s == "default"){
        // while(wristEncoder.get() < RobotMap.climbWrist - 3 || wristEncoder.get() > RobotMap.climbWrist + 5 ){
            
        //         if(wristEncoder.get() > RobotMap.midWrist){
        //             //this motor holds a lot of weight but seems stable to me, thats why it is fast\
        //             //but then again im just an programmer
        //         wristMotor.set(ControlMode.PercentOutput,-RobotMap.wristSpeed);
        //     }else if (wristEncoder.get() < RobotMap.midWrist){
        //         wristMotor.set(ControlMode.PercentOutput,RobotMap.wristSpeed);
        //     }else{
        //         //do nothing
        //     }
        // }
        wristMotor.set(ControlMode.Position, RobotMap.defaultWrist);
        System.out.println("set wrist to default (encoder value)");
    } else if(s == "ballPick") {

        // while(wristEncoder.get() < RobotMap.ballPickWrist - 3 || wristEncoder.get() > RobotMap.ballPickWrist + 5 ){
            
            /*    if(wristEncoder.get() > RobotMap.ballPickWrist){
                    //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                    //but then again im just an programmer
                wristMotor.set(ControlMode.PercentOutput,-RobotMap.wristSpeed);
            }else if (wristEncoder.get() < RobotMap.ballPickWrist){
                wristMotor.set(ControlMode.PercentOutput,RobotMap.wristSpeed);
            }else{
                //do nothing
            }
            */
        // }
        wristMotor.set(ControlMode.Position, RobotMap.ballPickWrist);
        System.out.println("set wrist to ballPick (encoder value)");
    } else if(s == "lowBall") {

        // while(wristEncoder.get() < RobotMap.lowBallWrist - 3 || wristEncoder.get() > RobotMap.lowBallWrist + 5 ){
            /*
                if(wristEncoder.get() > RobotMap.lowBallWrist){
                    //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                    //but then again im just an programmer
                wristMotor.set(ControlMode.PercentOutput,-RobotMap.wristSpeed);
            }else if (wristEncoder.get() < RobotMap.lowBallWrist){
                wristMotor.set(ControlMode.PercentOutput,RobotMap.wristSpeed);
            }else{
                //do nothing
            }
            */
        // }
        wristMotor.set(ControlMode.Position, RobotMap.lowBallWrist);
        System.out.println("set wrist to lowBall (encoder value)");
    } else if(s == "midBall") {
        // while(wristEncoder.get() < RobotMap.midBallWrist - 3 || wristEncoder.get() > RobotMap.midBallWrist + 5 ){
            
        //    /*     if(wristEncoder.get() > RobotMap.midBallWrist){
        //             //this motor holds a lot of weight but seems stable to me, thats why it is fast\
        //             //but then again im just an programmer
        //         wristMotor.set(ControlMode.PercentOutput,-RobotMap.wristSpeed);
        //     }else if (wristEncoder.get() < RobotMap.midBallWrist){
        //         wristMotor.set(ControlMode.PercentOutput,RobotMap.wristSpeed);
        //     }else{
        //         //do nothing
         
        //     }
            
        // */}
        
        wristMotor.set(ControlMode.Position, RobotMap.midBallWrist);
        System.out.println("set wrist to midBall (encoder value)");
      }
    }

  public void resetWristDefault() {
    // set wrist to default using encoder count
    wristMotor.set(ControlMode.Position, RobotMap.defaultWrist);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Wrist());
  }
}
