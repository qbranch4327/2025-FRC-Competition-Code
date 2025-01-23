package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CoralintakeSubsystem;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.RobotConstants;

public class LEDCommand extends Command {
    LEDSubsystem ledSubsystem;
    CoralintakeSubsystem intakeSubsystem;
    XboxController controller2;

    public LEDCommand(LEDSubsystem ledSubsystem, XboxController controller2, CoralintakeSubsystem intakeSubsystem) {
        this.ledSubsystem = ledSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.controller2 = controller2;
        addRequirements(ledSubsystem);
    }

    @Override
    public void execute() {
        if (!intakeSubsystem.sensor.get() || intakeSubsystem.beambreak.isPressed()) {
            ledSubsystem.set(RobotConstants.LEDintakesensor);
        }
        else {
            ledSubsystem.set(RobotConstants.LEDdefault);
        }
    }
}