// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;
import frc.robot.Constants.TurretConstants;

/*
1 button - spin intake, bottom tower, upper tower
when ball detected by photoelectric sensor, stop top tower
*/

public class Turret extends SubsystemBase {
    /** Creates a new Turret. */
    
    private final WPI_TalonSRX topTowerMotor;
    private final WPI_TalonSRX bottomTowerMotor;
    private final WPI_TalonFX leftFlyMotor;
    private final WPI_TalonFX rightFlyMotor;

    private final PIDController flyPidController =
      new PIDController(
          MotorConstants.PFlyDriveController,
          MotorConstants.IFlyDriveController, // 0
          MotorConstants.DFlyDriveController // 0
      );
    
    private final DigitalInput sensor;
    
    private final Servo actuator1;
    private final Servo actuator2;
    
    private final LinearInterpolator angleInterpolator; 
    
    public Turret() {
        topTowerMotor = new WPI_TalonSRX(MotorConstants.topTowerID);
        bottomTowerMotor = new WPI_TalonSRX(MotorConstants.bottomTowerID);
        leftFlyMotor = new WPI_TalonFX(MotorConstants.leftFlyMotorID);
        rightFlyMotor = new WPI_TalonFX(MotorConstants.rightFlyMotorID);
        
        angleInterpolator = new LinearInterpolator(TurretConstants.angleTable);
        
        sensor = new DigitalInput(MotorConstants.towerSensorID);
        
        topTowerMotor.configFactoryDefault();
        bottomTowerMotor.configFactoryDefault();
        leftFlyMotor.configFactoryDefault();
        rightFlyMotor.configFactoryDefault();
        // One motor needs to be inverted because they're facing opposite directions
        rightFlyMotor.setInverted(true);

        actuator1 = new Servo(MotorConstants.actuator1Port);
        actuator2 = new Servo(MotorConstants.actuator2Port);
    }
    
    public boolean getSensor() {
        return sensor.get();
    }
    
    public void setTurretAngle(double angle) {
        angle = angleInterpolator.getInterpolatedValue(angle);
        actuator1.set(angle);
        actuator2.set(angle);
    }
    
    public void setTurretRatio(double ratioPos) {
        actuator1.set(ratioPos);
        actuator2.set(ratioPos);
    }
    /** Set turret pos in % of extension
    * @param extension percent of extension
    */
    public void setTurretExtension(double extension) {
        actuator1.set(extension / 100);
        actuator2.set(extension / 100);
    }
    
    public void spinUntilBall() {
        boolean isBallIn = false;

        while (!isBallIn) {
            bottomTowerMotor.set(ControlMode.PercentOutput, 0.2);
            topTowerMotor.set(ControlMode.PercentOutput, 0.2);
            isBallIn = sensor.get();
        }

        topTowerMotor.set(ControlMode.PercentOutput, 0);
        bottomTowerMotor.set(ControlMode.PercentOutput, 0.5);
    }
    
    public void stop() {
        leftFlyMotor.set(ControlMode.PercentOutput, 0.0);
        rightFlyMotor.set(ControlMode.PercentOutput, 0.0);
        topTowerMotor.set(ControlMode.PercentOutput, 0.0);
        bottomTowerMotor.set(ControlMode.PercentOutput, 0.0);
    }
    
    public void pointBlank() {
        
    }
    
    public void shoot(double distance) {
        leftFlyMotor.set(ControlMode.PercentOutput, 0.5);
        rightFlyMotor.set(ControlMode.PercentOutput, 0.5);
    }
    
    public void stopShooting() {
        leftFlyMotor.set(ControlMode.PercentOutput, 0.0);
        rightFlyMotor.set(ControlMode.PercentOutput, 0.0);
    }
    
    @Override
    public void periodic() {
    }
}
