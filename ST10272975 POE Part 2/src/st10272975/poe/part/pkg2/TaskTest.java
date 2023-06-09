/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10272975.poe.part.pkg2;

/**
 *
 * @author hanne
 */
public class TaskTest {
     public static void main(String[] args) {
        // Test 1: Task Description should not be more than 50 Characters
        Task task1 = new Task("Login Feature", 1, "Create Login to authenticate users",
                "Robyn Harrison", 8, "", "To Do");
        System.out.println("Test 1 - Task Description length check: " + task1.checkTaskDescription());
        System.out.println(task1.createTaskID());

        // Test 2: Total Hours Correctly accumulated in loop
        Task[] tasks = new Task[5];
        tasks[0] = new Task("Task 1", 1, "Description 1", "Developer 1", 10, "", "To Do");
        tasks[1] = new Task("Task 2", 2, "Description 2", "Developer 2", 12, "", "To Do");
        tasks[2] = new Task("Task 3", 3, "Description 3", "Developer 3", 55, "", "To Do");
        tasks[3] = new Task("Task 4", 4, "Description 4", "Developer 4", 11, "", "To Do");
        tasks[4] = new Task("Task 5", 5, "Description 5", "Developer 5", 1, "", "To Do");
        int totalHours = Task.returnTotalHours(tasks);
        System.out.println("Test 2 - Total Hours: " + totalHours);
    }
}

