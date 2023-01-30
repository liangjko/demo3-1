package com.example.demo.controllrt;

import java.util.concurrent.CompletableFuture;

public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		Integer a  = 9;
		
		System.out.println(a/10%10);
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 3; i++) {
			CompletableFuture.runAsync(()->{
				try {
					test11();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			});
		}
		Thread.currentThread().sleep(20000);
		System.out.println(Thread.currentThread().getName());
	}
	
	static void test11() throws InterruptedException {
		Thread.currentThread().sleep(5000);
		System.out.println(Thread.currentThread().getName());
	}
}
