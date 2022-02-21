// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.DriveCommands.Drive;
import frc.robot.commands.TurretCommands.shoot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;

/** Add your docs here. */
public class RobotContainer {
    private Drivetrain m_drivetrain;
    private Limelight m_limelight;
    private Turret m_turret;
    private Joystick buttonStick;
    private Joystick lefJoystick;
    private Joystick rightJoystick;

    public RobotContainer(){
        // Init classes and subsystems
        m_drivetrain = new Drivetrain();
        m_limelight = new Limelight();
        m_turret = new Turret();

        // Init joysticks
        buttonStick = new Joystick(OIConstants.buttonStickID);
        rightJoystick = new Joystick(OIConstants.rightStickID);
        lefJoystick = new Joystick(OIConstants.leftStickID);

        // set drive commands
        m_drivetrain.setDefaultCommand(new Drive(m_drivetrain, ()->lefJoystick.getY(), ()->rightJoystick.getY()));

        // configure buttons
        configureButtonBindings();
    }

    private void configureButtonBindings(){
        new JoystickButton(buttonStick, OIConstants.shootID).whileHeld(new shoot(m_limelight, m_turret));
    }

    public Command getAutonomousCommand(){
        // return the command used for autonomous
        return null;
    }
}
