package org.usfirst.frc.team4131.robot;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;



import org.usfirst.frc.team4131.robot.subsystems.AimingFlashlight;
import org.usfirst.frc.team4131.robot.subsystems.Arms;
import org.usfirst.frc.team4131.robot.subsystems.Collector;
import org.usfirst.frc.team4131.robot.subsystems.Handler;
import org.usfirst.frc.team4131.robot.subsystems.Sensors;
import org.usfirst.frc.team4131.robot.subsystems.Shooter;
import org.usfirst.frc.team4131.robot.subsystems.TankDrive;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static double CURRENT_X;
	public static double CURRENT_Y;
	public static double CURRENT_ANGLE;


	public static Sensors sensors;
	public static TankDrive drive;
	public static Handler handler;
	public static Shooter shooter;
	public static Collector collector;
	public static Arms arms;
	public static OI oi;
	public static AimingFlashlight flashlight;




	public Robot() {
		super();
		String whoami = null;
		byte[] buffer = null;
		Path configPath = FileSystems.getDefault().getPath(RobotMap.CONFIG_FILENAME);
		try {
			buffer = Files.readAllBytes(configPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (buffer != null) {
			whoami = new String(buffer);
			RobotMap.ROBOT_TYPE = RobotMap.robotType(whoami);
		}

	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		if (RobotMap.ROBOT_TYPE == RobotMap.ELECT_BOT_NUM) {
			// electricalBot Code
		} else {

			sensors = new Sensors();
			drive = new TankDrive();
			handler = new Handler();
			shooter = new Shooter();
			collector = new Collector();
			arms = new Arms();
			flashlight = new AimingFlashlight();
//			pdp = new PowerDistributionPanel(RobotMap.PDP);
			
			oi = new OI();


			
			SmartDashboard.putNumber("TARGET RPM", 4500);
		}
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		dashboard();

	}

	

	/**
	 * This function is called periodically during autonomous
	 */
	

	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		dashboard();

	}

	public void testInit() {

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		Scheduler.getInstance().run();
		dashboard();

	}

	public static double constrain(double value, double min, double max) {
		double trueMin = Math.min(min, max), trueMax = Math.max(min, max);
		return Math.min(Math.max(value, trueMin), trueMax);
	}

	private void dashboard() {
		if (RobotMap.ROBOT_TYPE == RobotMap.ELECT_BOT_NUM) {
			// electricalBot Code
		} else {
			SmartDashboard.putNumber("Handler Speed", handler.getSpeed());
			SmartDashboard.putNumber("Arms Angle", arms.getAngle());
			SmartDashboard.putNumber("Snooter Speed", shooter.getRate());
			SmartDashboard.putNumber("Shooter Command", shooter.getSpeed());
			
			SmartDashboard.putBoolean("Ball Captured", handler.isCaptured());
			SmartDashboard.putNumber("Drive Distance", drive.getDistance());
			SmartDashboard.putBoolean("Arms Stowed", arms.isStowed());
			SmartDashboard.putNumber("Gyro Angle", sensors.getAngle());
			SmartDashboard.putNumber("Arm Speed", arms.getSpeed());
			SmartDashboard.putNumber("Robot X", CURRENT_X);
			SmartDashboard.putNumber("Robot Y", CURRENT_Y);
			SmartDashboard.putNumber("Collector Speed", collector.get());
			SmartDashboard.putBoolean("Flashlight State", flashlight.get());
			SmartDashboard.putNumber("Right Tread Command", drive.getRightCommand());
			SmartDashboard.putNumber("Left Tread Command", drive.getLeftCommand());
			SmartDashboard.putNumber("Right Encoder", drive.getRightEncoder());
			SmartDashboard.putNumber("Left Encoder", drive.getLeftEncoder());
		}	
	}
}