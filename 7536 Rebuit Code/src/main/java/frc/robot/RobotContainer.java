package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TeleopSwerve;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {
    private PS5Controller driver = new PS5Controller(0);
    private CommandXboxController nejip = new CommandXboxController(1);
    JoystickButton robotCentric = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);

    public static final SwerveSubsystem Swerve = new SwerveSubsystem();
    SendableChooser<Command> autoChooser = new SendableChooser<>();

    public RobotContainer() {
    autoChooser = AutoBuilder.buildAutoChooser();
    SmartDashboard.putData(autoChooser);
    configureButtonBindings();

    if(DriverStation.getAlliance().get() == Alliance.Red){
    Swerve.setDefaultCommand(
    new TeleopSwerve(
        Swerve, 
       ()-> driver.getRawAxis(1), 
       ()-> driver.getRawAxis(0), 
       ()-> -driver.getRawAxis(2), 
       ()-> robotCentric.getAsBoolean()));
    } else {
    Swerve.setDefaultCommand(
    new TeleopSwerve(
        Swerve, 
       ()-> -driver.getRawAxis(1), 
       ()-> -driver.getRawAxis(0), 
       ()-> -driver.getRawAxis(2), 
       ()-> robotCentric.getAsBoolean()));
    }
}

    public void configureButtonBindings() {}

    public Command getAutonomousCommand() { 
        return autoChooser.getSelected();
    }
}
