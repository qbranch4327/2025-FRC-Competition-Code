package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotConstants;
import frc.robot.subsystems.ExtendoSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class AutonExtend extends Command {
    ExtendoSubsystem extendoSubsystem;
    boolean isItFinished;
    boolean extendoFinished;
    Timer timer;

    public AutonExtend(ExtendoSubsystem extendoSubsystem) {
        timer = new Timer();
        this.extendoSubsystem = extendoSubsystem;
        addRequirements(extendoSubsystem);
    }

    @Override
    public void initialize() {
        isItFinished = false;
        extendoFinished = false;
        timer.restart();

    }

    @Override
    public void execute() {
        if (timer.get() > 0.5){
        if (!extendoFinished && extendoSubsystem.wentTo(RobotConstants.ExtendoExtendL4) || timer.get() > 1.0) {
            extendoSubsystem.stop();
            extendoFinished = true;
        }
        if (extendoFinished) {
            isItFinished = true;
        }}
        else {
            extendoSubsystem.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return isItFinished;
    }
}