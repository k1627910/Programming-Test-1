package frc.robot.subsystems.elevator;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
  /**
   * The elevator subsystem is composed of two motors Kraken x60s.
   *
   * <p>new TalonFX(Constants.IDs.ELEVATOR_RIGHT)
   *
   * <p>the two motors should move in sync but have opposite directions
   *
   * <p>right motor is -0.1 for down, +0.1 for up
   */
  private final TalonFX elevatorLeft;

  private final TalonFX elevatorRight;

  public ElevatorSubsystem() {
    elevatorLeft = new TalonFX(Constants.IDs.ELEVATOR_LEFT, "MainCANivore");
    elevatorRight = new TalonFX(Constants.IDs.ELEVATOR_RIGHT, "MainCANivore");
  }

  public void setMotorSpeed(double speed) {
    elevatorRight.set(speed);
    elevatorLeft.set(-speed);
  }
}
