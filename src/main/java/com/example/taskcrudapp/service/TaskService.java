package com.example.taskcrudapp.service;

import com.example.taskcrudapp.DbAction.FactoryProvider;
import com.example.taskcrudapp.modal.Task;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService implements TaskServiceInterface{
    private static Session session = null;
    private static Transaction tx=null;
    List<Task> tasklist=null;
    public List<Task>   getTaskList(){
        session = FactoryProvider.getFactory().openSession();
        tx = session.beginTransaction();
        tasklist= (List<Task>) session.createQuery("from Task").getResultList();
        session.close();
        return tasklist;
    }

    @Override
    public void addTask(Task task) throws Exception {
        session = FactoryProvider.getFactory().openSession();
        tx = session.beginTransaction();
        try{
            Task task1=new Task(task.getTask_name(),task.getTask_description(), task.getTask_comment(), task.getTask_status());
            session.save(task1);
            tx.commit();
            session.close();
        }
        catch (Exception e){
            tx.rollback();
            throw new Exception("some message");
        }
    }

    @Override
    public void updateTask(Task task,int taskId) throws Exception {
        session = FactoryProvider.getFactory().openSession();
        tx = session.beginTransaction();
        try{
            Query q=session.createQuery("from Task where id=:task_id");
            q.setParameter("task_id",taskId);
            Task result=(Task)q.list().get(0);
            result.setTask_name(task.getTask_name()==null?result.getTask_name():task.getTask_name());
            result.setTask_comment(task.getTask_comment()==null?result.getTask_comment():task.getTask_comment());
            result.setTask_description(task.getTask_description()==null?result.getTask_description():task.getTask_description());
            result.setTask_status(task.getTask_status()==null?result.getTask_status():task.getTask_status());
            session.update(result);
            tx.commit();
            session.close();
        }catch (Exception e){
            tx.rollback();
            throw new Exception("some message");
        }

    }

    @Override
    public void deleteTask(int taskId) throws Exception {
        session = FactoryProvider.getFactory().openSession();
        tx = session.beginTransaction();
        try{
            Query q2=session.createQuery("from Task where id=:task_id");
            q2.setParameter("task_id",taskId);
            Task result=(Task)q2.list().get(0);
            session.delete(result);
            tx.commit();
            session.close();
        }
        catch (Exception e){
            tx.rollback();
            throw new Exception("some message");
        }

    }

    @Override
    public Task individualTask(int taskId) throws Exception {
        session = FactoryProvider.getFactory().openSession();
        tx = session.beginTransaction();
        try{
            Query q2=session.createQuery("from Task where id=:task_id");
            q2.setParameter("task_id",taskId);
            Task result=(Task)q2.list().get(0);
            tx.commit();
            session.close();
            return result;
        }catch(Exception e){
            tx.rollback();
            throw new Exception("some message");
        }

    }
}
