package com.it.four;

import java.util.concurrent.*;

public class HandelServerThreadPoll {
    public ThreadPoolExecutor executorService;
    /**
     *
     * @param corePollNum 核心线程数 maximumPoolSize 最大线程数量
     * @param queueSize
     * public ThreadPoolExecutor(int corePoolSize,
     *                               int maximumPoolSize,
     *                               long keepAliveTime,
     *                               TimeUnit unit,
     *                               BlockingQueue<Runnable> workQueue)
     */
    public HandelServerThreadPoll(int corePollNum,int maximumPoolSize,int queueSize) {
        executorService = new ThreadPoolExecutor(corePollNum,maximumPoolSize,120, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }
    public void excute(Runnable target){
        executorService.execute(target);
    }
}
