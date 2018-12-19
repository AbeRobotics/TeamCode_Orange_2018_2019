import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by arr on 28/11/18.
 */

@TeleOp(name="Accelerating wheels drive", group="LinearOpMode")

public class Acceleration_Wheel_Controls_Main extends OpMode
{
    DcMotor leftWheel;
    DcMotor rightWheel;

    double leftWheelPower;
    double rightWheelPower;

    @Override
    public void init()
    {
        leftWheel = hardwareMap.dcMotor.get("left_wheel");
        rightWheel = hardwareMap.dcMotor.get("right_wheel");
        rightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop()
    {
        leftWheelPower = gamepad1.left_stick_y;
        rightWheelPower = gamepad1.right_stick_y;

        leftWheel.setPower(leftWheelPower);
        rightWheel.setPower(rightWheelPower);
        int timeToAccelerate = 2000; // milliseconds
        int speedIncrements = 10;
        double sizeOfIncrements = 1/speedIncrements;
        int leftCount = 1;
        int rightCount = 1;
        int test = 1;

        while (leftWheelPower != 0)
        {
            leftWheel.setPower(leftWheelPower/Math.abs(leftWheelPower) * sizeOfIncrements * leftCount);
            if (leftCount < speedIncrements)
            {
                leftCount++;
                try
                {
                    Thread.sleep(timeToAccelerate/speedIncrements);
                } catch (Exception e) {}
            }
        }
        while (rightWheelPower != 0)
        {
            rightWheel.setPower(rightWheelPower/Math.abs(rightWheelPower) * sizeOfIncrements * rightCount);
            if (rightCount < speedIncrements)
            {
                rightCount++;
                try
                {
                    Thread.sleep(timeToAccelerate/speedIncrements);
                } catch (Exception e) {}
            }
        }
        if (leftWheelPower == 0)
        {
            leftCount = 1;
        }
        if (rightWheelPower == 0)
        {
            rightCount = 1;
        }
    }
}
