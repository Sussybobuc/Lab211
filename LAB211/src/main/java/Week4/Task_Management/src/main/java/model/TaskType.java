/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package model;

/**
 *
 * @author ASUS
 */
public class TaskType {
    private final int id;
    private final String name;
    
    public TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TaskType{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
