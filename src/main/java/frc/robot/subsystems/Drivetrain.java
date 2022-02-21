// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.MotorConstants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  // DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(trackWidthMeters)
  WPI_TalonSRX leftFront = new WPI_TalonSRX(MotorConstants.frontLeftID);
  WPI_TalonSRX leftBack = new WPI_TalonSRX(MotorConstants.backLeftID);
  WPI_TalonSRX rightFront = new WPI_TalonSRX(MotorConstants.frontRightID);
  WPI_TalonSRX rightBack = new WPI_TalonSRX(MotorConstants.backRightID);
  SpeedControllerGroup leftDrive = new SpeedControllerGroup(leftBack, leftFront);
  SpeedControllerGroup rightDrive = new SpeedControllerGroup(rightBack, rightFront);
  DifferentialDrive diffdrive = new DifferentialDrive(leftDrive, rightDrive);


  public Drivetrain() {}

  public void turn(Boolean isLeft, double speed){
    DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.robotWithMeters);
    var chassisSpeeds = new ChassisSpeeds(0.0, 0, speed);
    DifferentialDriveWheelSpeeds speeds = kinematics.toWheelSpeeds(chassisSpeeds);
    diffdrive.tankDrive(speeds.leftMetersPerSecond, speeds.rightMetersPerSecond);
  }

  public void drive(double fwdSpeed, double angularV){
    DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.robotWithMeters);
    var chassisSpeeds = new ChassisSpeeds(fwdSpeed, 0, angularV);
    DifferentialDriveWheelSpeeds speeds = kinematics.toWheelSpeeds(chassisSpeeds);
    diffdrive.tankDrive(speeds.leftMetersPerSecond, speeds.rightMetersPerSecond);
  }

  public void stop(){
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
