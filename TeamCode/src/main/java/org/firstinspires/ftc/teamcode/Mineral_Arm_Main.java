import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Basic Mineral Arm Main", group="LinearOpMode")

public class Mineral_Arm_Main extends OpMode
{
    DcMotor clawArm;
    DcMotor clawElbow;

    double clawArmPower;
    double clawElbowPower;

    @Override
    public void init()
    {
        clawArm = hardwareMap.dcMotor.get("claw_arm");
        clawElbow = hardwareMap.dcMotor.get("claw_elbow");
    }

    @Override
    public void loop()
    {
        if(gamepad1.left_trigger > 0.01 && gamepad1.right_trigger > 0.01)
        {
            clawArm.setPower(0);
        }
        if(gamepad1.left_trigger > 0.01 && gamepad1.right_trigger == 0)
        {
            clawArmPower = gamepad1.left_trigger;
            clawArm.setPower(clawArmPower);
        }
        if(gamepad1.right_trigger > 0.01 && gamepad1.left_trigger == 0)
        {
            clawArmPower = gamepad1.right_trigger;
            clawArm.setPower(-1 * clawArmPower);
        }

        if(gamepad1.left_bumper == true && gamepad1.right_bumper == true)
        {
            clawElbow.setPower(0);
        }
        if(gamepad1.left_bumper == true && gamepad1.right_bumper == false)
        {
            clawElbowPower = 0.5;
            clawElbow.setPower(clawElbowPower);
        }
        if(gamepad1.right_bumper == true && gamepad1.left_bumper == false)
        {
            clawElbowPower = 0.5;
            clawElbow.setPower(-1 * clawElbowPower);
        }
    }
}
