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
  TalonFX leftClimbMotor = new TalonFX(0-9);
  TalonFX rightClimbMotor = new TalonFX(0-9);

  DoubleSolenoid leftSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0-9, 0-9);
  DoubleSolenoid rightSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0-9, 0-9);
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
      leftSolenoid.set(DoubleSolenoid.Value.kForward);
      rightSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    else{
      leftSolenoid.set(DoubleSolenoid.Value.kReverse);
      rightSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }

  public double getPosition() {
    return leftClimbMotor.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
