package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj.Timer;

public class auto2 extends SequentialCommandGroup {
    public auto2(DrivetrainSubsystem drive, DropSubsystem drop, ClawSubsystem claw) {
        addCommands(
                Commands.runOnce(() -> drive.resetGyroscope(), drive),
                Commands.waitSeconds(1),
                new InstantCommand(() -> drop.dropout(), drop),
                Commands.waitSeconds(1),
                Commands.runOnce(() -> claw.OpenClaw(), claw),
                Commands.waitSeconds(5),
                new StartEndCommand(() -> drive.stickDrive(-.5, .0, .0),
                        () -> drive.stickDrive(0.0, .0, .0), drive).withTimeout(2),
                Commands.runOnce(() -> claw.OpenClaw(), claw));
    }
}