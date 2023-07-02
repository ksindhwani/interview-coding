package com.example.okx.interview;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * You are building a rover that is going to explore Mars (represented as a grid).
The initial starting point of a rover is 0:0:N
0,0 are X and Y coordinates on a grid
‘N’ is the direction rover is facing - alias for North (directions it can face are N, S, E, W)

Rover accepts different commands and returns its position after executing them
‘L’ and ‘R’ commands rotate the rover left and right, respectively
‘M‘ command moves the rover one step in the direction it’s currently facing. E.g. If its position is “2:3:E” (facing East), sending ‘M’ to the rover 
moves it one step in the direction of East, i.e. “3:3:E”
 *
 * The rover receives a string of multiple commands and returns its position after executing commands. For example, 
 * assuming rover’s starting position is “0:0:N”, sending "RMMLML" to the rover will move it to "2:1:W".
 * 
 * To make things simple, assume following:
Rover’s starting point is always 0:0:N
The grid has infinite size, so don’t worry about falling off the grid
Commands the rover will get will always be valid, so no need to guard against invalid input


he grid may have obstacles. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and 
reports the obstacle e.g. "O:2:2:N" (O stands for Obstacle).

 NL -> W
 NR -> E

 EL-> N
 ER -> S

 wL
 WR

 SL
 SR

 */
public class App 
{
    public static void main( String[] args )
    {
        Position currPosition = new Position(0,0,'N');   
        HashMap<String,Character> directionMap = buildDirectionMap();
        String commands = "RMMLML";
        boolean obstacleEncounter = false;
        
        String nextDirection;
        for(int i =0;i<commands.length();i++) {
            if(commands.charAt(i) != 'M') {
                nextDirection = currPosition.getDirection() + "" + commands.charAt(i);
                char currentDirection = directionMap.get(nextDirection);
                currPosition.setDirection(currentDirection);
            } else {
                if(roverFacesObstacle(currPosition)) {
                    obstacleEncounter = true;
                    break;
                }
                moveRover(currPosition);
            }
        }
        if(!obstacleEncounter) {
            System.out.println(currPosition);
        } else {
            System.out.println('O' + ":" + currPosition.toString());
        }
    }

    private static boolean roverFacesObstacle(Position currPosition) {
        Position nextPosition =  calculateRoverNextPosition(currPosition);
        int obstacleX = 2;
        int obstacleY = 1;
        return nextPosition.getX() == obstacleX && nextPosition.getY() == obstacleY;
    }

    private static Position calculateRoverNextPosition(Position currPosition) {
        Position newPosition = new Position(currPosition.getX(), currPosition.getY(), currPosition.getDirection());
        moveRover(newPosition);
        return newPosition;
    }

    private static void moveRover(Position currPosition) {
        if(currPosition.getDirection() == 'E') {
            currPosition.setX(currPosition.getX() + 1);
        }

        if(currPosition.getDirection() == 'W') {
            currPosition.setX(currPosition.getX() - 1);
        }
        if(currPosition.getDirection() == 'N') {
            currPosition.setY(currPosition.getY() + 1);
        }
        if(currPosition.getDirection() == 'S') {
            currPosition.setY(currPosition.getY() - 1);
        }

    }

    private static HashMap<String, Character> buildDirectionMap() {
        HashMap<String, Character> directionMap = new HashMap<>();

        directionMap.put("NL", 'W');
        directionMap.put("NR", 'E');
        directionMap.put("EL", 'N');
        directionMap.put("ER", 'S');
        directionMap.put("SL", 'E');
        directionMap.put("SR", 'W');
        directionMap.put("WL", 'S');
        directionMap.put("WR", 'N');
        return directionMap;
    }
}
