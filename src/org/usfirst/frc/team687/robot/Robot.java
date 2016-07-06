
package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author: Isaac
 */
public class Robot extends IterativeRobot {
	Victor lf,lb,rf,rb;
	Joystick leftJoy, rightJoy;
	Double forwardMovement, strafeMovement, rotateMovement;
	Double lfValue, lbValue, rfValue, rbValue;
    public void robotInit() {
    	leftJoy = new Joystick(1);
    	rightJoy = new Joystick(2);
    	lf = new Victor(1);
    	lb = new Victor(2);
    	rf = new Victor(3);
    	rb = new Victor(4);
    }
    public void autonomousInit() {

    }

    public void autonomousPeriodic() {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	forwardMovement = leftJoy.getY();
    	strafeMovement = leftJoy.getX();
//    	Dividing by two because the rotate movement is movement in terms of 45 degrees.
    	rotateMovement = leftJoy.getX()/2;
    	
//    	Addition of Joystick Values
    	lfValue = threshold(forwardMovement+strafeMovement+rotateMovement);
    	rfValue = threshold(-forwardMovement+strafeMovement+rotateMovement);
    	lbValue = threshold(forwardMovement-strafeMovement+rotateMovement);
    	rbValue = threshold(-forwardMovement-strafeMovement+rotateMovement);
//    	Set the values!
    	lf.set(lfValue);
    	rf.set(rfValue);
    	lb.set(lbValue);
    	rb.set(rbValue);
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
//    This function is necessary in order to prevent running the motor greater than +1, or less than -1
    public double threshold(double num){
    	if(num>1){
    		return 1;
    	}
    	else if(num<-1){
    		return -1;
    	}
    	else{
    		return num;
    	}
    }
    
}
