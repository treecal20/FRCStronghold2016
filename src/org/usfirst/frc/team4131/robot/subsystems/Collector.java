package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
	private SpeedController motor;
	
	public Collector()
	{
		motor = new CANTalon(RobotMap.COLLECTOR_MOTOR);
	}
	
	public void spin(double speed)
	{
		motor.set(speed);
	}

    public void initDefaultCommand() {
    }
}

