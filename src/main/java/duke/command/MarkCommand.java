package duke.command;

import duke.*;

public class MarkCommand extends Command {
    public MarkCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        int toMark = userInput.charAt(5) - 48;
        Task toMarkTask = tasks.getTask(toMark - 1);
        toMarkTask.markTask();
        ui.informTaskIsMarked(toMarkTask);
        Storage.saveTasksToTaskLog(tasks);
    }
}
