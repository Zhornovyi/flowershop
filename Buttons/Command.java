package flowershop.Buttons;

        import java.io.IOException;
        import java.text.ParseException;

public interface Command {
    void execute() throws IOException, ParseException;
}
