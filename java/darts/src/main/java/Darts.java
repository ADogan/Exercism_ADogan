class Darts {
    private double xyCartProd;

    private int smallCirclePoints = 10;
    private int mediumCirclePoints = 5;
    private int outerCirclePoints = 1;
    private int targetMisPoints = 0;

    Darts(double x, double y) {
        xyCartProd = calculateCartesianProduct(x, y);
    }

    private double calculateCartesianProduct(double x, double y) {
        return Math.pow(x, 2) + Math.pow(y,2);
    }

    int score() {
        if(hitSmallCircle())
            return smallCirclePoints;
        else if(hitMiddleCircle())
            return mediumCirclePoints;
        else if(hitOuterCircle())
            return outerCirclePoints;
        else
            return targetMisPoints;
    }

    boolean hitSmallCircle(){
        return  xyCartProd <= Math.pow(1,2);
    }

    boolean hitMiddleCircle(){
        return  xyCartProd <= Math.pow(5,2);
    }
    
    boolean hitOuterCircle(){
        return  xyCartProd <= Math.pow(10,2);
    }

}
