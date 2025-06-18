package pedroPathing.Auto;

import com.pedropathing.follower.Follower;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.PathBuilder;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

@Autonomous
public class PedroPathing3SampleAuto extends OpMode {

    //Constant Values
    private Follower follower;
    private int pathIndex = 0;
    private PathChain[] pathChains;


    public static PathBuilder builder = new PathBuilder();

    public static PathChain line1 = builder
            .addPath(
                    new BezierLine(
                            new Point(11.300, 83.613, Point.CARTESIAN),
                            new Point(28.037, 107.502, Point.CARTESIAN)
                    )
            )
            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
            .build();

    public static PathChain line2 = builder
            .addPath(
                    new BezierLine(
                            new Point(28.037, 107.502, Point.CARTESIAN),
                            new Point(61.051, 108.000, Point.CARTESIAN)
                    )
            )
            .setTangentHeadingInterpolation()
            .build();

    public static PathChain line3 = builder
            .addPath(
                    new BezierLine(
                            new Point(61.051, 108.000, Point.CARTESIAN),
                            new Point(60.055, 118.618, Point.CARTESIAN)
                    )
            )
            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
            .build();

    public static PathChain line4 = builder
            .addPath(
                    new BezierLine(
                            new Point(60.055, 118.618, Point.CARTESIAN),
                            new Point(14.599, 123.097, Point.CARTESIAN)
                    )
            )
            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(-10))
            .build();

    public static PathChain line5 = builder
            .addPath(
                    new BezierLine(
                            new Point(14.599, 123.097, Point.CARTESIAN),
                            new Point(57.899, 122.599, Point.CARTESIAN)
                    )
            )
            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
            .build();

    public static PathChain line6 = builder
            .addPath(
                    new BezierLine(
                            new Point(57.899, 122.599, Point.CARTESIAN),
                            new Point(59.392, 131.889, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(0))
            .build();

    public static PathChain line7 = builder
            .addPath(
                    new BezierLine(
                            new Point(59.392, 131.889, Point.CARTESIAN),
                            new Point(19.078, 133.051, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(0))
            .build();

    public static PathChain line8 = builder
            .addPath(
                    new BezierLine(
                            new Point(19.078, 133.051, Point.CARTESIAN),
                            new Point(56.406, 131.889, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(0))
            .build();

    public static PathChain line9 = builder
            .addPath(
                    new BezierLine(
                            new Point(56.406, 131.889, Point.CARTESIAN),
                            new Point(60.221, 135.207, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(0))
            .build();

    public static PathChain line10 = builder
            .addPath(
                    new BezierLine(
                            new Point(60.221, 135.207, Point.CARTESIAN),
                            new Point(19.576, 136.369, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(0))
            .build();

    public static PathChain line11 = builder
            .addPath(
                    new BezierCurve(
                            new Point(19.576, 136.369, Point.CARTESIAN),
                            new Point(69.014, 134.212, Point.CARTESIAN),
                            new Point(62.378, 95.889, Point.CARTESIAN)
                    )
            )
            .setTangentHeadingInterpolation()
            .build();


    @Override
    public void init() {
        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);

        pathChains = new PathChain[]{
                line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11
        };


    }

    @Override
    public void loop() {

        // Always update follower
        follower.update();

        // If done with current path and more paths remain, go to next
        if (!follower.isBusy() && pathIndex < pathChains.length - 1) {
            pathIndex++;
            follower.followPath(pathChains[pathIndex]);
        }

    }



}
