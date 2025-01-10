package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotConstants;
import frc.robot.subsystems.CoralintakeSubsystem;
import frc.robot.subsystems.NewShooterSubsystem;
import frc.robot.subsystems.AlgaeWristSubsystem;
import frc.robot.subsystems.ExtendoSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class AutonPassOffCommand extends Command {
    
    CoralintakeSubsystem intakeSubsystem;
    NewShooterSubsystem newShooterSubsystem;
    AlgaeWristSubsystem wristSubsystem;
    ExtendoSubsystem armSubsystem;
    boolean isItFinished;
    boolean armFinished;
    boolean wristFinished;
    Timer timer;

    public AutonPassOffCommand(CoralintakeSubsystem intakeSubsystem, NewShooterSubsystem newShooterSubsystem, AlgaeWristSubsystem wristSubsystem, ExtendoSubsystem armSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        this.newShooterSubsystem = newShooterSubsystem;
        this.wristSubsystem = wristSubsystem;
        this.armSubsystem = armSubsystem;
        timer = new Timer();
        addRequirements(intakeSubsystem);
        addRequirements(newShooterSubsystem);
        addRequirements(wristSubsystem);
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize()    {
        isItFinished = false;
        armFinished = false;
        wristFinished = false;
        timer.restart();
    }
    
    @Override
    public void execute()   {
        // intakeSubsystem.intakeOn(true);
        // newShooterSubsystem.indexAuton(true);

        //     if (!armFinished && armSubsystem.wentTo(RobotConstants.dumpArmValueAuton)) {
        //     armSubsystem.stop();
        //     armFinished = true;
        // }
        if (!wristFinished && wristSubsystem.wentTo(RobotConstants.dumpWristValue, RobotConstants.dumpWristExtreme)) {
            wristSubsystem.stop();
            wristFinished = true;
        }
        if (wristFinished) {
            isItFinished = true;
            intakeSubsystem.intakeOn(true);
            newShooterSubsystem.indexAuton(true);
        }
    }

    @Override
    public boolean isFinished() {
        if (!newShooterSubsystem.sensor.get() || timer.get() >= 1.5)  {
            intakeSubsystem.intakeOff();
            newShooterSubsystem.indexOff();
            return true;
        }
        return false;
    }

}
