package model.Map;

import java.util.ArrayList;
import java.util.List;

public enum Direction {

    N (0),
    NE (60),
    SE (120),
    S (180),
    SW(240),
    NW(300);


	private static List<Direction>  directions;
	
	static {
		directions = new ArrayList<Direction>();
		
		for(Direction d: Direction.values()) {
			directions.add(d);
		}
	}
	
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

    public static Direction getDirectionClosest(int angle){
        if(angle > 360){
            angle %= 360;
        }
        for (int i = 0; i < directions.size(); i++) {
            if( directions.get(i).getAngle() == 0 ){
                if (angle < 30 || angle > 330){
                    return directions.get(i);
                }
            }
            if( Math.abs(directions.get(i).getAngle() - angle )  < 30){
                return directions.get(i);
            }
        }
    }

    private Direction(final int angle) {
        this.angle = angle;
    }

    public int getAngle() { return angle; }
}
