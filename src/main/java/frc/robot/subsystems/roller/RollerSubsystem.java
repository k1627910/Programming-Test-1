package frc.robot.subsystems.roller;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/** One sparkFlex, positive for coral intake negative for coral outtake */
public class RollerSubsystem extends SubsystemBase {
  private final SparkFlex rollerMotor;

  public RollerSubsystem() {
    rollerMotor = new SparkFlex(Constants.IDs.ROLLER, MotorType.kBrushless);
  }

  public void setMotorSpeed(double speed) {
    rollerMotor.set(speed);
  }
}
