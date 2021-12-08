public class Rotation extends Matrix22 {
    public double angle;

    public Rotation(double a) {
        super(Math.sin(Math.toRadians(a)), Math.cos(Math.toRadians(a)), -Math.cos(Math.toRadians(a)), Math.sin(Math.toRadians(a)));
        this.angle = a;
    }

    public double getAngle() {
        //return Math.toDegrees(Math.asin(this.a)); - выдает не совсем то, что нужно
        return angle;
    }
}
