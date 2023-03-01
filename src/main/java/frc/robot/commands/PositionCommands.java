package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DropSubsystem;
import frc.robot.subsystems.LeadScrewSubsystem;
import edu.wpi.first.wpilibj.Timer;

//this is atest
public final class PositionCommands {
  public static Command startCommands(ArmSubsystem arm, LeadScrewSubsystem leadScrew, DropSubsystem drop, ClawSubsystem claw) {
    return Commands.sequence(
      Commands.runOnce(() -> arm.wristIn(), arm),    
    Commands.runOnce(() -> arm.bicepIn(), arm),
        Commands.runOnce(() -> arm.forearmIn(), arm),
        Commands.runOnce(() -> leadScrew.move_to_bottom(), leadScrew),
        Commands.runOnce(() -> arm.wristIn(), arm),
        Commands.runOnce(() -> drop.dropin(), drop),
        Commands.runOnce(()->claw.CloseClaw(), claw));
  }

  public static Command pickupoffloorCommand(ArmSubsystem arm, LeadScrewSubsystem leadScrew) {

    return Commands.sequence(
      Commands.runOnce(() -> arm.wristOut(), arm),    
    Commands.runOnce(() -> arm.bicepIn(), arm),
        Commands.runOnce(() -> arm.forearmIn(), arm),
        Commands.runOnce(() -> arm.wristOut(), arm),
        Commands.runOnce(() -> leadScrew.move_to_bottom(), leadScrew));
  }

  // public static Command midbarCommand(ArmSubsystem arm, LeadScrewSubsystem
  // leadScrew) {
  // return Commands.sequence(
  // Commands.runOnce(() -> arm.forearmOut(), arm),
  // Commands.runOnce(() -> arm.bicepin(), arm),
  // Commands.runOnce(() -> leadScrew.move_to_position_2(), leadScrew),
  // // Commands.runOnce(() -> arm.wristIn(), arm));
  // }

  public static Command shelfCommand(ArmSubsystem arm, LeadScrewSubsystem leadScrew) {
    return Commands.sequence(
      Commands.runOnce(() -> arm.wristOut(), arm),    
    Commands.runOnce(() -> arm.forearmOut(), arm),
        Commands.runOnce(() -> arm.bicepout(), arm),
        Commands.runOnce(() -> leadScrew.move_to_position_2(), leadScrew),
        Commands.runOnce(() -> arm.wristIn(), arm));

  }

  public static Command HighbarCommand(ArmSubsystem arm, LeadScrewSubsystem leadScrew) {
    return Commands.sequence(
        Commands.runOnce(() -> arm.forearmOut(), arm),
        Commands.runOnce(() -> arm.wristIn(), arm),
        Commands.runOnce(() -> arm.bicepout(), arm),
        Commands.runOnce(() -> Timer.delay(1.5)),
        Commands.runOnce(() -> leadScrew.move_to_position_3(), leadScrew));
  }

}
