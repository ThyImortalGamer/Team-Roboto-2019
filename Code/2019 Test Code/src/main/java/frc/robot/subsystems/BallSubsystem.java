/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;
import frc.robot.commands.BallCommand;

/**
 * Add your docs here.
 */
public class BallSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Spark intake;

  Solenoid 
    rightOuttake,
    leftOuttake;

  public BallSubsystem() {
    intake = new Spark(RobotMap.ballIntake);
    intake.setInverted(true);

    leftOuttake = new Solenoid(RobotMap.outtakeLeft);
    rightOuttake = new Solenoid(RobotMap.outtakeRight);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new BallCommand());
  }

  public void intake(double speed) {
    intake.set(speed);
  }

  public void rightOuttake(boolean out) {
    if(out) {
      rightOuttake.set(true);
    } else {
      rightOuttake.set(false);
    }
  }

  public void leftOuttake(boolean out) {
    if(out) {
      leftOuttake.set(true);
    } else {
      leftOuttake.set(false);
    }
  }

  public void stop() {
    intake.set(0);
  }
}
