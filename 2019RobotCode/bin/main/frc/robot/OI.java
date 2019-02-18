/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/*
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public XboxController xboxControllerOne = new XboxController(1);
  public XboxController xboxControllerTwo = new XboxController(2);

  // xbox controller one
  // left joystick = drive
  // Button climb = new JoystickButton(xboxControllerOne, 7); // Back button
  // Button bumpLeft = new JoystickButton(xboxControllerOne, 5); // Left bumper
  // Button bumpRight = new JoystickButton(xboxControllerOne, 6); // Right bumper
  // Button cargoVisionRoutine = new JoystickButton(xboxControllerOne, xboxControllerOne.getAxisType(2)); // Left trigger
  // Button tapeVisionRoutine = new JoystickButton(xboxControllerOne, xboxControllerOne.getAxisType(3)); // Right trigger

  // xbox controller two
  // left joystick = arm
  // right joystick = wrist
  // Button clawOut = new JoystickButton(xboxControllerTwo, xboxControllerTwo.getAxisType(3)); // Right trigger
  // Button clawIn = new JoystickButton(xboxControllerTwo, xboxControllerTwo.getAxisType(2)); // Left trigger
  // Button eleDown = new JoystickButton(xboxControllerTwo, 5); // Left bumper
  // Button eleUp = new JoystickButton(xboxControllerTwo, 6); // Right bumper
  // Button hatchLowMacro = new JoystickButton(xboxControllerTwo, 1); // A button
  // Button hatchMiddleMacro = new JoystickButton(xboxControllerTwo, 2); // B button
  // Button hatchStationPickupMacro = new JoystickButton(xboxControllerTwo, 3); // X button
  // Button releaseHatchMacro = new JoystickButton(xboxControllerTwo, 4); // Y button


  // -------------------------

  Button eleDownBut = new JoystickButton(xboxControllerOne, 1); // A button
  Button eleUpBut = new JoystickButton(xboxControllerOne, 2); // B button

  Button shoulderDownBut = new JoystickButton(xboxControllerOne, 3); // X button
  Button shoulderUpBut = new JoystickButton(xboxControllerOne, 4); // Y button

  Button wristUpBut = new JoystickButton(xboxControllerOne, 5); // Left bumper
  Button wristDownBut = new JoystickButton(xboxControllerOne, 6); // Right bumper

  Button openBut = new JoystickButton(xboxControllerOne, 7); // Back button
  Button closeBut = new JoystickButton(xboxControllerOne, 8); // Start button

  // --------------------------

  // Button hatchLowMacro = new JoystickButton(xboxControllerOne, 1); // A button
  // Button hatchMiddleMacro = new JoystickButton(xboxControllerOne, 2); // B button
  // Button pickupCargo = new JoystickButton(xboxControllerOne, 3); // X button
  // Button pickupHatchLoadStation = new JoystickButton(xboxControllerOne, 4); // Y button
  // Button cargoVisionRoutine = new JoystickButton(xboxControllerOne, 5); // Left bumper
  // Button tapeVisionRoutine = new JoystickButton(xboxControllerOne, 6); // Right bumper
  // Button backButton = new JoystickButton(xboxControllerOne, 7); // Back button
  // Button climbButton = new JoystickButton(xboxControllerOne, 8); // Start button
  
  public OI() {
    eleDownBut.whileHeld(new eleDown());
    eleUpBut.whileHeld(new eleUp());
    shoulderUpBut.whileHeld(new shoulderUp());
    shoulderDownBut.whileHeld(new shoulderDown());
    wristUpBut.whileHeld(new wristUp());
    wristDownBut.whileHeld(new wristDown());
    openBut.whileHeld(new openClaw());
    closeBut.whileHeld(new closeClaw());

    // hatchLowMacro.whenPressed(new PlaceHatchLowMacro());
    // hatchMiddleMacro.whenPressed(new PlaceHatchMiddleMacro());
    // cargoVisionRoutine.whenPressed(new CargoVisionRoutine());
    // tapeVisionRoutine.whenPressed(new TapeVisionRoutine());
    // climbButton.whenPressed(new Climb());
  }
}