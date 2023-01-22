import fr.amani.entities.Orientation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrientationTest {
    @Test
    public void should_return_west_when_turn_north_left() {
        Orientation orientation = Orientation.NORTH;
        Orientation result = orientation.getLeftOrientation();
        assertThat(result).isEqualTo(Orientation.WEST);
    }

    @Test
    public void should_return_east_when_turn_north_right() {
        Orientation orientation = Orientation.NORTH;
        Orientation result = orientation.getRightOrientation();
        assertThat(result).isEqualTo(Orientation.EAST);
    }

    @Test
    public void should_return_east_when_turn_south_left() {
        Orientation orientation = Orientation.SOUTH;
        Orientation result = orientation.getRightOrientation();
        assertThat(result).isEqualTo(Orientation.WEST);
    }


    @Test
    public void should_return_east_when_turn_south_right() {
        Orientation orientation = Orientation.SOUTH;
        Orientation result = orientation.getLeftOrientation();
        assertThat(result).isEqualTo(Orientation.EAST);
    }
}
