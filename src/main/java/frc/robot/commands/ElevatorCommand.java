package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotConstants;
import frc.robot.subsystems.ExtendoSubsystem;
import frc.robot.subsystems.AlgaeWristSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorCommand extends Command {
    ElevatorSubsystem elevatorSubsystem;
    ExtendoSubsystem extendoSubsystem;
    AlgaeWristSubsystem wristSubsystem;
    XboxController controller2;

    public ElevatorCommand(ElevatorSubsystem elevatorSubsystem, ExtendoSubsystem extendoSubsystem,
            XboxController controller2) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.extendoSubsystem = extendoSubsystem;
        this.controller2 = controller2;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        if (controller2.getLeftY() < -0.2) {
            elevatorSubsystem.goUp();
        } else if (controller2.getLeftY() > 0.2) {
            elevatorSubsystem.goDown();
        } else if (controller2.getLeftX() > 0.2) {
            extendoSubsystem.Extend(RobotConstants.ExtendoExtendSpeed);
        } else if (controller2.getLeftX() < -0.2) {
            extendoSubsystem.Extend(RobotConstants.ExtendoRetractSpeed);
        } else if (controller2.getAButton()) { // Dump
            elevatorSubsystem.lcgoTo(RobotConstants.lcHomeValue);
            extendoSubsystem.goTo(RobotConstants.ExtendoRetract);
        } else if (controller2.getXButton()) { // Amp
            elevatorSubsystem.lcgoTo(RobotConstants.lcL2Value);
            extendoSubsystem.goTo(RobotConstants.ExtendoExtend);
        } else if (controller2.getYButton()) { // Ground
            elevatorSubsystem.lcgoTo(RobotConstants.lcL4Value);
            extendoSubsystem.goTo(RobotConstants.ExtendoExtendL4);
        } else if (controller2.getBButton()) { // Source
            elevatorSubsystem.lcgoTo(RobotConstants.lcL3Value);
            extendoSubsystem.goTo(RobotConstants.ExtendoExtend);
        } else {
            elevatorSubsystem.stop();
            extendoSubsystem.stop();
        }
    }
}