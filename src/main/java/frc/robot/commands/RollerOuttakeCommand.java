package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.roller.RollerSubsystem;

public class RollerOuttakeCommand extends Command {
  private final RollerSubsystem rollerSubsystem;

  public RollerOuttakeCommand(RollerSubsystem rollerSubsystem) {
    this.rollerSubsystem = rollerSubsystem;
    addRequirements(rollerSubsystem);
  }

  /**
   * 4 methods of command
   *
   * <p>initialize - first called, starts everything
   *
   * <p>execute - ***main body of the command***, looped every 20 ms
   *
   * <p>end - what happens at the end of the command
   *
   * <p>isfinished - decides when command should end
   *
   * <p>All inherited from Command class
   */
  @Override
  public void initialize() {
    rollerSubsystem.setMotorSpeed(0);
  } // once

  @Override
  public void execute() {
    rollerSubsystem.setMotorSpeed(-0.5);
  } // lots of times run

  @Override
  public void end(boolean interrupted) {
    rollerSubsystem.setMotorSpeed(0);
  } // once

  @Override
  public boolean isFinished() {
    return false;
  } // lots of times
}
