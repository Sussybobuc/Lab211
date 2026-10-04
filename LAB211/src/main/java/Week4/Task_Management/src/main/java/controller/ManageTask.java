/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.TaskList;
import view.ConsoleForm;
import view.Menu;
/**
 *
 * @author ASUS
 */
public class ManageTask {
    TaskList taskList = new TaskList();
    ConsoleForm consoleForm = new ConsoleForm();
    
    public void execute() throws Exception {
        while(true){
            int choice = Menu.getChoice();
            switch(choice){
                case 1:
                    String[] in = consoleForm.addTask();
                    int success = taskList.addTask(in[0], in[5], in[6],in[1], in[2], in[3], in[4]);
                    if(success == -1){
                        System.out.println("Failed to add task");
                    } else {
                        System.out.println("Successfully added task");
                    }
                    break;
                case 2:
                    String id = consoleForm.deleteTask();
                    taskList.deleteTask(id);
                    break;
                case 3:
                    consoleForm.getDataTask(taskList.formatAll(taskList.getDataTask()));
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
