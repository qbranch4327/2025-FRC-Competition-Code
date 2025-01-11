package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkFlexConfig;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants;

public class ElevatorSubsystem extends SubsystemBase {
    SparkFlex ElevatorMotor;
    Encoder ElevatorEncoder;
    private final double rangeOffset = RobotConstants.ElevatorRangeOffset;
    private final double encoderOffset = RobotConstants.ElevatorEncoderOffset;
    SparkFlexConfig ElevfatorMotorConfig;

    public ElevatorSubsystem() {
        ElevatorMotor = new SparkFlex(RobotConstants.ElevatorMotorCANid,
                com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless);
        ElevatorEncoder = new Encoder(RobotConstants.ElevatorEncoderDIOidA, RobotConstants.ElevatorEncoderDIOidB);

    }

    public void goTo(double encoderGoal, double extremaValue) {
        if ((encoderGoal + encoderOffset) % 1 > (extremaValue + encoderOffset) % 1
                && (ElevatorEncoder.get() + encoderOffset) % 1 < (encoderGoal - rangeOffset + encoderOffset) % 1) {
            this.goDown();
        } else if ((encoderGoal + encoderOffset) % 1 > (extremaValue + encoderOffset) % 1
                && (ElevatorEncoder.get() + encoderOffset) % 1 > (encoderGoal + rangeOffset + encoderOffset) % 1) {
            this.goUp();
        } else if ((encoderGoal + encoderOffset) % 1 < (extremaValue + encoderOffset) % 1
                && (ElevatorEncoder.get() + encoderOffset) % 1 > (encoderGoal + rangeOffset + encoderOffset) % 1) {
            this.goUp();
        } else if ((encoderGoal + encoderOffset) % 1 < (extremaValue + encoderOffset) % 1
                && (ElevatorEncoder.get() + encoderOffset) % 1 < (encoderGoal - rangeOffset + encoderOffset) % 1) {
            this.goDown();
        } else {
            this.stop();
        }
    }

    public boolean wentTo(double encoderGoal, double extremaValue) {
        if ((encoderGoal + encoderOffset) % 1 > (extremaValue + encoderOffset) % 1
                && (ElevatorEncoder.get() + encoderOffset) % 1 < (encoderGoal - rangeOffset + encoderOffset) % 1) {
            this.goDown();
            return false;
        } else if ((encoderGoal + encoderOffset) % 1 > (extremaValue + encoderOffset) % 1
                && (ElevatorEncoder.get() + encoderOffset) % 1 > (encoderGoal + rangeOffset + encoderOffset) % 1) {
            this.goUp();
            return false;
        } else if ((encoderGoal + encoderOffset) % 1 < (extremaValue + encoderOffset) % 1
                && (ElevatorEncoder.get() + encoderOffset) % 1 > (encoderGoal + rangeOffset + encoderOffset) % 1) {
            this.goUp();
            return false;
        } else if ((encoderGoal + encoderOffset) % 1 < (extremaValue + encoderOffset) % 1
                && (ElevatorEncoder.get() + encoderOffset) % 1 < (encoderGoal - rangeOffset + encoderOffset) % 1) {
            this.goDown();
            return false;
        } else {
            this.stop();
            return true;
        }
    }

    public void goUp() {
        ElevatorMotor.set(RobotConstants.ElevatorUpSpeed);
    }

    public void goDown() {
        ElevatorMotor.set(RobotConstants.ElevatorDownSpeed);
    }

    public void stop() {
        ElevatorMotor.stopMotor();
    }

    public boolean encoderCheck(double distance) {
        if (ElevatorEncoder.get() == distance) {
            return true;
        }
        return false;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Wrist Encoder", (ElevatorEncoder.get()));
    }
}