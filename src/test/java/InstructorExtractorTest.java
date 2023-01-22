import fr.amani.entities.Command;
import fr.amani.entities.Grid;
import fr.amani.entities.Orientation;
import fr.amani.entities.Position;
import fr.amani.exception.FileFormatIsNotValid;
import fr.amani.utils.InstructionExtractorUtility;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstructorExtractorTest {
    @SneakyThrows
    @Test
    public void should_extract_lawn_size() {

        Grid grid = InstructionExtractorUtility.extractGridSize("5 5");

        assertThat(grid.x()).isEqualTo(5);
        assertThat(grid.y()).isEqualTo(5);
    }

    @Test
    public void should_throw_not_valid_format_exception_when_size_is_wrong() {
        assertThrows(FileFormatIsNotValid.class, () -> InstructionExtractorUtility.extractGridSize("5 A"));
    }

    @SneakyThrows
    @Test
    public void should_extract_initial_position() {
        Position position = InstructionExtractorUtility.extractLawnInitialPosition("5 5 N");

        assertThat(position.getCoordinates().getX()).isEqualTo(5);
        assertThat(position.getCoordinates().getY()).isEqualTo(5);
        assertThat(position.getOrientation()).isEqualTo(Orientation.NORTH);
    }

    @Test
    public void should_throw_not_valid_format_exception_when_position_is_wrong() {

        assertThrows(FileFormatIsNotValid.class, () -> InstructionExtractorUtility.extractLawnInitialPosition("5 5 A"));
    }

    @SneakyThrows
    @Test
    public void should_extract_command() {
        List<Command> commands = InstructionExtractorUtility.extractCommand("LMLMLMLMMRR");

        assertThat(commands.size()).isEqualTo(11);

    }

    @Test
    public void should_throw_not_valid_format_exception_when_command_is_wrong() {
        assertThrows(FileFormatIsNotValid.class, () -> InstructionExtractorUtility.extractCommand("LMCADFTRD"));
    }
}
