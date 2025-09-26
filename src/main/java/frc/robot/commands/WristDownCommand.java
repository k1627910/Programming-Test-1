package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.wrist.WristSubsystem;

public class WristDownCommand extends Command {
  private final WristSubsystem wristSubsystem;

  public WristDownCommand(WristSubsystem wristSubsystem) {
    this.wristSubsystem = wristSubsystem;
    addRequirements(wristSubsystem);
  }

  @Override
  public void initialize() {
    wristSubsystem.setMotorSpeed(0);
  }

  @Override
  public void execute() {
    wristSubsystem.setMotorSpeed(-0.1);
  }

  @Override
  public void end(boolean interrupted) {
    wristSubsystem.setMotorSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
