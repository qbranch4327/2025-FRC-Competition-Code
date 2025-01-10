package frc.robot.subsystems;

// import com.revrobotics.CANSparkFlex;
// import com.revrobotics.CANSparkLowLevel.MotorType;
// import com.revrobotics.SparkPIDController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.config.*;
import com.revrobotics.spark.SparkFlex;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Robot;
import frc.robot.RobotConstants;

public class CoralintakeSubsystem extends SubsystemBase {
    
    SparkFlex intakeMotor;
    public DigitalInput sensor;

    public CoralintakeSubsystem()    {
        intakeMotor = new SparkFlex(RobotConstants.CoralIntakeCANid, com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless);
        sensor = new DigitalInput(RobotConstants.CoralIntakeSensorDIOid);

        // SparkPIDController intakemotorPID = intakeMotor.getPIDController();
        // intakemotorPID.setP(RobotConstants.CoralIntakemotorP);
        // intakemotorPID.setI(RobotConstants.CoralIntakemotorI);
        // intakemotorPID.setD(RobotConstants.CoralIntakemotorD);
        // intakemotorPID.setFF(RobotConstants.CoralIntakemotorFF);

    }

    public void intakeOn(boolean forward)  {
        if (forward)    {
            intakeMotor.set(RobotConstants.CoralIntakeOnspeed);
        }
        else {
            intakeMotor.set(RobotConstants.CoralIntakeOutspeed);
        }
    }
    
    public void intakeOff() {
        intakeMotor.stopMotor();
    }


    public void intakeSlow(boolean forward)  {
        if (forward)    {
            intakeMotor.set(RobotConstants.CoralIntakeSlowspeed);
        }
        else    {
            intakeMotor.set(-RobotConstants.CoralIntakeSlowspeed);
        }
    }

}