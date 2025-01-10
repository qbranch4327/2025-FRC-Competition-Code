package frc.robot;

public class RobotConstants {
    
    //Elevator Constants
    //CAN, PWM, DIO values for motors, encoders, and sensors - Motor for moving elevator up and down
    public final static int ElevatorMotorCANid = 45;
    public final static int ElevatorEncoderDIOidA = 5;
    public final static int ElevatorEncoderDIOidB = 6;

    //Elevator Values for encoders - Offsets used to make end values between 0 and 1
    public final static double ElevatorEncoderOffset = 20.00;
    public final static double ElevatorRangeOffset = 1.00;

    //Elevator PID Values for Motors
    public final static double ElevatorMotorP = 0;
    public final static double ElevatorMotorI = 0;
    public final static double ElevatorMotorD = 0;
    public final static double ElevatorMotorFF = 0;

    //Elevator Power values for motors
    public final static double ElevatorUpSpeed = -0.50;
    public final static double ElevatorDownSpeed = 1.00;
    public final static double ElevatorOffSpeed = 0.00;

    //Elevator Values for encoders - Offsets used to make end values between 0 and 1

    public final static double HomeValue = 0.0;
    public final static double HomeValueExtreme = -50.0;
    public final static double L1Value = 200.0;
    public final static double L1HighExtreme = 220.0;
    public final static double L2Value = 1000.0;
    public final static double L2HighExtreme = 1100.0;
    public final static double L3Value = 2000.0;
    public final static double L3HighExtreme = 2100.0;
    public final static double L4Value = 4000.0;
    public final static double L4HighExtreme = 4100.0;

    //Algae Wrist Constants
    //CAN, PWM, DIO values for motors, encoders, and sensors - Motor moving the Algae Intake in/out of robot
    public final static int AlgaeWristmotorCANid = 25;
    public final static int AlgaeWristEncoderDIOid = 1;

    //Algae Wrist PID Values for Motors
    public final static double AlgaeWristmotorP = 0;
    public final static double AlgaeWristmotorI = 0;
    public final static double AlgaeWristmotorD = 0;
    public final static double AlgaeWristmotorFF = 0;

    //Algae Wrist Values for encoders - Offsets used to make end values between 0 and 1
    public final static double AlgaeWristencoderOffset = 0.30;
    public final static double AlgaeWristrangeOffset = 0.015;

    //Algae Wrist Power values for motors
    public final static double AlgaeWristExtendpower = 0.20;
    public final static double AlgaeWristRetractpower = -0.20;

    //Algae Intake Constants
    //CAN, PWM, DIO values for motors, encoders, and sensors - Motor Spinning Wheels on Algae Intake
    public final static int AlgaeIntakeCANid = 22;

    //Algae Intake PID Values for Motors
    public final static double AlgaeIntakemotorP = 0;
    public final static double AlgaeIntakemotorI = 0;
    public final static double AlgaeIntakemotorD = 0;
    public final static double AlgaeIntakemotorFF = 0;

    //Algae Intake Power values for motors
    public final static double AlgaeIntakeOnspeed = -0.40;
    public final static double AlgaeIntakeOutspeed = 1.00;
    public final static double AlgaeIntakeSlowspeed = -0.2;

    //Extendo Constants
    //CAN, PWM, DIO values for motors, encoders, and sensors - REV Linear Actuator
    public final static int ExtendoMotorCANid = 40;
    public final static int ExtendoEncoderDIOidA = 3;
    public final static int ExtendoEncoderDIOidB = 4;

    //Extendo Values for encoders - Offsets used to make end values between 0 and 1
    public final static double ExtendoEncoderOffset = 20.00;
    public final static double ExtendoRangeOffset = 1.00;
    public final static double ExtendoExtend = 1000;
    public final static double ExtendoRetract = 0.0;

    //Extendo PID Values for Motors
    public final static double ExtendoMotorP = 0;
    public final static double ExtendoMotorI = 0;
    public final static double ExtendoMotorD = 0;
    public final static double ExtendoMotorFF = 0;

    //Extendo Power values for motors
    public final static double ExtendoExtendSpeed = -0.50;
    public final static double ExtendoRetractSpeed = 1.00;
    public final static double ExtendoOffSpeed = 0.00;

    //Coral Intake Constants
    //CAN, PWM, DIO values for motors, encoders, and sensors - Motor Spinning Wheels on Algae Intake
    public final static int CoralIntakeCANid = 28;
    public final static int CoralIntakeSensorDIOid = 7;

    //Algae Intake PID Values for Motors
    public final static double CoralIntakemotorP = 0;
    public final static double CoralIntakemotorI = 0;
    public final static double CoralIntakemotorD = 0;
    public final static double CoralIntakemotorFF = 0;

    //Algae Intake Power values for motors
    public final static double CoralIntakeOnspeed = -0.80;
    public final static double CoralIntakeOutspeed = 1.00;
    public final static double CoralIntakeSlowspeed = -0.2;

    //LED Values
    public final static double LEDintakesensor = 0.65;
    public final static double LEDshootersensor = 0.73;
    public final static double LEDdefault = 0.57;

}
