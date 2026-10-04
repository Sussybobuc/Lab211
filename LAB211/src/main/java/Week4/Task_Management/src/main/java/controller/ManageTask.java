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
    
    public void execute(){
        while(true){
            int choice = Menu.getChoice();
            switch(choice){
                case 1:
                    
            }
        }
    }
}
