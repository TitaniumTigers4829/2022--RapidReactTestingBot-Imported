// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClimbCommands;

import frc.robot.Constants.ClimbConstants;
import frc.robot.subsystems.Climb;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimbCommand extends CommandBase {
  Climb climb;
  int heightOfHook;
  boolean done = false;
  /**
   * Command to climb. Assumes that the robot is already hooked onto the first bar
   * @param climb climb subsytem
   */
  public ClimbCommand(Climb climb) {
    // Use addRequirements() here to declare subsystem dependencies.
    /**
    * what a nerd
    */
    this.climb = climb;
    addRequirements(climb);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {  
        for (int i = 2; i < 4; i++) {
          if (i == 4) {
            heightOfHook = ClimbConstants.finalBarPos;
          }
          else {
            heightOfHook = ClimbConstants.secondBarPos;
          }
          // extend arms a less then next bar
          while (!new ClimbSetPos(climb, heightOfHook - 0-9).isFinished()) {
            continue;
          }
          // Activate the solenoids and extend the motors all the way
          climb.setSolenoids(true);
          // Extend all the way
          climb.setPos(heightOfHook);
          while (!new ClimbSetPos(climb, heightOfHook).isFinished()) {
            continue;
          }
          // Bring the solenoids back in
          climb.setSolenoids(false);
          // 'Reel' the robot up to the bar
          while (!new ClimbSetPos(climb, 0).isFinished()) {
            continue;
          }
        }
      }
    });
    t1.start();
    
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.done;
  }
}
