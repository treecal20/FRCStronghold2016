package org.usfirst.frc.team4131.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	/**
	 * Ports for motor controllers, encoders, etc
	 */
	public static final int LEFT_JOYSTICK = 0;
	
	public static final int RIGHT_JOYSTICK = 0;

	public static final int HANDLER_MOTOR = 0;

	public static final int SHOOTER_MOTOR = 0;

	public static final int SHOOTER_ENCODER_A = 0;

	public static final int SHOOTER_ENCODER_B = 0;

	public static final int DRIVE_LEFT_MOTOR1 = 0;

	public static final int DRIVE_LEFT_MOTOR2 = 0;

	public static final int DRIVE_RIGHT_MOTOR1 = 0;

	public static final int DRIVE_RIGHT_MOTOR2 = 0;

	public static final int DRIVE_LEFT_ENCODERA = 0;

	public static final int DRIVE_LEFT_ENCODERB = 0;

	public static final int DRIVE_RIGHT_ENCODERA = 0;

	public static final int DRIVE_RIGHT_ENCODERB = 0;
	
	public static final int GYRO = 0;
	
	public static final int LIGHT = 11;

	public static final int ARMS_ENCODERB = 0;

	public static final int ARMS_SWITCH = 0;	//switch that tells 
	
	public static final int COLLECTOR_MOTOR = 0;//rolling pin motor
	/**
	 * Joystick mappings
	 */
	public static final int LOAD = 1;			//right joystick, the trigger one
	
	public static final int UNLOAD = 1;			//launchpad, the unload button
	
	public static final int PORTCULLIS = 2;		//launchpad, the portcullis button
	
	public static final int COLLECT_BOULDER = 3;		//launchpad, the collect button
	
	public static final int DEPLOY_ARMS = 4;	//launchpad, the deploy arms button
	
	public static final int CANCEL_ARMS = 5;	//launchpad, the cancel arms button
	
	public static final int STOW_ARMS = 6;		//launchpad, the stow arms button
}
