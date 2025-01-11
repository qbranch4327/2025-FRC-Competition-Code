package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants;

public class ExtendoSubsystem extends SubsystemBase {
    SparkFlex ExtendoMotor;
    Encoder ExtendoEncoder;
    private final double encoderOffset = RobotConstants.ExtendoEncoderOffset;
    private final double rangeOffset = RobotConstants.ExtendoRangeOffset;

    public ExtendoSubsystem() {
        ExtendoMotor = new SparkFlex(RobotConstants.ExtendoMotorCANid, MotorType.kBrushless);
        ExtendoEncoder = new Encoder(RobotConstants.ExtendoEncoderDIOidA, RobotConstants.ExtendoEncoderDIOidB);
    }

    public void goTo(double degrees) {

        var position = (ExtendoEncoder.get() + encoderOffset) % 1;

        if (position > (degrees + rangeOffset + encoderOffset) % 1) {
            this.Extend(RobotConstants.ExtendoExtendSpeed);
        } else if (position < (degrees - rangeOffset + encoderOffset) % 1) {
            this.Retract(RobotConstants.ExtendoRetractSpeed);
        } else {
            this.stop();
        }
    }

    public boolean wentTo(double degrees) {

        var pos = (ExtendoEncoder.get() + encoderOffset) % 1;
        var target = (degrees + rangeOffset + encoderOffset) % 1;

        if (pos > target) {
            this.Extend(RobotConstants.ExtendoExtendSpeed);
            return false;
        } else if ((ExtendoEncoder.get() + encoderOffset) % 1 < (degrees - rangeOffset + encoderOffset) % 1) {
            this.Retract(RobotConstants.ExtendoRetractSpeed);
            return false;
        } else {
            this.stop();
            return true;
        }
    }

    public void Extend(double speed) {
        ExtendoMotor.set(speed);
    }

    public void Retract(double speed) {
        ExtendoMotor.set(speed);
    }

    public void stop() {
        ExtendoMotor.stopMotor();
    }

    public boolean encoderCheck(double distance) {
        if (ExtendoEncoder.get() == distance) {
            return true;
        }
        return false;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Extendo Encoder", (ExtendoEncoder.get()));
    }
}