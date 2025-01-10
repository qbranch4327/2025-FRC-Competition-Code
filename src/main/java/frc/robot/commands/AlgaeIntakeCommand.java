package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;

public class AlgaeIntakeCommand extends Command {
    
    AlgaeIntakeSubsystem intakeSubsystem;
    AlgaeWristSubsystem wristSubsystem;
    XboxController controller2;

    public AlgaeIntakeCommand(AlgaeIntakeSubsystem intakeSubsystem, AlgaeWristSubsystem wristSubsystem, XboxController controller2)  {
        this.intakeSubsystem = intakeSubsystem;
        this.wristSubsystem = wristSubsystem;
        this.controller2 = controller2;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute()   {
        if (controller2.getRightTriggerAxis() > 0.2)   {
            intakeSubsystem.AlgaeIntakeOn(true);
        }
        else if (controller2.getRightTriggerAxis() > 0.2 && controller2.getLeftTriggerAxis() > 0.2) {
            intakeSubsystem.AlgaeIntakeSlow(false);
        }
        else if (controller2.getLeftTriggerAxis() > 0.2)   {
            intakeSubsystem.AlgaeIntakeOn(false);
        }
        else    {
          intakeSubsystem.AlgaeIntakeOff();
        }

        if (controller2.getRightX() > 0.2){
            wristSubsystem.extend();
        }
        else if (controller2.getRightX() < -0.2){
            wristSubsystem.retract();
        }
        else {
            wristSubsystem.stop();
        }
        }

}