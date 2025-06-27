package pedroPathing.constants;

import com.pedropathing.localization.*;
import com.pedropathing.localization.constants.*;

public class LConstants {
    static {
        ThreeWheelConstants.forwardTicksToInches = 0.2926;
        ThreeWheelConstants.strafeTicksToInches = -0.0217;
        ThreeWheelConstants.turnTicksToInches = -0.0005;
        ThreeWheelConstants.leftY = 1; //inches from center of robot
        ThreeWheelConstants.rightY = -1; //inches from center of robot
        ThreeWheelConstants.strafeX = -2.5; //inches from center of robot
        ThreeWheelConstants.leftEncoder_HardwareMapName = "FL";
        ThreeWheelConstants.rightEncoder_HardwareMapName = "BR";
        ThreeWheelConstants.strafeEncoder_HardwareMapName = "FR";
        ThreeWheelConstants.leftEncoderDirection = Encoder.FORWARD; //FL
        ThreeWheelConstants.rightEncoderDirection = Encoder.REVERSE; //BR
        ThreeWheelConstants.strafeEncoderDirection = Encoder.FORWARD; //FR
    }
}




