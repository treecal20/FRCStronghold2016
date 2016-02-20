package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.CollectBoulder;
import org.usfirst.frc.team4131.robot.commands.DeployArms;
import org.usfirst.frc.team4131.robot.commands.LoadBoulder;
import org.usfirst.frc.team4131.robot.commands.StowArms;
import org.usfirst.frc.team4131.robot.commands.ToggleLight;
import org.usfirst.frc.team4131.robot.commands.UnloadBoulder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick leftStick;
	private Joystick rightStick;
	private Joystick launchpad;
	
	private Button collectBoulder;
	private Button loadBoulder;
	private Button unloadBoulder;
	private Button stowArms;
	private Button cancelArms;
	private Button deployArms;
	private Button toggleLight;
	
	public OI(){
		leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
		rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);
		launchpad = new Joystick(RobotMap.LAUNCHPAD);
		
//		loadBoulder = new JoystickButton(rightStick, RobotMap.LOAD);
//		loadBoulder.whenPressed(new LoadBoulder());
		
		unloadBoulder = new JoystickButton(launchpad, RobotMap.UNLOAD);
		unloadBoulder.whenPressed(new UnloadBoulder());
		
		collectBoulder = new JoystickButton(launchpad, RobotMap.COLLECT_BOULDER);
		collectBoulder.whenPressed(new CollectBoulder());
		collectBoulder.whenPressed(new DeployArms(700));
		
		cancelArms = new JoystickButton(launchpad, RobotMap.CANCEL_ARMS);
		cancelArms.whenPressed(new DeployArms(Robot.arms.getAngle()));
		cancelArms.cancelWhenPressed(new CollectBoulder());
		
		
		stowArms= new JoystickButton(launchpad, RobotMap.STOW_ARMS);
		stowArms.whenPressed(new StowArms());
		
		deployArms = new JoystickButton(launchpad, RobotMap.DEPLOY_ARMS);
		deployArms.whenPressed(new DeployArms(600));
		
//		toggleLight = new JoystickButton(leftStick, RobotMap.TOGGLE_LIGHT);
//		toggleLight.whenPressed(new ToggleLight());
	}
	public double getLeftSpeed() {
//		return -leftStick.getRawAxis(1);
		return 0;
	}
	public double getRightSpeed() {
//		return -rightStick.getRawAxis(1);
		return 0;
	}
}
