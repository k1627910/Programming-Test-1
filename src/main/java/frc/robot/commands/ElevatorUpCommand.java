package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.elevator.ElevatorSubsystem;

public class ElevatorUpCommand extends Command {
  private final ElevatorSubsystem elevatorSubsystem;

  public ElevatorUpCommand(ElevatorSubsystem elevatorSubsystem) {
    this.elevatorSubsystem = elevatorSubsystem;
    addRequirements(elevatorSubsystem);
  }

  @Override
  public void initialize() {
    elevatorSubsystem.setMotorSpeed(0);
  }

  @Override
  public void execute() {
    elevatorSubsystem.setMotorSpeed(0.1);
  }

  @Override
  public void end(boolean interrupted) {
    elevatorSubsystem.setMotorSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
