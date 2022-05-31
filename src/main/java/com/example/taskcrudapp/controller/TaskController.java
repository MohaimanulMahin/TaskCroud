package com.example.taskcrudapp.controller;
import com.example.taskcrudapp.DbAction.FactoryProvider;
import com.example.taskcrudapp.modal.Task;
import com.example.taskcrudapp.service.TaskService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
   private Session session = null;
    private  Transaction tx=null;
    HttpHeaders httpHeaders = new HttpHeaders();
    @Autowired
   private TaskService taskService;

@GetMapping("/list-task")
public ResponseEntity<List<Task>> ListTask(){
    try{
        List<Task> tasklist=taskService.getTaskList();
        return ResponseEntity.ok().body(tasklist);
    }
    catch (Exception e){
        return ResponseEntity.badRequest().body(null);
    }
}

    @PostMapping("/task-create")
    public ResponseEntity  addTask(@RequestBody Task task){
        try{
            taskService.addTask(task);
            return  ResponseEntity.ok().body("Data is created");
        }catch (Exception e){
            System.out.println(e);
            return  ResponseEntity.badRequest().body("Something Wrong");
        }
    }


    @PostMapping("/task-update/{taskId}")
    public ResponseEntity  updateTask(@RequestBody Task task,@PathVariable("taskId") int taskId){
    try {
        taskService.updateTask(task,taskId);
        return  ResponseEntity.ok().body("Data is updated");
    }catch (Exception e){
        System.out.println(e);
        return  ResponseEntity.badRequest().body("Something Wrong");
    }
    }


    @PostMapping("/task-delete/{taskId}")
    public ResponseEntity DeleteTask(@PathVariable("taskId") int taskId){
    try{
        taskService.deleteTask(taskId);
        return new ResponseEntity("",httpHeaders, HttpStatus.OK);
    }catch (Exception e){
        System.out.println(e);
        return  ResponseEntity.badRequest().body("Something Wrong");
    }
    }

    @GetMapping("/task-individual/{taskId}")
    public ResponseEntity IndividualTask(@PathVariable("taskId") int taskId){
    try{
        Task result= taskService.individualTask(taskId);
        return new ResponseEntity(result,httpHeaders, HttpStatus.OK);
    }catch (Exception e){
        System.out.println(e);
        return  ResponseEntity.badRequest().body("Something Wrong");
    }
    }

}



