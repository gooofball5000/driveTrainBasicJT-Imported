// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Const;

public class driveTrainSubsystemA extends SubsystemBase {

  // Imports the motor controllers
  CANSparkMax leftFrontMotor = new CANSparkMax(Const.DriveTrainConstants.leftFrontCANID,CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax leftBackMotor = new CANSparkMax(Const.DriveTrainConstants.leftBackCANID,CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightFrontMotor = new CANSparkMax(Const.DriveTrainConstants.rightFrontCANID,CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightBackMotor = new CANSparkMax(Const.DriveTrainConstants.rightBackCANID,CANSparkMaxLowLevel.MotorType.kBrushless);


  RelativeEncoder leftEncoder = leftFrontMotor.getEncoder();
  RelativeEncoder rightEncoder = rightFrontMotor.getEncoder();

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightFrontMotor, rightBackMotor);

  DifferentialDrive differentialDrive = new DifferentialDrive(rightControllerGroup, leftControllerGroup);

  /** Creates a new ExampleSubsystem. */
  public driveTrainSubsystemA() {
    // 0s out the motors
    leftFrontMotor.restoreFactoryDefaults();
    leftBackMotor.restoreFactoryDefaults();
    rightFrontMotor.restoreFactoryDefaults();
    rightBackMotor.restoreFactoryDefaults();

    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);

    
    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    rightControllerGroup.setInverted(true);
    leftControllerGroup.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
