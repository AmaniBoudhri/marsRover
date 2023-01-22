import fr.amani.entities.Coordinates;
import fr.amani.entities.Orientation;
import fr.amani.entities.Position;
import fr.amani.exception.FileFormatIsNotValid;
import org.amani.Control;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControlTest {
    @Test
    public void should_move_rover() throws FileFormatIsNotValid {
        Control control = new Control(new ArrayList<>());
        Position expectedPosition1 = new Position(new Coordinates(1, 3), Orientation.NORTH);
        Position expectedPosition2 = new Position(new Coordinates(5, 1), Orientation.EAST);

        List<Position> expectedPositions = List.of(expectedPosition1, expectedPosition2);

        //SUT
        List<Position> positions = control.process(List.of("5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM"));

        assertThat(positions.size()).isEqualTo(expectedPositions.size());
        assertThat(positions.get(0)).isEqualTo(expectedPosition1);
        assertThat(positions.get(1)).isEqualTo(expectedPosition2);
    }
}
