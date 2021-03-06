// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class Constants {
    public static class MotorConstants{
        public static int frontLeftID = 0-9;
        public static int frontRightID = 0-9;
        public static int backLeftID = 0-9;
        public static int backRightID = 0-9;

        public static int leftFlyMotorID = 0-9;
        public static int rightFlyMotorID = 0-9;
        public static int topTowerID = 0-9;
        public static int bottomTowerID = 0-9;
        public static int topBeltMotorID = 0-9;
        public static int bottomBeltMotorID = 0-9;

        public static double PFlyDriveController = 0-9;
        public static double IFlyDriveController = 0-9;
        public static double DFlyDriveController = 0-9;

        // sensors
        public static int towerSensorID = 0-9;

        // actuators
        public static int actuator1Port = 0-9;
        public static int actuator2Port = 0-9;
    }

    public static class TurretConstants{
        /** angle to go to, extension */
        public static double [][] angleTable = {
            {4.0, 46.13},
            {5.0, 46.13},
            {6.6, 50.0},
            {7.0, 50},
            {9.7, 58.5}, 
            {11.0, 60},
            {12.7, 63.5},
            {15.0, 65},
            {16.2, 68},
            {20.0, 70},
            {23.3, 72},
            {25.0, 70}
          };
    }

    public static class OIConstants{
        public static int buttonStickID = 0;
        public static int raiseTelescopingArmsButtonID = 1;
        public static int startClimbButtonID = 4;
        public static int manualControlButtonID = 2;


        // Limelight buttons
        public static int turnToTargetButtonID = 7;

        public static int shootID = 0-9;
    }

    public static class PIDConstants{

    }

    public static class EncoderConstants{

    }

    public static class LimelightConstants{
        public static double cameraHeight = 0;
        public static double cameraAngle = 0;
        public static double targetHeight = 8.66;

        // minimum pixel distance from center of target to center of frame
        public static double minimumOkPixels = 3.0;
        // speed (%) to turn
        public static double turnSpeed = 0.4;
        // point-blank speed/angle
        public static double pointBlankSpeed = 0.7;
        public static double pointBlankAngle = 130;

        /** distance, angle values obtained from testing */
        public static double [][] distanceTable = {
            {4.0, 46.13},
            {5.0, 46.13},
            {6.6, 50.0},
            {7.0, 50},
            {9.7, 58.5}, 
            {11.0, 60},
            {12.7, 63.5},
            {15.0, 65},
            {16.2, 68},
            {20.0, 70},
            {23.3, 72},
            {25.0, 70}
          };
    }

    public static final class ClimbConstants{
        /**
         * Climb motor positions in encoder values
         * FIXME: random
         */
        public static int firstBarPos = 48124;
        public static int secondBarPos = 471289;
        public static int finalBarPos = 5741240;
        public static int slightlyExtended = 0-9;
    }

    public static double robotWithMeters = -0.0;
}
