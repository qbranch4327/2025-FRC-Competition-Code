package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkFlexConfig;

import au.grapplerobotics.LaserCan;

import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotConstants;

public class ElevatorSubsystem extends SubsystemBase {
    SparkFlex ElevatorMotor;
    RelativeEncoder ElevatorEncoder;
    private final double rangeOffset = RobotConstants.ElevatorRangeOffset;
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
        if (measurement != null && measurement.status == LaserCan.LASERCAN_STATUS_VALID_MEASUREMENT) {
            System.out.println("The target is " + measurement.distance_mm + "mm away!");
        } else {
            System.out.println("Oh no! The target is out of range, or we can't get a reliable measurement!");
            // You can still use distance_mm in here, if you're ok tolerating a clamped
            // value or an unreliable measurement.
        }
        if ((measurement.distance_mm) < (lcGoal - rangeOffset)) {
            this.goUp();
        } else if ((measurement.distance_mm) >= (lcGoal + rangeOffset) && (measurement.distance_mm) >= RobotConstants.lcSlowZone) {
            this.goDown();
        } else if ((measurement.distance_mm) < (lcGoal + rangeOffset) && (measurement.distance_mm) < RobotConstants.lcSlowZone) {
         this.goDownSlow();
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
        if (measurement != null && measurement.status == LaserCan.LASERCAN_STATUS_VALID_MEASUREMENT) {
            System.out.println("The target is " + measurement.distance_mm + "mm away!");
        } else {
            System.out.println("Oh no! The target is out of range, or we can't get a reliable measurement!");
            // You can still use distance_mm in here, if you're ok tolerating a clamped
            // value or an unreliable measurement.
        }
        if ((measurement.distance_mm) < (lcGoal - rangeOffset)) {
            this.goUp();
            return false;
        } else if ((measurement.distance_mm) >= (lcGoal + rangeOffset) && (measurement.distance_mm) >= RobotConstants.lcSlowZone) {
            this.goDown();
            return false;
        } else if ((measurement.distance_mm) < (lcGoal + rangeOffset) && (measurement.distance_mm) < RobotConstants.lcSlowZone) {
         this.goDownSlow();
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
        LaserCan.Measurement measurement = lc.getMeasurement();
        if ((measurement.distance_mm) >= RobotConstants.lcSlowZone)
        ElevatorMotor.set(RobotConstants.ElevatorDownSpeed);
        else
        ElevatorMotor.set(RobotConstants.ElevatorDownSlowSpeed);
    }

    public void goDownSlow() {
        ElevatorMotor.set(RobotConstants.ElevatorDownSpeed * 0.33);
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
    }
}