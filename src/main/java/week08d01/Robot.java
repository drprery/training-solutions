package week08d01;

public class Robot {
    private int x=0;
    private int y=0;
    private String items="JBFL";

    public Coords move(String moves){
        if(!(stringContainsCharsFromList(moves, items))){
            throw new IllegalArgumentException("Hibás iránymegadás!");
        }
        Coords coords=new Coords();
        for(int pos=0;pos<moves.length();pos++){
            switch (moves.charAt(pos)){
                case 'B':   x-=1;
                            break;
                case 'J':   x+=1;
                            break;
                case 'F':   y+=1;
                            break;
                case 'L':   y-=1;
            }
        }
        coords.setX(x);
        coords.setY(y);
        return coords;
    }
    private boolean stringContainsCharsFromList(String inputStr, String items) {
        for(int i =0; i < inputStr.length(); i++)
        {
            if(!(items.contains(Character.toString(inputStr.charAt(i)))))
            {
                return false;
            }
        }
        return true;
    }
}
