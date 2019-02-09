import edu.wpi.first.wpilibj.command.Subsystem;


public class pivot extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  //TWO MOTORS
  //INVERT THEM

    public void pivArm(double speed){
        /*
            leftPivot.set(speed);
            rightPivot.set(-speed)
        */
    }
  public void lowPivot(){
    /*
            if(Robot.pivEncoder.get() < RobotMap.pivotLowCount){
                while(Robot.pivEncoder.get() < RobotMap.pivotLowCount){
                    pivArm(.5);
                }
            }else if(Robot.pivEncoder.get() > RobotMap.pivotLowCount){
                while(Robot.pivEncoder.get() > RobotMap.pivotLowCount){
                    pivArm(-.5);
                }else{
                //do nothing
            }
        */

  }

  public void midPivot(){
    /*
            if(Robot.pivEncoder.get() < RobotMap.pivotMidCount){
                while(Robot.pivEncoder.get() < RobotMap.pivotMidCount){
                    pivArm(.5);
                }
            }else if(Robot.pivEncoder.get() > RobotMap.pivotMidCount){
                while(Robot.pivEncoder.get() > RobotMap.pivotMidCount){
                    pivArm(-.5);
                }else{
                //do nothing
            }
        
            if(Robot.pivEncoder.get() < RobotMap.pivotMidCount){
                while(Robot.pivEncoder.get() < RobotMap.pivotMidCount)
                    pivArm(.5);
                }
            }else if(Robot.pivEncoder.get() > RobotMap.pivotMidCount){
                while(Robot.pivEncoder.get() > RobotMap.pivotMidCount)
                    pivArm(-.5);
                }else{
                //do nothing
            }
        */
  }

  public void highPivot(){
    /*
            if(Robot.pivEncoder.get() < RobotMap.pivotHighCount){
                while(Robot.pivEncoder.get() < RobotMap.pivotHighCount){
                    pivArm(.5);
                }
            }else if(Robot.pivEncoder.get() > RobotMap.pivotHighCount){
                while(Robot.pivEncoder.get() > RobotMap.pivotHighCount){
                    pivArm(-.5);
                }else{
                //do nothing
            }
        
            if(Robot.pivEncoder.get() < RobotMap.pivotHighCount){
                while(Robot.pivEncoder.get() < RobotMap.pivotHighCount)
                    pivArm(.5);
                }
            }else if(Robot.pivEncoder.get() > RobotMap.pivotHighCount){
                while(Robot.pivEncoder.get() > RobotMap.pivotHighCount)
                    pivArm(-.5);
                }else{
                //do nothing
            }
        */

  }

  public void init(){
    /*
     while(pivSwitch == false){
        pivArm(-.5);
     }
     pivEncoder.reset();
    */
    }

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    init();
  }
}