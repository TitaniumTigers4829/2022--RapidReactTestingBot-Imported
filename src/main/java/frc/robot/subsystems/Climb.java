// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
  TalonFX leftClimbMotor = new TalonFX(1);
  TalonFX rightClimbMotor = new TalonFX(13);

  // DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 14, 15);
  /**
   * Climb subsystem
   */
  public Climb() {
    leftClimbMotor.configFactoryDefault();
    rightClimbMotor.configFactoryDefault();

    leftClimbMotor.setNeutralMode(NeutralMode.Brake);
    rightClimbMotor.setNeutralMode(NeutralMode.Brake);

    leftClimbMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    rightClimbMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    leftClimbMotor.config_kP(0, 0.2);
    rightClimbMotor.config_kP(0, 0.2);
  }

  // /**
  //  * Climbs to the bar
  //  * @param bar the bar to climb to... what did you think nerd
  //  */
  // public void climb(int bar){
  //   int motorPos = ClimbConstants.motorPositions[bar - 2];

  //   leftClimbMotor.set(ControlMode.MotionMagic, motorPos);
  //   rightClimbMotor.set(ControlMode.MotionMagic, motorPos);
  // }

  /**
   * plan:
   * func motor pos
   * func solenoid
   * command to run all
   */

  public void setPos(int pos){
    leftClimbMotor.set(ControlMode.MotionMagic, pos);
    rightClimbMotor.set(ControlMode.MotionMagic, pos);
  }

  public void stopMotors(){
    leftClimbMotor.set(ControlMode.PercentOutput, 0);
    rightClimbMotor.set(ControlMode.PercentOutput, 0);
  }

  public void setSolenoids(boolean extended){
    SmartDashboard.putBoolean("Climb Solenoids", extended);
    if (extended){
     //solenoid.set(DoubleSolenoid.Value.kForward);
    }
    else{
     //solenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }

  public double getPosition() {
    return leftClimbMotor.getSelectedSensorPosition();
  }

  public void setSpeed(double speed){
    leftClimbMotor.set(ControlMode.PercentOutput, speed);
    rightClimbMotor.set(ControlMode.PercentOutput, speed);
  }

  public void resetEncoders(){
    leftClimbMotor.setSelectedSensorPosition(0);
    rightClimbMotor.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Climb Left Motor", leftClimbMotor.getSelectedSensorPosition());
    SmartDashboard.putNumber("Climb Right Motor", rightClimbMotor.getSelectedSensorPosition());
  }
}
