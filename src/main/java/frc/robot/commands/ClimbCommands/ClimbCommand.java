// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClimbCommands;

import java.nio.channels.FileChannel.MapMode;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.ClimbConstants;
import frc.robot.subsystems.Climb;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ClimbCommand extends SequentialCommandGroup {
  /** Command to climb */
  public ClimbCommand(Climb climb) {
    addCommands(
      // Retract the solenoids just in case
      new ClimbSetSolenoid(climb, false),
      // Go to the first bar
      new ClimbSetPos(climb, ClimbConstants.firstBarPos),
      // Reel into the bar
      new ClimbSetPos(climb, 0),
      // should be done with bar 1
      // ----------------------------------------------------------------------------
      // set solenoid extended
      new ClimbSetSolenoid(climb, true),
      // extend
      new ClimbSetPos(climb, ClimbConstants.secondBarPos),
      // set solenoid retracted
      new ClimbSetSolenoid(climb, false),
      // Retract climb
      new ClimbSetPos(climb, 0),
      // should be done with bar 2
      // ----------------------------------------------------------------------------
      // set solenoid extended
      new ClimbSetSolenoid(climb, true),
      // extend
      new ClimbSetPos(climb, ClimbConstants.secondBarPos),
      // set solenoid retracted
      new ClimbSetSolenoid(climb, false),
      // Retract climb
      new ClimbSetPos(climb, 0)
      // should be done with bar 3
    );
  }
}
