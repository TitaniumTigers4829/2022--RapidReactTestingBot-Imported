// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands.TurretCommands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.Limelight;
// import frc.robot.subsystems.Turret;

// public class shoot extends CommandBase {
//   private Limelight _limelight;
//   private Turret _turret;
//   /** The command to shoot at the target.. Who would have guessed?
//    * @param limelight an instance of the Limelight class
//    * @param turret an instance of the Turret class
//    */
//   public shoot(Limelight limelight, Turret turret) {
//     // Use addRequirements() here to declare subsystem dependencies.
//     _limelight = limelight;
//     _turret = turret;
//     addRequirements(limelight, turret);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     double angle = _limelight.calculateAngle(_limelight.calculateDistance());
//     _turret.setTurretAngle(angle);
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     _turret.shoot();
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     _turret.stopShooting();
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
