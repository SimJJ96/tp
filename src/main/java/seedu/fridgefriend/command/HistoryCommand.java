package seedu.fridgefriend.command;


import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.utilities.LoggingHandler;
import seedu.fridgefriend.utilities.Storage;
import seedu.fridgefriend.utilities.Ui;

public class HistoryCommand extends Command {

    private final String description;

    public HistoryCommand(String description) {
        LoggingHandler.logInfo("History command initialized with parameter: " + description);
        this.description = description.toLowerCase();
    }

    @Override
    public void execute() {
        if (description.contains("clear")) {
            Storage.clearHistoryData();
            Ui.printMessage("History successfully cleared!");
        } else {
            String message = getHistoryMessage();
            Ui.printMessage(message);
        }
    }

    public String getHistoryMessage() {
        StringBuilder message = new StringBuilder("This is the full history of items you've added in the fridge:");
        message.append(Storage.loadHistoryData());

        assert message != null : "message string should not be null";
        return message.toString();
    }

}
