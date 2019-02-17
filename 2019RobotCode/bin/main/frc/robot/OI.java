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
  public XboxController xboxController = new XboxController(1);

  Button hatchLowMacro = new JoystickButton(xboxController, 1); // A button
  Button hatchMiddleMacro = new JoystickButton(xboxController, 2); // B button
  Button hatchHighMacro = new JoystickButton(xboxController, 4); // Y button
  Button climbButton = new JoystickButton(xboxController, 6); // RB button
  Button visionButton = new JoystickButton(xboxController, 3); // X button

  // Button toggleDriveOrientation = new JoystickButton(xboxController, 8); // start button, which isn't available for some reason
  
  public OI() {
    hatchLowMacro.whenPressed(new PlaceHatchLowMacro());
    hatchMiddleMacro.whenPressed(new PlaceHatchMiddleMacro());
    hatchHighMacro.whenPressed(new PlaceHatchHighMacro());
    climbButton.whenPressed(new Climb());
    visionButton.whenReleased(new VisionRoutine());
	  
    // toggleDriveOrientation.whenPressed(new InstantCommand() {
		// 	@Override
		// 	protected void initialize() {
		// 		RobotMap.orientForward = !RobotMap.orientForward;
		// 	}
    // });
    
  }
}