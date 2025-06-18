package pedroPathing.Auto;

import com.pedropathing.follower.Follower;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.PathBuilder;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

@Autonomous
public class PedroPathing3SpecimenAuto extends OpMode{

    //Constant Values
    private Follower follower;
    private int pathIndex = 0;
    private PathChain[] pathChains;

    public static PathBuilder builder = new PathBuilder();

    public static PathChain line1 = builder
            .addPath(
                    new BezierLine(
                            new Point(7.300, 63.373, Point.CARTESIAN),
                            new Point(37.493, 69.512, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(90))
            .setReversed(true)
            .build();

    public static PathChain line2 = builder
            .addPath(
                    new BezierLine(
                            new Point(37.493, 69.512, Point.CARTESIAN),
                            new Point(37.161, 35.005, Point.CARTESIAN)
                    )
            )
            .setTangentHeadingInterpolation()
            .setReversed(true)
            .build();

    public static PathChain line3 = builder
            .addPath(
                    new BezierLine(
                            new Point(37.161, 35.005, Point.CARTESIAN),
                            new Point(62.378, 34.673, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(90))
            .build();

    public static PathChain line4 = builder
            .addPath(
                    new BezierLine(
                            new Point(62.378, 34.673, Point.CARTESIAN),
                            new Point(61.714, 22.728, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(0))
            .build();

    public static PathChain line5 = builder
            .addPath(
                    new BezierLine(
                            new Point(61.714, 22.728, Point.CARTESIAN),
                            new Point(9.954, 22.894, Point.CARTESIAN)
                    )
            )
            .setTangentHeadingInterpolation()
            .setReversed(true)
            .build();

    public static PathChain line6 = builder
            .addPath(
                    new BezierLine(
                            new Point(9.954, 22.894, Point.CARTESIAN),
                            new Point(61.548, 22.562, Point.CARTESIAN)
                    )
            )
            .setTangentHeadingInterpolation()
            .build();

    public static PathChain line7 = builder
            .addPath(
                    new BezierLine(
                            new Point(61.548, 22.562, Point.CARTESIAN),
                            new Point(61.051, 12.442, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(0))
            .build();

    public static PathChain line8 = builder
            .addPath(
                    new BezierLine(
                            new Point(61.051, 12.442, Point.CARTESIAN),
                            new Point(9.954, 13.106, Point.CARTESIAN)
                    )
            )
            .setTangentHeadingInterpolation()
            .setReversed(true)
            .build();

    public static PathChain line9 = builder
            .addPath(
                    new BezierLine(
                            new Point(9.954, 13.106, Point.CARTESIAN),
                            new Point(61.051, 12.442, Point.CARTESIAN)
                    )
            )
            .setTangentHeadingInterpolation()
            .build();

    public static PathChain line10 = builder
            .addPath(
                    new BezierLine(
                            new Point(61.051, 12.442, Point.CARTESIAN),
                            new Point(60.885, 8.793, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(0))
            .build();

    public static PathChain line11 = builder
            .addPath(
                    new BezierLine(
                            new Point(60.885, 8.793, Point.CARTESIAN),
                            new Point(9.456, 9.456, Point.CARTESIAN)
                    )
            )
            .setTangentHeadingInterpolation()
            .setReversed(true)
            .build();

    public static PathChain line12 = builder
            .addPath(
                    new BezierLine(
                            new Point(9.456, 9.456, Point.CARTESIAN),
                            new Point(26.046, 14.599, Point.CARTESIAN)
                    )
            )
            .setTangentHeadingInterpolation()
            .build();

    public static PathChain line13 = builder
            .addPath(
                    new BezierLine(
                            new Point(26.046, 14.599, Point.CARTESIAN),
                            new Point(26.544, 22.396, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(90))
            .build();

    public static PathChain line14 = builder
            .addPath(
                    new BezierLine(
                            new Point(26.544, 22.396, Point.CARTESIAN),
                            new Point(9.124, 22.728, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(90))
            .build();

    public static PathChain line15 = builder
            .addPath(
                    new BezierLine(
                            new Point(9.124, 22.728, Point.CARTESIAN),
                            new Point(38.654, 67.521, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(90))
            .build();

    public static PathChain line16 = builder
            .addPath(
                    new BezierLine(
                            new Point(38.654, 67.521, Point.CARTESIAN),
                            new Point(9.124, 22.396, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(90))
            .build();

    @Override
    public void init() {
        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);

        pathChains = new PathChain[]{
                line1, line2, line3, line4, line5, line6, line7, line8, line9, line10,
                line11, line12, line13, line14, line15, line16
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


