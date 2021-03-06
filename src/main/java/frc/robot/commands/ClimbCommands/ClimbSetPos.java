// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class ClimbSetPos extends CommandBase {
  
  public int motorPos;
  private final Climb climb;

  /** Creates a new ClimbSetPos. */
  public ClimbSetPos(Climb climb, int motorPos) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.climb = climb;
    this.motorPos = motorPos;
    addRequirements(climb);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    climb.setPos(motorPos);
    SmartDashboard.putBoolean("Climb Pos Running", true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climb.setPos(motorPos);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putBoolean("Climb Pos Running", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    SmartDashboard.putNumberArray("FInished encoder position", climb.getBothPositions());
    return Math.abs(climb.getPosition() - motorPos) <= 10;
  }
}
