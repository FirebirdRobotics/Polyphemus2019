/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
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
  Button climb = new JoystickButton(xboxControllerOne, 7); // Back button
  Button startDriveOff = new JoystickButton(xboxControllerOne, 8); // Start button
  Button bumpLeft = new JoystickButton(xboxControllerOne, 5); // Left bumper
  Button bumpRight = new JoystickButton(xboxControllerOne, 6); // Right bumper
  Button tapeVisionButton = new JoystickButton(xboxControllerOne, 3); // X button
  Button cargoVisionButton = new JoystickButton(xboxControllerOne, 4); // Y button
  // (temporary, for testing)
  Button frontPistons = new JoystickButton(xboxControllerOne, 1); // A button
  Button backPistons = new JoystickButton(xboxControllerOne, 2); // B button
  
  // xbox controller two
  Button eleDown = new JoystickButton(xboxControllerTwo, 5); // Left bumper
  Button eleUp = new JoystickButton(xboxControllerTwo, 6); // Right bumper
  Button hatchLowMacro = new JoystickButton(xboxControllerTwo, 1); // A button
  Button hatchMiddleMacro = new JoystickButton(xboxControllerTwo, 2); // B button
  Button hatchStationPickupMacro = new JoystickButton(xboxControllerTwo, 3); // X button
  Button releaseHatchMacro = new JoystickButton(xboxControllerTwo, 4); // Y button
  
  public OI() {
    // xbox controller one
    climb.whenPressed(new Climb());
    startDriveOff.whenPressed(new StartDriveOff());
    bumpLeft.whenPressed(new BumpLeft());
    bumpRight.whenPressed(new BumpRight());
    tapeVisionButton.whenPressed(new TapeVisionRoutine());
    cargoVisionButton.whenPressed(new CargoVisionRoutine());
    // (temporary, for testing)
    frontPistons.whenPressed(new FrontPistonsToggle());
    backPistons.whenPressed(new BackPistonsToggle());

    // xbox controller two
    eleDown.whileHeld(new EleDown());
    eleUp.whileHeld(new EleUp());
    hatchLowMacro.whenPressed(new PlaceHatchLowMacro());
    hatchMiddleMacro.whenPressed(new PlaceHatchMiddleMacro());
    hatchStationPickupMacro.whenPressed(new PickupHatchStationMacro());
    releaseHatchMacro.whenPressed(new ReleaseHatchMacro());
  }
}