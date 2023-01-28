package duke;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public int getSize() {
        return tasks.size();
    }

    public void addTask(Task task) {
        if (task != null) {
            tasks.add(task);
        }
        Ui.informTaskIsAdded(task, tasks.size());
        Storage.saveTasksToTaskLog(this);
    }

    public ArrayList<Task> filterTasks(String keyword) {
        ArrayList<Task> filteredTasks = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            String currentTaskName = tasks.get(i).getName();
            if(currentTaskName.contains(keyword)) {
                filteredTasks.add(tasks.get(i));
            }
        }
        return filteredTasks;
    }
}
