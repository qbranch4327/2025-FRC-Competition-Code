package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotConstants;
import frc.robot.subsystems.ExtendoSubsystem;
import frc.robot.subsystems.AlgaeWristSubsystem;

public class AutonArmUpCommand extends Command    {
    
    ExtendoSubsystem rotationArmSubsystem;
    AlgaeWristSubsystem wristSubsystem;
    boolean isItFinished;
    boolean armFinished;
    boolean wristFinished;

    public AutonArmUpCommand(ExtendoSubsystem rotationArmSubsystem, AlgaeWristSubsystem wristSubsystem) {
        this.rotationArmSubsystem = rotationArmSubsystem;
        this.wristSubsystem = wristSubsystem;
        addRequirements(rotationArmSubsystem);
        addRequirements(wristSubsystem);
    }

    @Override
    public void initialize()    {
        isItFinished = false;
        armFinished = false;
        wristFinished = false;
    }

    @Override
    public void execute()   {
        if (!armFinished && rotationArmSubsystem.wentTo(RobotConstants.dumpArmValueAuton)) {
            rotationArmSubsystem.stop();
            armFinished = true;
        }
        if (!wristFinished && wristSubsystem.wentTo(RobotConstants.dumpWristValue, RobotConstants.dumpWristExtreme)) {
            wristSubsystem.stop();
            wristFinished = true;
        }
        if (armFinished && wristFinished) {
            isItFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isItFinished;
    }

}