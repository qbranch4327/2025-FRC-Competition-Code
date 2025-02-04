package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CoralIntakeSubsystem;

public class AutonTimedIntakeCommandShort extends Command {
    CoralIntakeSubsystem intakeSubsystem;
    Timer timer;

    public AutonTimedIntakeCommandShort(CoralIntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        timer = new Timer();
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        timer.restart();
    }

    @Override
    public void execute() {
        intakeSubsystem.intakeOn(true);
                
    }

    @Override
    public boolean isFinished() {
        if (timer.get() >= 0.75) {
            intakeSubsystem.intakeOff();
            return true;
        }
        return false;
    }
}
