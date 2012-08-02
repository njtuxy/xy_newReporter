package org.uncommons.reportng;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class XYTestNgHtmlReport implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		String class_name = result.getTestClass().getRealClass().getName();
		String pic_name = class_name + "." + testName + ".jpg";

		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedImage img = robot.createScreenCapture(new Rectangle(size));
		try {
			ImageIO.write(img, "JPG", new File("test-output/html/" + pic_name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getName();
		String class_name = result.getTestClass().getRealClass().getName();
		String pic_name = class_name + "." + testName + ".jpg";

		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedImage img = robot.createScreenCapture(new Rectangle(size));
		try {
			ImageIO.write(img, "JPG", new File("test-output/html/" + pic_name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
