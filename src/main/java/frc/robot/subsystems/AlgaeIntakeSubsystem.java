package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.config.*;
import com.revrobotics.spark.SparkFlex;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Robot;
import frc.robot.RobotConstants;

public class AlgaeIntakeSubsystem extends SubsystemBase {
    
    SparkFlex intakeMotor;

    public AlgaeIntakeSubsystem()    {
        intakeMotor = new SparkFlex(RobotConstants.AlgaeIntakeCANid, com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless);

        // SparkPIDController intakemotorPID = intakeMotor.getPIDController();
        // intakemotorPID.setP(RobotConstants.intakemotorP);
        // intakemotorPID.setI(RobotConstants.intakemotorI);
        // intakemotorPID.setD(RobotConstants.intakemotorD);
        // intakemotorPID.setFF(RobotConstants.intakemotorFF);

    }

    public void AlgaeIntakeOn(boolean forward)  {
        if (forward)    {
            intakeMotor.set(RobotConstants.AlgaeIntakeOnspeed);
        }
        else {
            intakeMotor.set(RobotConstants.AlgaeIntakeOutspeed);
        }
    }
    
    public void AlgaeIntakeOff() {
        intakeMotor.stopMotor();
    }


    public void AlgaeIntakeSlow(boolean forward)  {
        if (forward)    {
            intakeMotor.set(RobotConstants.AlgaeIntakeSlowspeed);
        }
        else    {
            intakeMotor.set(-RobotConstants.AlgaeIntakeSlowspeed);
        }
    }

}