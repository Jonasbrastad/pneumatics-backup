// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Controller;
import frc.robot.subsystems.Pneumatic;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtendPneumatic extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Pneumatic pneumatic;
  private Controller controller;

  public ExtendPneumatic(Pneumatic subsystem, Controller controller) {
    pneumatic = subsystem;
    this.controller = controller;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (controller.getThrottleFwd() > 0.25) {
      pneumatic.extendPiston();
    }
    else if (controller.getThrottleFwd() < 0.25) {
      pneumatic.reversePiston();
    }
    else {
      pneumatic.stopPiston();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
