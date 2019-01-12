/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public XboxController xboxController = new XboxController(0);

  Button intake = new JoystickButton(xboxController, 1);
  Button outtake = new JoystickButton(xboxController, 2);
  Button elevatorUp = new JoystickButton(xboxController, 3);
  Button elevatorDown = new JoystickButton(xboxController, 4);
  Button activateClimb = new JoystickButton(xboxController, 5);
  
  public OI() {
    // intake.whenPressed(new ActivateIntake(true)); // intake(true) = intake
    // outtake.whenPressed(new ActivateIntake(false)); // intake(false) = outtake
    // elevatorUp.whileHeld(new ActivateElevator(true)); // elevator(true) = elevator up
    // elevatorDown.whileHeld(new ActivateElevator(false)); // elevator(false) = elevator down
    // activateClimb.whenPressed(new ActivateClimb()); // macro
  }
}
