package StacksAndQueues;

import java.nio.Buffer;

public class SingleArrayPartition {
	int stackSize = 300;
	int buffer[] = new int[stackSize*3];
	int stackPointer[] = {-1,-1,-1};
	
	public void push(int stackNum, int value) {
		int index = stackNum*stackSize+stackPointer[stackNum]+1;
		stackPointer[stackNum]++;
		buffer[index]=value;
	}
	
	public int pop(int stackNum) {
		int index = stackNum*stackSize+stackPointer[stackNum];
		stackPointer[stackNum]--;
		return buffer[index];
	}
	
	public int peek(int stackNum) {
		int index=stackNum*stackSize+stackPointer[stackNum];
		return buffer[index];
	}
	
	public boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == 0;
	}
	
	public static void main(String args[]) {
		SingleArrayPartition a = new SingleArrayPartition();
		a.push(0, 1);
		a.push(0, 2);
		a.push(0, 3);
		a.push(0, 4);
		
		System.out.println("Poped element: "+a.pop(0));
		System.out.println("Peeked element: "+a.peek(0));
		System.out.println("Is empty? : "+a.isEmpty(0));
		System.out.println("Is empty? : "+a.isEmpty(1));
		System.out.println(a.buffer[0]);
	}
}
