package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.Robot;
import frc.robot.RobotConstants;
import frc.robot.subsystems.*;

public class ClimberCommand extends Command {
    ClimberSubsystem climberSubsystem;
    CommandJoystick controller1;

    public ClimberCommand(
            ClimberSubsystem climberSubsystem,
            CommandJoystick controller1) {
        this.climberSubsystem = climberSubsystem;
        this.controller1 = controller1;
        addRequirements(climberSubsystem);
    }

    @Override
    public void execute() {
        controller1.button(5).whileTrue(climberSubsystem.runOnce(() -> climberSubsystem.goTo(RobotConstants.ClimberClimbgoal)));
        controller1.button(6).whileTrue(climberSubsystem.runOnce(() -> climberSubsystem.goTo(RobotConstants.ClimberReleasegoal)));
    }}