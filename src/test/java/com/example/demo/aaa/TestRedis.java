package com.example.demo.aaa;

import com.example.demo.DemoApplication;
//import com.example.demo.config.RedisLock;
//import com.example.demo.config.SpringContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestRedis {
//	private CountDownLatch countDownLatch = new CountDownLatch(2);
	
//	@Test
//	public void testRedisLock() throws InterruptedException {
//		new Thread(() -> {
////			RedisLock lock = new RedisLock();
////			lock = lock.newInstance("test");
////			RedisLock lock = RedisLock.newInstance("test");
//			RedisLock lock = ((RedisLock) SpringContextUtil.getBean("redisLock")).newInstance("test");
//			if (lock.lock()) {
//				System.out.println("work1获得锁");
//				System.out.println("work1 工作15s...");
//				try {
//					Thread.sleep(15000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("work1完成工作，释放锁");
//				lock.unlock();
//			}
//			countDownLatch.countDown();
//		},"work1").start();
//		new Thread(() -> {
//			RedisLock lock = ((RedisLock) SpringContextUtil.getBean("redisLock")).newInstance("test");
//			if (lock.lock()) {
//				System.out.println("work2获得锁");
//				System.out.println("work2 工作5s...");
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("work2完成工作，释放锁");
//				lock.unlock();
//			}
//			countDownLatch.countDown();
//		}, "work2").start();
//		// 等待两个线程完成，才完成主线程
//		countDownLatch.await();
//	}
}
