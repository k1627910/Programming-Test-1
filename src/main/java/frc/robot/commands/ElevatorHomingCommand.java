package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.elevator.ElevatorSubsystem;
import static edu.wpi.first.units.Units.*;

/**
 * Bonus exercise: 
 * 
 * The purpose of this command is to "home" the elevator
 * by finding the furthest point downwards that the elevator
 * can go before hitting something else. Since that is always a constant point, we can 
 * use it as a reference for how our measurement of the 
 * rotational position of the elevator motor aligns
 * with the linear position of the elevators. 
 * 
 * This is how we make sure our measurements are always accurate
 * even if (when) our sprockets or power transmission slips
 * and our motors misalign themselves with the elevator.
 */
public class ElevatorHomingCommand extends Command {
    private final ElevatorSubsystem elevatorSubsystem;
  
    public ElevatorHomingCommand(ElevatorSubsystem elevatorSubsystem) {
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
      return elevatorSubsystem.getLeftMotorTorqueCurrent().abs(Amps) > 5
      && MathUtil.isNear(
          0, elevatorSubsystem.getLeftMotoAngularVelocity().in(RotationsPerSecond), 0.2);
    }
  }
  

/**
 * This is the code I used to do this in my rewrite. It's here as a
 * reference for how you're supposed to do this. You shouldn't copy this
 * code directly (and it won't work if you do), but I want you to understand
 * how it functions and then implement it in this project using what you know how to do. 
 * If you want to see what any of these method calls do, this file can be found at
 * 
 * https://github.com/aditya-khambekar/Heart-of-the-Sea-Rewritten/blob/rollback/src/main/java/org/team4639/robot/commands/superstructure/HomingCommand.java
 * 
 *      package org.team4639.robot.commands.superstructure;

        import static edu.wpi.first.units.Units.*;

        import edu.wpi.first.math.MathUtil;
        import edu.wpi.first.math.filter.Debouncer;
        import edu.wpi.first.wpilibj.RobotBase;
        import org.team4639.robot.robot.Subsystems;

        public class HomingCommand extends SuperstructureCommandBase {
            private final Debouncer stoppedDebouncer = new Debouncer(0.2, Debouncer.DebounceType.kRising);

            public HomingCommand() {
                addRequirements(
                    Subsystems.elevator, Subsystems.wrist, Subsystems.roller, Subsystems.superstructure);
            }

            @Override
            public void execute() {
                super.execute();
                Subsystems.elevator.elevatorDown();
            }

            @Override
            public boolean isFinished() {
                return stoppedDebouncer.calculate(
                    RobotBase.isReal()
                        ? Subsystems.elevator.getInputs().leftMotorTorqueCurrent.abs(Amps) > 5
                            && MathUtil.isNear(
                                0, Subsystems.elevator.getMotorSpeed().in(RotationsPerSecond), 0.2)
                        : Subsystems.elevator.getPercentage().in(Value) <= 0);
            }

            @Override
            public void end(boolean interrupted) {
                Subsystems.elevator.zero();
            }

            @Override
            public SuperstructureCommandState getState() {
                return SuperstructureCommandState.HOMING;
            }

            @Override
            public String getName() {
                return "HOMING";
            }
        }
 */
