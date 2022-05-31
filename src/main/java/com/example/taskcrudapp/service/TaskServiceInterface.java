package com.example.taskcrudapp.service;

import com.example.taskcrudapp.modal.Task;

import java.util.List;

public interface TaskServiceInterface {
    public List<Task> getTaskList();
    public void addTask(Task task) throws Exception;
    public void updateTask(Task task,int taskId) throws Exception;
    public void deleteTask(int taskId) throws Exception;
    public Task individualTask(int taskId) throws Exception;
}
