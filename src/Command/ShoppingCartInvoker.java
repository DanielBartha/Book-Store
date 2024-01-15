package Command;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartInvoker {
    private List<ShoppingCartCommand> commands = new ArrayList<>();

    public void addCommand(ShoppingCartCommand command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (ShoppingCartCommand command : commands) {
            command.execute();
        }
    }
}