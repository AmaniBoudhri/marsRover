package fr.amani.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Rover {
    private Position position;
    private Grid grid;
    private List<Command> commands;


    public Position move() {
        for (Command command : commands) {
            execute(command);
        }
        return position;
    }

    public void execute(Command command) {
        switch (command) {
            case LEFT -> position.turnLeft();
            case RIGHT -> position.turnRight();
            case FORWARD -> position.move(grid);

        }
    }
}
