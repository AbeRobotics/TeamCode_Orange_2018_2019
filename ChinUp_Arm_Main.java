import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Basic Mineral Arm Main", group="LinearOpMode")

public class ChinUp_Arm_Main extends OpMode
{
    DcMotor chinUpArm;

    double chinUpArmPower;

    @Override
    public void init()
    {
    chinUpArm = hardwareMap.dcMotor.get("chinup_arm");
    }

    @Override
    public void loop()
    {
        chinUpArm.setPower(0);

        if (gamepad1.a = true)
        {
            chinUpArmPower = 0.5;
            chinUpArm.setPower(chinUpArmPower);
        }
        if (gamepad1.y = true)
        {
            chinUpArmPower = 0.5;
            chinUpArm.setPower(-1 * chinUpArmPower);
        }
    }
}
