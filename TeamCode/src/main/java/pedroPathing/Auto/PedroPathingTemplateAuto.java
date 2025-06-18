package pedroPathing.Auto;

import com.pedropathing.follower.Follower;
import com.pedropathing.pathgen.*;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

@Autonomous(name = "Pedro Pathing Template")
public class PedroPathingTemplateAuto extends OpMode {

    private Follower follower;
    private int pathIndex = 0;
    private PathChain[] pathChains;

    // Path builder instance
    public static PathBuilder builder = new PathBuilder();

    // Define paths (you can rename/expand these)
    public static PathChain path1 = builder
            .addPath(new BezierLine(
                    new Point(0, 0, Point.CARTESIAN),
                    new Point(24, 0, Point.CARTESIAN)
            ))
            .setConstantHeadingInterpolation(Math.toRadians(0))
            .build();

    public static PathChain path2 = builder
            .addPath(new BezierLine(
                    new Point(24, 0, Point.CARTESIAN),
                    new Point(24, 24, Point.CARTESIAN)
            ))
            .setTangentHeadingInterpolation()
            .build();

    @Override
    public void init() {
        // Create Follower with your constants
        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);

        // List of all paths to run in order
        pathChains = new PathChain[]{
                path1,
                path2
        };

        // Start the first path
        follower.followPath(pathChains[0]);
    }

    @Override
    public void loop() {
        // Update the follower every cycle
        follower.update();

        // Move to the next path when the current finishes
        if (!follower.isBusy() && pathIndex < pathChains.length - 1) {
            pathIndex++;
            follower.followPath(pathChains[pathIndex]);
        }
    }
}
