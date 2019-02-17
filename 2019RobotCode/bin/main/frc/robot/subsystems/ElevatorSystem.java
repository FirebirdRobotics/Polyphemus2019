/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;

public class ElevatorSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

    static Talon elevatorMotor;
    static Talon shoulderMotor;
    static Talon wristMotor;

    static Encoder eleEncoder;
    static Encoder shoulderEncoder;
    static Encoder wristEncoder;

    //i still dont know if the wrist is gonna be encoded
    // static encoder wristEncoder;
    
    // define elevator encoder
    // define limit switch

    public ElevatorSystem() {

        elevatorMotor = new Talon(RobotMap.elevatorPort);   
        shoulderMotor = new Talon(RobotMap.shoulderPort);
        wristMotor = new Talon(RobotMap.wristPort);

        // 0 and 1 are the port numbers for the two digital inputs and false tells the encoder to not invert the counting direction.

        //if then encoders are counting the wrong way, switch the false to true instead of changing all the < & > operators
        eleEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k2X);
        shoulderEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k2X);
        wristEncoder = new Encoder(4, 5, false, Encoder.EncodingType.k2X);
    }
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
    
        //This WILL NOT RUN yet because no values have been given to the needed encoder thingies in RobotMap
    public void setArm(String s) {

        //this compares the input to the different levels
        //low, mid, hi
        //then runs that part of the if else blocks for it
        //and all of the loops have a bit of tollerance but no more than +- 5 counts, this can and most likely will be adjusted

        if(s == "low") {
            //done?
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
                    elevatorMotor.set(.5);
                } else if(eleEncoder.get() < RobotMap.lowEle) {
                    elevatorMotor.set(-.5);
                } else {
                    //dop nothing, loop will be exited
                }
            }
            while(shoulderEncoder.get() < RobotMap.lowShoulder || shoulderEncoder.get() > RobotMap.lowShoulder) {
                if(shoulderEncoder.get() > RobotMap.lowShoulder) {
                        //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                        //but then again im just an programmer
                    shoulderMotor.set(-.5);
                } else if (shoulderEncoder.get() < RobotMap.lowShoulder) {
                    shoulderMotor.set(.5);
                } else {
                    //do nothing
                }
            }
            while(wristEncoder.get() < RobotMap.lowWrist - 3 || wristEncoder.get() > RobotMap.lowWrist + 3) {
                if(wristEncoder.get() > RobotMap.lowWrist) {
                    //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                    //but then again im just an programmer
                wristMotor.set(-.5);
            } else if (wristEncoder.get() < RobotMap.lowWrist) {
                wristMotor.set(.5);
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

    }else if(s == "mid"){
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
            while(eleEncoder.get() > RobotMap.midEle + 5 || eleEncoder.get() < RobotMap.midEle - 5){
                if(eleEncoder.get() > RobotMap.midEle){
                    elevatorMotor.set(.5);
                }else if(eleEncoder.get() < RobotMap.midEle){
                    elevatorMotor.set(-.5);
                }else{
                    //dop nothing, loop will be exited
                }
            }
            while(shoulderEncoder.get() < RobotMap.midShoulder || shoulderEncoder.get() > RobotMap.midShoulder){
                if(shoulderEncoder.get() > RobotMap.midShoulder){
                        //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                        //but then again im just an programmer
                    shoulderMotor.set(-.5);
                }else if (shoulderEncoder.get() < RobotMap.midShoulder){
                    shoulderMotor.set(.5);
                }else{
                    //do nothing
                }
            }

            while(wristEncoder.get() < RobotMap.midWrist - 3 || wristEncoder.get() > RobotMap.midWrist + 5 ){
                
                    if(wristEncoder.get() > RobotMap.midWrist){
                        //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                        //but then again im just an programmer
                    wristMotor.set(-.5);
                }else if (wristEncoder.get() < RobotMap.midWrist){
                    wristMotor.set(.5);
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
            while(eleEncoder.get() > RobotMap.climbEle + 5 || eleEncoder.get() < RobotMap.climbEle - 5){
                if(eleEncoder.get() > RobotMap.climbEle){
                    elevatorMotor.set(.5);
                }else if(eleEncoder.get() < RobotMap.climbEle){
                    elevatorMotor.set(-.5);
                }else{
                    //dop nothing, loop will be exited
                }
            }
            while(shoulderEncoder.get() < RobotMap.climbShoulder || shoulderEncoder.get() > RobotMap.climbShoulder){
                if(shoulderEncoder.get() > RobotMap.climbShoulder){
                        //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                        //but then again im just an programmer
                    shoulderMotor.set(-.5);
                }else if (shoulderEncoder.get() < RobotMap.climbShoulder){
                    shoulderMotor.set(.5);
                }else{
                    //do nothing
                }
            }

            while(wristEncoder.get() < RobotMap.climbWrist - 3 || wristEncoder.get() > RobotMap.climbWrist + 5 ){
                
                    if(wristEncoder.get() > RobotMap.midWrist){
                        //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                        //but then again im just an programmer
                    wristMotor.set(-.5);
                }else if (wristEncoder.get() < RobotMap.midWrist){
                    wristMotor.set(.5);
                }else{
                    //do nothing
                }
            }
        }
        if(s == "ballPick"){
            while(eleEncoder.get() > RobotMap.ballPickEle + 5 || eleEncoder.get() < RobotMap.ballPickEle - 5){
                if(eleEncoder.get() > RobotMap.ballPickEle){
                    elevatorMotor.set(.5);
                }else if(eleEncoder.get() < RobotMap.ballPickEle){
                    elevatorMotor.set(-.5);
                }else{
                    //dop nothing, loop will be exited
                }
            }
            while(shoulderEncoder.get() < RobotMap.ballPickShoulder || shoulderEncoder.get() > RobotMap.ballPickShoulder){
                if(shoulderEncoder.get() > RobotMap.ballPickShoulder){
                        //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                        //but then again im just an programmer
                    shoulderMotor.set(-.5);
                }else if (shoulderEncoder.get() < RobotMap.ballPickShoulder){
                    shoulderMotor.set(.5);
                }else{
                    //do nothing
                }
            }

            while(wristEncoder.get() < RobotMap.ballPickWrist - 3 || wristEncoder.get() > RobotMap.ballPickWrist + 5 ){
                
                    if(wristEncoder.get() > RobotMap.ballPickWrist){
                        //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                        //but then again im just an programmer
                    wristMotor.set(-.5);
                }else if (wristEncoder.get() < RobotMap.ballPickWrist){
                    wristMotor.set(.5);
                }else{
                    //do nothing
                }
            }
        }if(s == "lowBall"){
            while(eleEncoder.get() > RobotMap.lowBallEle + 5 || eleEncoder.get() < RobotMap.lowBallEle - 5){
                if(eleEncoder.get() > RobotMap.lowBallEle){
                    elevatorMotor.set(.5);
                }else if(eleEncoder.get() < RobotMap.lowBallEle){
                    elevatorMotor.set(-.5);
                }else{
                    //dop nothing, loop will be exited
                }
            }
            while(shoulderEncoder.get() < RobotMap.lowBallShoulder || shoulderEncoder.get() > RobotMap.lowBallShoulder){
                if(shoulderEncoder.get() > RobotMap.lowBallShoulder){
                        //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                        //but then again im just an programmer
                    shoulderMotor.set(-.5);
                }else if (shoulderEncoder.get() < RobotMap.lowBallShoulder){
                    shoulderMotor.set(.5);
                }else{
                    //do nothing
                }
            }

            while(wristEncoder.get() < RobotMap.lowBallWrist - 3 || wristEncoder.get() > RobotMap.lowBallWrist + 5 ){
                
                    if(wristEncoder.get() > RobotMap.lowBallWrist){
                        //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                        //but then again im just an programmer
                    wristMotor.set(-.5);
                }else if (wristEncoder.get() < RobotMap.lowBallWrist){
                    wristMotor.set(.5);
                }else{
                    //do nothing
                }
            }
        
        }if(s == "midBall"){
            while(eleEncoder.get() > RobotMap.midBallEle + 5 || eleEncoder.get() < RobotMap.midBallEle - 5){
                if(eleEncoder.get() > RobotMap.midBallEle){
                    elevatorMotor.set(.5);
                }else if(eleEncoder.get() < RobotMap.midBallEle){
                    elevatorMotor.set(-.5);
                }else{
                    //dop nothing, loop will be exited
                }
            }
            while(shoulderEncoder.get() < RobotMap.midBallShoulder || shoulderEncoder.get() > RobotMap.midBallShoulder){
                if(shoulderEncoder.get() > RobotMap.midBallShoulder){
                        //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                        //but then again im just an programmer
                    shoulderMotor.set(-.5);
                }else if (shoulderEncoder.get() < RobotMap.midBallShoulder){
                    shoulderMotor.set(.5);
                }else{
                    //do nothing
                }
            }

            while(wristEncoder.get() < RobotMap.midBallWrist - 3 || wristEncoder.get() > RobotMap.midBallWrist + 5 ){
                
                    if(wristEncoder.get() > RobotMap.midBallWrist){
                        //this motor holds a lot of weight but seems stable to me, thats why it is fast\
                        //but then again im just an programmer
                    wristMotor.set(-.5);
                }else if (wristEncoder.get() < RobotMap.midBallWrist){
                    wristMotor.set(.5);
                }else{
                    //do nothing
                }
            }
        
        }
    }
 

    @Override
    public void initDefaultCommand() {
        // create a command that sets the elevator height back to default
        // setDefaultCommand(new SetElevatorDefault());

        //just make sure they are all at the bottom, OR starting in the same exact spot before every match and then we will be able to base our encoder counts on those spots
        shoulderEncoder.reset();
        eleEncoder.reset();
    }



}

