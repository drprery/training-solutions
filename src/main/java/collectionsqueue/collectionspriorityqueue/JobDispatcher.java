package collectionsqueue.collectionspriorityqueue;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {
    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if(jobs.size()==0){
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.poll();
    }

    public Queue<Job> addJob(Job... jobs){
        PriorityQueue<Job> pJobs = new PriorityQueue<>();

        for(Job job : jobs){
            pJobs.add(job);
        }
        return pJobs;
    }
}
