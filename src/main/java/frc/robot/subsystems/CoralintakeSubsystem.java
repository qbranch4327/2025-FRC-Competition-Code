package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants;

public class CoralintakeSubsystem extends SubsystemBase {
    SparkFlex intakeMotor;
    public DigitalInput sensor;

    public CoralintakeSubsystem() {
        intakeMotor = new SparkFlex(RobotConstants.CoralIntakeCANid,
                com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless);
        sensor = new DigitalInput(RobotConstants.CoralIntakeSensorDIOid);
    }

    public void intakeOn(boolean forward) {
        if (forward) {
            intakeMotor.set(RobotConstants.CoralIntakeOnspeed);
        } else {
            intakeMotor.set(RobotConstants.CoralIntakeOutspeed);
        }
    }

    public void intakeOff() {
        intakeMotor.stopMotor();
    }

    public void intakeSlow(boolean forward) {
        if (forward) {
            intakeMotor.set(RobotConstants.CoralIntakeSlowspeed);
        } else {
            intakeMotor.set(-RobotConstants.CoralIntakeSlowspeed);
        }
    }
}