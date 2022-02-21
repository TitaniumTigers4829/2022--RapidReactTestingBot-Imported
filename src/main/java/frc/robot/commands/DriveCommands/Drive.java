// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveCommands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
  /** Creates a new Drive. */
  private final Drivetrain m_Drivetrain;
  private DoubleSupplier _fwdSpeed, _angularSpeed;
  public Drive(Drivetrain drivetrain, DoubleSupplier fwdSpeed, DoubleSupplier angularSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Drivetrain = drivetrain;
    _fwdSpeed = fwdSpeed;
    _angularSpeed = angularSpeed;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Drivetrain.drive(_fwdSpeed.getAsDouble(), _angularSpeed.getAsDouble());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drivetrain.drive(_fwdSpeed.getAsDouble(), _angularSpeed.getAsDouble());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
