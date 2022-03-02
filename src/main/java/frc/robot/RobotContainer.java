// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ClimbCommands.ManualForValues;
import frc.robot.commands.ClimbCommands.ResetClimbPos;
import frc.robot.subsystems.Climb;
import frc.robot.commands.ClimbCommands.ManualForValues;
// import frc.robot.commands.TurretCommands.shoot;
import frc.robot.subsystems.Limelight;
// import frc.robot.subsystems.Turret;

/** Add your docs here. */
public class RobotContainer {
    // private Limelight m_limelight;
    // private Turret m_turret;
    private Climb climb;

    private Joystick controller;
    // private Joystick buttonStick;
    // private Joystick lefJoystick;
    // private Joystick rightJoystick;

    public RobotContainer(){
        // Init classes and subsystems
        // m_limelight = new Limelight();
        // m_turret = new Turret();
        climb = new Climb();

        // Init joysticks
        // buttonStick = new Joystick(OIConstants.buttonStickID);
        // rightJoystick = new Joystick(OIConstants.rightStickID);
        // lefJoystick = new Joystick(OIConstants.leftStickID);
        controller = new Joystick(0);

        new JoystickButton(controller, 2).toggleWhenPressed(new ManualForValues(climb, ()->controller.getRawAxis(1)));
        new JoystickButton(controller, 1).whenPressed(new ResetClimbPos(climb));

        // configure buttons
        configureButtonBindings();
    }

    private void configureButtonBindings(){
        //new JoystickButton(buttonStick, OIConstants.shootID).whileHeld(new shoot(m_limelight, m_turret));
    }

    public Command getAutonomousCommand(){
        // return the command used for autonomous
        return null;
    }
}
