package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import frc.lib.util.COTSTalonFXSwerveConstants;
import frc.lib.util.SwerveModuleConstants;

public final class Constants {
    public static final class Swerve {
        public static final int pigeonID = 31;
        public static final COTSTalonFXSwerveConstants chosenModule = COTSTalonFXSwerveConstants.MK4i.Falcon500(COTSTalonFXSwerveConstants.MK4i.driveRatios.L2);
        public static final double trackWidth = Units.inchesToMeters(20.5);
        public static final double wheelBase = Units.inchesToMeters(18.5); 
        public static final double wheelCircumference = chosenModule.wheelCircumference;     

        public static final SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
            new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
            new Translation2d(wheelBase / 2.0, trackWidth / 2.0));
        
        public static final double driveGearRatio = chosenModule.driveGearRatio;
        public static final double angleGearRatio = chosenModule.angleGearRatio;

        public static final InvertedValue angleMotorInvert = chosenModule.angleMotorInvert;
        public static final InvertedValue driveMotorInvert = chosenModule.driveMotorInvert;
        public static final SensorDirectionValue cancoderInvert = chosenModule.cancoderInvert;

        public static final int angleCurrentLimit = 80;
        public static final int angleCurrentThreshold = 80;
        public static final double angleCurrentThresholdTime = 0.1;
        public static final boolean angleEnableCurrentLimit = true;

        public static final int driveCurrentLimit = 80;
        public static final int driveCurrentThreshold = 80;
        public static final double driveCurrentThresholdTime = 0.1;
        public static final boolean driveEnableCurrentLimit = true;

        public static final double openLoopRamp = 0.25;
        public static final double closedLoopRamp = 0.0;

        public static final double angleKP = chosenModule.angleKP;
        public static final double angleKI = chosenModule.angleKI;
        public static final double angleKD = chosenModule.angleKD;

        public static final double driveKP = 0.6; 
        public static final double driveKI = 0.0;
        public static final double driveKD = 0.0;
        public static final double driveKF = 0.0;

        public static final double driveKS = 0.32; 
        public static final double driveKV = 1.51; 
        public static final double driveKA = 0.27;

        public static final double maxSpeed = 1.7; 
        public static final double maxAngularVelocity = 10.0; 

        public static final NeutralModeValue angleNeutralMode = NeutralModeValue.Brake;
        public static final NeutralModeValue driveNeutralMode = NeutralModeValue.Brake;

        /* Front Left Module - Module 0 */
        public static final class Mod0 { 
            public static final int driveMotorID = 23;
            public static final int angleMotorID = 22;
            public static final int canCoderID = 31;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-116.45);
            public static final SwerveModuleConstants constants = 
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }

        /* Front Right Module - Module 1 */
        public static final class Mod1 { 
            public static final int driveMotorID = 25;
            public static final int angleMotorID = 24;
            public static final int canCoderID = 32;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(118.21);
            public static final SwerveModuleConstants constants = 
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }
        
        /* Back Left Module - Module 2 */
        public static final class Mod2 { 
            public static final int driveMotorID = 21;
            public static final int angleMotorID = 20;
            public static final int canCoderID = 30;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(99.75);
            public static final SwerveModuleConstants constants = 
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }

        /* Back Right Module - Module 3 */
        public static final class Mod3 { 
            public static final int driveMotorID = 27;
            public static final int angleMotorID = 26;
            public static final int canCoderID = 33;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-117.50);
            public static final SwerveModuleConstants constants = 
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }
    }

    public static final class AutoConstants { 
        public static final double kMaxSpeedMetersPerSecond = 3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 3;
        public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
        public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;
        public static final double kPXController = 5;
        public static final double kPYController = 5;
        public static final double kPThetaController = 1;
        public static final TrapezoidProfile.Constraints kThetaControllerConstraints = new TrapezoidProfile.Constraints(kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
    }
}
