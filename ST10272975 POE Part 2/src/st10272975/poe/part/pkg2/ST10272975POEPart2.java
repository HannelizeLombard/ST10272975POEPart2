/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package st10272975.poe.part.pkg2;

import javax.swing.JOptionPane;

/**
 *
 * @author hanne
 */
public class ST10272975POEPart2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

public class EasyKanbanApp {
    private static final String WELCOME_MESSAGE = "Welcome to EasyKanban";
    private static final String MENU_OPTIONS = "1) Add tasks\n2) Show report\n3) Quit";

    private int taskCount;
    private int totalDuration;

    public static void main(String[] args) {
        EasyKanbanApp app = new EasyKanbanApp();
        app.run();
    }

    private void run() {
        JOptionPane.showMessageDialog(null, WELCOME_MESSAGE);

        int choice;
        do {
            choice = displayMenuAndGetChoice();
            processChoice(choice);
        } while (choice != 3);
    }

    private int displayMenuAndGetChoice() {
        String choiceStr = JOptionPane.showInputDialog(null, MENU_OPTIONS);
        return Integer.parseInt(choiceStr);
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                addTasks();
                break;
            case 2:
                showReport();
                break;
            case 3:
                quit();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                break;
        }
    }

    private void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of tasks:"));
        for (int i = 0; i < numTasks; i++) {
            addTask();
        }
    }

    private void addTask() {
        String taskName = JOptionPane.showInputDialog(null, "Enter the task name:");
        String taskDescription = JOptionPane.showInputDialog(null, "Enter the task description (max 50 characters):");
        if (!checkTaskDescription(taskDescription)) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            addTask();
            return;
        }
        String developerFirstName = JOptionPane.showInputDialog(null, "Enter the developer's first name:");
        String developerLastName = JOptionPane.showInputDialog(null, "Enter the developer's last name:");
        String taskDurationStr = JOptionPane.showInputDialog(null, "Enter the task duration in hours:");
        int taskDuration = Integer.parseInt(taskDurationStr);

        taskCount++;
        totalDuration += taskDuration;

        String taskID = createTaskID(taskName, taskCount, developerLastName);

        String taskStatus = JOptionPane.showInputDialog(null, "Select the task status:\n1) To Do\n2) Done\n3) Doing");
        String taskStatusStr;
        switch (taskStatus) {
            case "1":
                taskStatusStr = "To Do";
                break;
            case "2":
                taskStatusStr = "Done";
                break;
            case "3":
                taskStatusStr = "Doing";
                break;
            default:
                taskStatusStr = "Unknown";
                break;
        }

        String taskDetails = printTaskDetails(taskStatusStr, developerFirstName, developerLastName, taskCount,
                taskName, taskDescription, taskID, taskDuration);

        JOptionPane.showMessageDialog(null, "Task successfully captured\n" + taskDetails);
    }

    private boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    private String createTaskID(String taskName, int taskNumber, String developerLastName) {
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" +
                taskNumber + ":" +
                developerLastName.substring(developerLastName.length() - 3).toUpperCase();
        return taskID;
    }

    private String printTaskDetails(String taskStatus, String developerFirstName, String developerLastName,
                                    int taskNumber, String taskName, String taskDescription, String taskID,
                                    int taskDuration) {
        return "Task Status: " + taskStatus +
                "\nDeveloper Details: " + developerFirstName + " " + developerLastName +
                "\nTask Number: " + taskNumber +
                "\nTask Name: " + taskName +
                "\nTask Description: " + taskDescription +
                "\nTask ID: " + taskID +
                "\nDuration: " + taskDuration + " hours";
    }

    private void showReport() {
        JOptionPane.showMessageDialog(null, "Coming Soon");
    }

    private void quit() {
        JOptionPane.showMessageDialog(null, "Total Duration: " + totalDuration + " hours");
    }
}

    }
}

