package fr.amani.entities;

import lombok.Data;

@Data
public class Position {
    private Coordinates coordinates;
    private Orientation orientation;

    public Position(Coordinates coordinates, Orientation orientation) {
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public void turnRight() {
        orientation = orientation.getRightOrientation();
    }

    public void turnLeft() {
        orientation = orientation.getLeftOrientation();
    }

    public Position move(Grid grid) {
        int x = coordinates.getX();
        int y = coordinates.getY();

        switch (orientation) {
            case NORTH:
                if (coordinates.getY() < grid.y()) {
                    y = y + 1;
                }
                break;
            case SOUTH:
                if (coordinates.getY() > 0) {
                    y = y - 1;
                }
                break;
            case EAST:
                if (coordinates.getX() < grid.x()) {
                    x = x + 1;
                }
                break;
            case WEST:
                if (coordinates.getX() > 0) {
                    x = x - 1;
                }
                break;
        }
        Coordinates newCoordinates = new Coordinates(x, y);
        if (!grid.obstacles().contains(newCoordinates)) {
            coordinates.setX(x);
            coordinates.setY(y);
        }
        return new Position(coordinates, orientation);

    }
}
