// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClimbCommands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class Manual extends CommandBase {
  private Climb climb;
  private DoubleSupplier leftSpeed, rightSpeed;
  private BooleanSupplier solenoids;
  /** Creates a new ManualForValues. */
  public Manual(Climb climb, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed, BooleanSupplier solenoids) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.climb = climb;
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
    this.solenoids = solenoids;
    addRequirements(climb);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climb.setLeftSpeed(leftSpeed.getAsDouble());
    climb.setRightSpeed(rightSpeed.getAsDouble());
    //climb.setSolenoids(solenoids.getAsBoolean());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climb.setLeftSpeed(0);
    climb.setRightSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
