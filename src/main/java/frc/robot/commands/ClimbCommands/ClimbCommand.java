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
  private Climb climb;
  /** Command to climb */
  public ClimbCommand(Climb climb) {
    this.climb = climb;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      // Retract the solenoids just en case
      new ClimbSetSolenoid(this.climb, false),
      // Go to the first bar
      new ClimbSetPos(this.climb, ClimbConstants.firstBarPos),
      // Reel into the bar
      new ClimbSetPos(this.climb, 0),
      // should be done with bar 1
      // ----------------------------------------------------------------------------
      // Set climb pos a little short of the bar
      new ClimbSetPos(this.climb, ClimbConstants.secondBarPos - 200),
      // set solenoid extended
      new ClimbSetSolenoid(this.climb, true),
      // extend
      new ClimbSetPos(this.climb, ClimbConstants.secondBarPos),
      // Retract climb
      new ClimbSetPos(this.climb, 0),
      // Set climb pos a little short of the next bar
      new ClimbSetPos(this.climb, ClimbConstants.secondBarPos - 200),
      // Set the solenoid back
      new ClimbSetSolenoid(this.climb, false),
      // extend
      new ClimbSetPos(this.climb, ClimbConstants.secondBarPos),
      // Retract climb
      new ClimbSetPos(this.climb, 0),
      // should be done with bar 2
      // ----------------------------------------------------------------------------
      // set solenoid extended
      new ClimbSetSolenoid(this.climb, true),
      // extend
      new ClimbSetPos(this.climb, ClimbConstants.secondBarPos),
      // Retract climb
      new ClimbSetPos(this.climb, 0),
      // Set climb pos a little short of the next bar
      new ClimbSetPos(this.climb, ClimbConstants.secondBarPos - 200),
      // Set the solenoid back
      new ClimbSetSolenoid(this.climb, false),
      // extend
      new ClimbSetPos(this.climb, ClimbConstants.secondBarPos),
      // Retract climb
      new ClimbSetPos(this.climb, 0)
      // should be done
    );
  }
}
