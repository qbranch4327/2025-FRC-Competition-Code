package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLimitSwitch;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants;

public class CoralintakeSubsystem extends SubsystemBase {
    SparkFlex intakeMotor;
    public DigitalInput sensor;
    public SparkLimitSwitch beambreak;

    public CoralintakeSubsystem() {
        intakeMotor = new SparkFlex(RobotConstants.CoralIntakeCANid,
                com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless);
        sensor = new DigitalInput(RobotConstants.CoralIntakeSensorDIOid);
        beambreak = intakeMotor.getForwardLimitSwitch();
    }

    public void intakeOn(boolean forward) {
        if (forward) {
            intakeMotor.set(RobotConstants.CoralIntakeOnspeed);
        } else {
            intakeMotor.set(RobotConstants.CoralIntakeOutspeed);
        }
    }

    public void intakeOnBypass() {
        intakeMotor.set(RobotConstants.CoralIntakeOnspeed);
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

    public boolean isBeamBroken(){
        return beambreak.isPressed();
    }
}