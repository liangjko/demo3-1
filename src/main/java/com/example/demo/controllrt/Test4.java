package com.example.demo.controllrt;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class Test4 {
	
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			CompletableFuture.runAsync(()->{
				testaaa();
			});
		}
		Thread.currentThread().sleep(200000000);
	}
	static void testaaa(){
//		调用1次 放进map
//		调用
		Map<List<Integer>,Integer> map = new HashMap<>();
		for (int i = 0; i < 20000000; i++) {
			List<Integer> aa = testbbb();
			map.put(aa,i);
		}
		List<Integer> gg  = new ArrayList<>();
		gg.add(5);
		gg.add(13);
		gg.add(16);
		gg.add(27);
		gg.add(33);
		gg.add(7);
		gg.add(12);
		List<Integer> hh  = new ArrayList<>();
		gg.add(1);
		gg.add(13);
		gg.add(14);
		gg.add(22);
		gg.add(35);
		gg.add(2);
		gg.add(5);
		if(map.containsKey(gg)&&map.containsKey(hh)){
				if(map.get(gg)==map.get(hh)+1){
					for (Map.Entry entry : map.entrySet()) {
						if (entry.getValue().equals(map.get(hh)+2)) {
							System.out.println(entry.getKey());
						}
					}
				}
		}
		System.out.println("r");
		
	}
	static List<Integer> testbbb(){
		
		return SC();
		
	}
	
	
	public static List<Integer> SC() {
		
		List<Integer> Front_zone = new ArrayList();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			int ran1 = r.nextInt(32) + 1;
			if (i == 0) {
				Front_zone.add(ran1);
			} else {
				for (int t = 0; t < Front_zone.size(); t++) {
					if (ran1 == Front_zone.get(t)) {
						i--;
						break;
					} else {
						if (Front_zone.size() == t + 1) {
							Front_zone.add(ran1);
							break;
						}
					}
				}
				
			}
		}
		
		List<Integer> Back_zone = new ArrayList();
		Random r2 = new Random();
		for (int i = 0; i < 2; i++) {
			int ran1 = r2.nextInt(11) + 1;
			if (i == 0) {
				Back_zone.add(ran1);
			} else {
				for (int t = 0; t < Back_zone.size(); t++) {
					if (ran1 == Back_zone.get(t)) {
						i--;
						break;
					} else {
						if (Back_zone.size() == t + 1) {
							Back_zone.add(ran1);
							break;
						}
					}
				}
				
			}
		}
		Collections.sort(Front_zone);
		Collections.sort(Back_zone);
		Front_zone.addAll(Back_zone);
//		System.err.println("祝您喜中头奖！！！  前区：" + Front_zone.toString() + ";  后区：" + Back_zone.toString());
		return Front_zone;
	}

}
