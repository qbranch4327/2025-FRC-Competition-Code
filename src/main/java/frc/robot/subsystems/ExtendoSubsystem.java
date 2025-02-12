package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLimitSwitch;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.LimitSwitchConfig;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants;

public class ExtendoSubsystem extends SubsystemBase {
    SparkFlex ExtendoMotor;
    RelativeEncoder ExtendoEncoder;
    SparkFlexConfig ExtendoMotorConfig;
    public DigitalInput sensor;
    public SparkLimitSwitch magLimitSwitch;
    public LimitSwitchConfig magLimitSwitchConfig;
    private final double rangeOffset = RobotConstants.ExtendoRangeOffset;

    public ExtendoSubsystem() {
        ExtendoMotor = new SparkFlex(RobotConstants.ExtendoMotorCANid, MotorType.kBrushless);
        ExtendoEncoder = ExtendoMotor.getEncoder();
        magLimitSwitch = ExtendoMotor.getForwardLimitSwitch();
        ExtendoMotorConfig = new SparkFlexConfig();
        ExtendoMotorConfig.limitSwitch
                .forwardLimitSwitchEnabled(true);
        
    }

    public void goTo(double degrees) {

        var position = (ExtendoEncoder.getPosition());

        if (position < (degrees - rangeOffset)) {
            this.Extend(RobotConstants.ExtendoRetractSpeed);
        } else if (position > (degrees + rangeOffset)) {
            this.Retract(RobotConstants.ExtendoExtendSpeed);
        } else {
            this.stop();
        }
    }

    public boolean wentTo(double degrees) {

        var pos = (ExtendoEncoder.getPosition());
        var target = (degrees + rangeOffset);

        if (pos > target) {
            this.Extend(RobotConstants.ExtendoExtendSpeed);
            return false;
        } else if (pos < target) {
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

    public void resetEncoder() {
        ExtendoEncoder.setPosition(0.00);
    }

    public boolean encoderCheck(double distance) {
        if (ExtendoEncoder.getPosition() == distance) {
            return true;
        }
        return false;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Extendo Encoder", (ExtendoEncoder.getPosition()));
    }
}