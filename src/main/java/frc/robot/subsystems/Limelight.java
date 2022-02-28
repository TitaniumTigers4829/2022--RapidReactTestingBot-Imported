// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LimelightConstants;

public class Limelight extends SubsystemBase {
  /** Creates a new Limelight. */
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  NetworkTableEntry thor = table.getEntry("thor");
  LinearInterpolator distanceInterpolator = new LinearInterpolator(LimelightConstants.distanceTable);
  public Limelight() {}

  /** Calculates distance in feet
   * @return distance in feet
   */
  public double calculateDistance(){
    double distance = ((LimelightConstants.targetHeight - LimelightConstants.cameraHeight) / Math.tan(LimelightConstants.cameraAngle + ty.getDouble(0.0)));
    return distance;
  }

  /**
   * Gets horizontal angle to target
   * @return horizontal angle to the targt, with a default value of 0
   */
  public double pixelsToTarget(){
    return tx.getDouble(0.0);
  }

  public double targetLongestSide(){
    return thor.getDouble(0.0);
  }

  /**
   * Calculates necessary angle for the turret to go to
   * @param distance distance in feet
   */
  public double calculateAngle(double distance){
    return distanceInterpolator.getInterpolatedValue(distance);
  }

  /**
   * get hood angle and distance
   * plug this into fancy formula
   * 
   */
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    SmartDashboard.putNumber("Limelight X: ", x);
    SmartDashboard.putNumber("Limelight Y: ", y);
    SmartDashboard.putNumber("Limelight Area: ", area);
  }
}
