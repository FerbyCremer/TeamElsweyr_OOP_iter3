package model.Map;

import java.util.List;

public enum Direction {

    N (0),
    NE (60),
    SE (120),
    S(180),
    SW(240),
    NW(300);


    private static List<Direction>  directions;
    private final int angle;

    public Direction getClockwise(int angle){
        if(angle % 60 == 0){
            int target = angle + this.angle;
            target %= 360;
            for(int i = 0; i < directions.size(); i++){
                if(directions.get(i).getAngle() == target){
                    return directions.get(i);
                }
            }
        }
        return null;
    }

    private Direction(final int angle) {
        this.angle = angle;
        addToDirections(this);

    }

    private void addToDirections(Direction direction){
        directions.add(direction);
    }

    public int getAngle() { return angle; }
}
