import fr.amani.entities.Coordinates;
import fr.amani.entities.Grid;
import fr.amani.entities.Orientation;
import fr.amani.entities.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    public void should_move_y_by_one_when_its_north() {
        Coordinates coordinates = new Coordinates(1, 2);
        Position position = new Position(coordinates, Orientation.NORTH);
        Grid grid = new Grid(5, 5);

        Position result = position.move(grid);

        Coordinates expectedCoordinates = new Coordinates(1, 3);
        Position expected = new Position(expectedCoordinates, Orientation.NORTH);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_move_y_by_minus_one_when_its_south() {
        Coordinates coordinates = new Coordinates(1, 2);
        Position position = new Position(coordinates, Orientation.SOUTH);
        Grid grid = new Grid(5, 5);

        Position result = position.move(grid);

        Coordinates expectedCoordinates = new Coordinates(1, 1);
        Position expected = new Position(expectedCoordinates, Orientation.SOUTH);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_move_y_by_one_when_its_east() {
        Coordinates coordinates = new Coordinates(1, 2);
        Position position = new Position(coordinates, Orientation.EAST);
        Grid grid = new Grid(5, 5);

        Position result = position.move(grid);

        Coordinates expectedCoordinates = new Coordinates(2, 2);
        Position expected = new Position(expectedCoordinates, Orientation.EAST);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_move_x_by_minus_one_when_its_west() {
        Coordinates coordinates = new Coordinates(1, 2);
        Position position = new Position(coordinates, Orientation.WEST);
        Grid grid = new Grid(5, 5);


        Position result = position.move(grid);

        Coordinates expectedCoordinates = new Coordinates(0, 2);
        Position expected = new Position(expectedCoordinates, Orientation.WEST);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_do_nothing_when_x_outrun_grid_size() {
        Coordinates coordinates = new Coordinates(5, 2);
        Position position = new Position(coordinates, Orientation.EAST);
        Grid grid = new Grid(5, 5);

        Position result = position.move(grid);

        Coordinates expectedCoordinates = new Coordinates(5, 2);
        Position expected = new Position(expectedCoordinates, Orientation.EAST);

        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void should_do_nothing_when_y_outrun_grid_size() {
        Coordinates coordinates = new Coordinates(2, 5);
        Position position = new Position(coordinates, Orientation.NORTH);
        Grid grid = new Grid(5, 5);


        Position result = position.move(grid);

        Coordinates expectedCoordinates = new Coordinates(2, 5);
        Position expected = new Position(expectedCoordinates, Orientation.NORTH);


        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void should_move_forward_when_theres_obstacle() {
        Coordinates coordinates = new Coordinates(0, 3);
        Coordinates obstacleCoordinates = new Coordinates(0, 4);
        Position position = new Position(coordinates, Orientation.NORTH);
        Grid grid = new Grid(5, 5, List.of(obstacleCoordinates));


        Position result = position.move(grid);

        Coordinates expectedCoordinates = new Coordinates(0, 3);
        Position expected = new Position(expectedCoordinates, Orientation.NORTH);


        assertThat(result).isEqualTo(expected);

    }
}
