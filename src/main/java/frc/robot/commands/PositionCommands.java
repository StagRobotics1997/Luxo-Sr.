package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DropSubsystem;
import frc.robot.subsystems.LeadScrewSubsystem;

//this is atest
public final class PositionCommands {
  public static Command startCommands(ArmSubsystem arm, LeadScrewSubsystem leadScrew, DropSubsystem drop) {
    return Commands.parallel(
        Commands.runOnce(() -> leadScrew.move_to_bottom(), leadScrew),
        Commands.sequence(
            Commands.runOnce(() -> arm.bicepIn(), arm),
            Commands.runOnce(() -> arm.forearmIn(), arm),
            Commands.runOnce(() -> arm.wristOut(), arm),
            Commands.runOnce(() -> drop.dropin(), drop)));
  }

  public static Command pickupoffloorCommand(ArmSubsystem arm, LeadScrewSubsystem leadScrew) {
    return Commands.parallel(
        Commands.runOnce(() -> leadScrew.move_to_position_1(), leadScrew),
        Commands.sequence(
            Commands.runOnce(() -> arm.bicepIn(), arm),
            Commands.runOnce(() -> arm.forearmIn(), arm),
            Commands.runOnce(() -> arm.wristOut(), arm)));
  }

  public static Command midbarCommand(ArmSubsystem arm, LeadScrewSubsystem leadScrew) {
    return Commands.parallel(
        Commands.runOnce(() -> leadScrew.move_to_position_2(), leadScrew),
        Commands.sequence(
            Commands.runOnce(() -> arm.bicepIn(), arm),
            Commands.runOnce(() -> arm.forearmOut(), arm),
            Commands.runOnce(() -> arm.wristIn(), arm)));
  }

  public static Command shelfCommand(ArmSubsystem arm, LeadScrewSubsystem leadScrew) {
    return Commands.parallel(
        Commands.runOnce(() -> leadScrew.move_to_position_2(), leadScrew),
        Commands.sequence(
            Commands.runOnce(() -> arm.bicepIn(), arm),
            Commands.runOnce(() -> arm.forearmOut(), arm),
            Commands.runOnce(() -> arm.wristOut(), arm)));
  }

  public static Command HighbarCommand(ArmSubsystem arm, LeadScrewSubsystem leadScrew) {
    return Commands.parallel(
        Commands.runOnce(() -> leadScrew.move_to_top(), leadScrew),
        Commands.sequence(
            Commands.runOnce(() -> arm.forearmOut(), arm),
            Commands.runOnce(() -> arm.wristOut(), arm),
            Commands.runOnce(() -> arm.bicepout(), arm)));
  }

}
