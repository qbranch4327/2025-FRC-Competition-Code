package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkFlexConfig;

import au.grapplerobotics.LaserCan;
import au.grapplerobotics.*;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkFlexExternalEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants;

public class ElevatorSubsystem extends SubsystemBase {
    SparkFlex ElevatorMotor;
    RelativeEncoder ElevatorEncoder;
    private final double rangeOffset = RobotConstants.ElevatorRangeOffset;
    private final double encoderOffset = RobotConstants.ElevatorEncoderOffset;
    private final double lcrangeOffset = RobotConstants.lcrangeOffset;
    SparkFlexConfig ElevatorMotorConfig;
    private LaserCan lc;

    public ElevatorSubsystem() {
        ElevatorMotor = new SparkFlex(RobotConstants.ElevatorMotorCANid,
                com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless);
        ElevatorEncoder = ElevatorMotor.getExternalEncoder();
        lc = new LaserCan(0);
    }

    public void goTo(double encoderGoal) {
        if ((ElevatorEncoder.getPosition()) < (encoderGoal - rangeOffset)) {
            this.goUp();
        } else if ((ElevatorEncoder.getPosition()) > (encoderGoal + rangeOffset)) {
            this.goDown();
        } else {
            this.stop();
        }
    }

    
    public void lcgoTo(double lcGoal) {
        
        LaserCan.Measurement measurement = lc.getMeasurement();
        if ((measurement.distance_mm) < (lcGoal - rangeOffset)) {
            this.goUp();
        } else if ((measurement.distance_mm) >= (lcGoal + rangeOffset)) {
            this.goDown();
        } else {
            this.stop();
        }
    }

    public boolean wentTo(double encoderGoal) {
        if ((ElevatorEncoder.getPosition()) < (encoderGoal - rangeOffset)) {
            this.goUp();
            return false;
        } else if ((ElevatorEncoder.getPosition()) > (encoderGoal + rangeOffset)) {
            this.goDown();
            return false;
        } else {
            this.stop();
            return true;
        }
    }

    public boolean lcwentTo(double lcGoal) {
        LaserCan.Measurement measurement = lc.getMeasurement();
        if ((measurement.distance_mm) < (lcGoal - lcrangeOffset)) {
            this.goUp();
            return false;
        } else if ((measurement.distance_mm) > (lcGoal + lcrangeOffset)) {
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
        if (ElevatorEncoder.getPosition() == distance) {
            return true;
        }
        return false;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Elevator Encoder", (ElevatorEncoder.getPosition()));
        // SmartDashboard.putNumber("LaserCAN Distance in mm", (measurement.distance_mm));
    }
}