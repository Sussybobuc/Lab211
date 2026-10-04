/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class TaskList {

    private final ArrayList<Task> taskList = new ArrayList<>();
    private final ArrayList<TaskType> types = new ArrayList<>();

    public TaskList() {
        types.add(new TaskType(1, "Code"));
        types.add(new TaskType(2, "Test"));
        types.add(new TaskType(3, "Design"));
        types.add(new TaskType(4, "Review"));
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public ArrayList<TaskType> getTypes() {
        return types;
    }

    public Task findTaskID(List<Task> list, int id) {
        for (Task i : list) {
            if (i.getID() == id) {
                return i;
            }
        }
        return null;
    }
    public TaskType findTaskTypeID(List<TaskType> list, int id) {
        for (TaskType t : list) {
            if (t.getId()== id) {
                return t;
            }
        }
        return null;
    }
    public void deleteTask(String id) throws Exception {
        int taskID;
        try {
            taskID = Integer.parseInt(id);
        } catch (NumberFormatException e){
            throw new Exception("Invalid");
        }
        Task found = findTaskID(taskList, taskID);
        if(found == null){
            throw new Exception("Not found");
        }
        taskList.remove(found);
    }

        public int addTask(String requirementName, String assignee, String reviewer,
                           String taskTypeID, String date, String planFrom, String planTo) {
        int typeID;
        double from, to;
        try{
            typeID = Integer.parseInt(taskTypeID);
        } catch(NumberFormatException e){
            return -1;
        } if( findTaskTypeID(types, typeID) == null) return -1;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try{
            sdf.parse(date);
        } catch(ParseException e){
            return -1;
        }
        try{
            from = Double.parseDouble(planFrom);
            to = Double.parseDouble(planTo);
            if(!(from < to && from >= 8 && from <= 17.5 && to <= 17.5)) return -1;
        } catch (NumberFormatException e){
            return -1;
        }
        Task task = new Task(taskTypeID,requirementName,date, from, to, assignee, reviewer);
        taskList.add(task);
        return task.getID();
    }

    public List<Task> getDataTask(){
        List<Task> task = new ArrayList<>();
        for(Task t : taskList) task.add(t);
        task.sort(Comparator.comparing(Task::getID));
        return task;
    }
    
        public String formatAll(List<Task> list) {
        StringBuilder result = new StringBuilder();
        for (Task t : list) {
            int typeID = Integer.parseInt(t.getTaskTypeID());
            TaskType type = findTaskTypeID(types, typeID);
            String typeName = (type == null) ? "-" : type.getName();
            double time = t.getpTo() - t.getpFrom();
            result.append(String.format("%-8d%-20.20s%-15s%-15.15s%-10.1f%-15s%-15s", 
                    t.getID(),t.getrName(), typeName,t.getDate(), time, t.getAssignee(),t.getExpert()) ).append("\n");
        }
        return result.toString();
    }
}
