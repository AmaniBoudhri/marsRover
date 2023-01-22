package org.amani;

import fr.amani.entities.Command;
import fr.amani.entities.Grid;
import fr.amani.entities.Position;
import fr.amani.entities.Rover;
import fr.amani.exception.FileFormatIsNotValid;
import fr.amani.utils.InstructionExtractorUtility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public record Control(List<Rover> rovers) {

    public List<Position> process(List<String> lines) throws FileFormatIsNotValid {
        buildRover(lines);
        List<Position> roverPositions = new ArrayList<>(rovers.size());
        for (Rover rover : rovers) {
            roverPositions.add(rover.move());
        }
        return roverPositions;
    }

    private void buildRover(List<String> lines) throws FileFormatIsNotValid {
        Iterator<String> iterator = lines.iterator();
        String lawnSize = iterator.next();

        Grid grid = InstructionExtractorUtility.extractGridSize(lawnSize);
        while (iterator.hasNext()) {
            String mowerPosition = iterator.next();
            Position position = InstructionExtractorUtility.extractLawnInitialPosition(mowerPosition);

            String mowerCommands = iterator.next();
            List<Command> commands = InstructionExtractorUtility.extractCommand(mowerCommands);

            Rover rover = new Rover(position, grid, commands);
            rovers.add(rover);
        }
    }


}
