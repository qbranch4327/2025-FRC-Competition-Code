package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotConstants;
import frc.robot.subsystems.ExtendoSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;

public class AutonL4Command extends Command    {
    
    ExtendoSubsystem extendoSubsystem;
    ElevatorSubsystem elevatorSubsystem;
    boolean isItFinished;
    boolean extendoFinished;
    boolean elevatorFinished;

    public AutonL4Command(ExtendoSubsystem extendoSubsystem, ElevatorSubsystem elevatorSubsystem) {
        this.extendoSubsystem = extendoSubsystem;
        this.elevatorSubsystem = elevatorSubsystem;
        addRequirements(extendoSubsystem);
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void initialize()    {
        isItFinished = false;
        extendoFinished = false;
        elevatorFinished = false;
    }

    @Override
    public void execute()   {
        if (!extendoFinished && extendoSubsystem.wentTo(RobotConstants.ExtendoExtend)) {
            extendoSubsystem.stop();
            extendoFinished = true;
        }
        if (!elevatorFinished && elevatorSubsystem.wentTo(RobotConstants.L4Value, RobotConstants.L4HighExtreme)) {
            elevatorSubsystem.stop();
            elevatorFinished = true;
        }
        if (extendoFinished && elevatorFinished) {
            isItFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isItFinished;
    }

}