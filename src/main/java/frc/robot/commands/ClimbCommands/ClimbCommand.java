// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.ClimbConstants;
import frc.robot.subsystems.Climb;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ClimbCommand extends SequentialCommandGroup {
  /** Command to climb */
  public ClimbCommand(Climb climb) {
    // Starts assuming the telescoping arms are slightly above the first bar
    addCommands(
      // Reel into the bar
      new ClimbSetPos(climb, 0),
      // should be done with bar 1
      // static hooks click
      // ----------------------------------------------------------------------------
      // extends a little
      new ClimbSetPos(climb, ClimbConstants.slightlyExtended),
      // set solenoid extended
      new ClimbSetSolenoid(climb, false),
      // extend
      new ClimbSetPos(climb, ClimbConstants.secondBarPos),
      // set solenoid retracted
      new ClimbSetSolenoid(climb, true),
      // Retract climb
      new ClimbSetPos(climb, 0),
      // should be done with bar 2
      // static hooks click
      // ----------------------------------------------------------------------------
      // extends a little
      new ClimbSetPos(climb, ClimbConstants.slightlyExtended),
      // set solenoid extended
      new ClimbSetSolenoid(climb, false),
      // extend
      new ClimbSetPos(climb, ClimbConstants.secondBarPos),
      // set solenoid retracted
      new ClimbSetSolenoid(climb, true),
      // Retract climb
      new ClimbSetPos(climb, 0)
      // should be done with bar 3
      // yay we finished climb
    );
  }
}
