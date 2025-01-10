package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CoralintakeSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class AutonIntakeCommand extends Command {
    
    CoralintakeSubsystem intakeSubsystem;
    Timer timer;

    public AutonIntakeCommand(CoralintakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        timer = new Timer();
        addRequirements(intakeSubsystem);
    }
    
    @Override
    public void initialize() {
        timer.restart();
    }

    @Override
    public void execute()   {
        intakeSubsystem.intakeOn(true);
    }

    @Override
    public boolean isFinished() {
        if (!intakeSubsystem.sensor.get() || timer.get() >= 3)  {
            intakeSubsystem.intakeOff();
            return true;
        }
        return false;
    }

}
