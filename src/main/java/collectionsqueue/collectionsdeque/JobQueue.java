package collectionsqueue.collectionsdeque;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobQueue {
    public Deque<Job> addJobByUrgency(Job... jobs){
        Deque<Job> dJobs = new ArrayDeque<>();

        for(Job job : jobs){
            if(job.getPriority()<5){
                dJobs.addFirst(job);
            } else {
                dJobs.addLast(job);
            }
        }
        return dJobs;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException{
        if(jobs.size()==0){
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.pollFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException{
        if(jobs.size()==0){
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.pollLast();
    }
}
