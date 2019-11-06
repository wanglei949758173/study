package jvm.study.g1;

/**
 * G1日志分析
 * @author Administrator
 *
 */
public class T1_Log {
	public static void main(String[] args) {
		/*
		 	-verbose:gc
			-Xms10m
			-Xmx10m
			-XX:+UseG1GC
			-XX:+PrintGCDetails
			-XX:+PrintGCDateStamps
			-XX:MaxGCPauseMillis=200m
		 */
		int size = 1024 * 1024;
		
		byte[] myAlloc1 = new byte[size];
		byte[] myAlloc2 = new byte[size];
		byte[] myAlloc3 = new byte[size];
		byte[] myAlloc4 = new byte[size];
		
		System.out.println("Hello World");
	}
}
