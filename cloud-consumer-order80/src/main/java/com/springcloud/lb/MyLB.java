package com.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 胡开成
 * @Date 2020/3/19 23:14
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);
//    第几次访问
    public final int getAndIncrement(){
        int current;
        int next;

        do {
            current=this.atomicInteger.get();
            next=current >= 2147483647 ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("**********第几次访问，次数next"+next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
       int res = getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(res);
    }
}
