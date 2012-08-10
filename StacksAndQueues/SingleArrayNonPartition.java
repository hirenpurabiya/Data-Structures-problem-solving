package StacksAndQueues;

public class SingleArrayNonPartition {

	int stackSize = 300;
	int indexUsed = 0;
	int stackPointer[]={-1,-1,-1};
	StackNode[] buffer = new StackNode[3*stackSize];
	
	public void push(int stackNum, int value) {
		int lastIndex=stackPointer[stackNum];
		stackPointer[stackNum]=indexUsed;
		indexUsed++;
		buffer[stackPointer[stackNum]]=new StackNode(lastIndex, value);
	}
	
	public int pop(int stackNum) {
		int value=buffer[stackPointer[stackNum]].value;
		int lastIndex=stackPointer[stackNum];
		stackPointer[stackNum]=buffer[stackPointer[stackNum]].previous;
		indexUsed--;
		buffer[lastIndex]=null;
		return value;
	}
	
	public int peek(int stackNum) {
		return buffer[stackPointer[stackNum]].value;
	}
	
	public boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}
	
	public static void main(String args[]) {
		SingleArrayNonPartition a = new SingleArrayNonPartition();
		a.push(0, 10);
		a.push(1, 100);
		a.push(2, 1000);
		System.out.println(a.buffer[0].value+" "+a.buffer[1].value+" "+a.buffer[2].value);
		
		a.pop(0);
		a.pop(2);
		System.out.println(a.buffer[0].value);
	}
}


class StackNode {
	int previous;
	int value;
	
	StackNode(int lastIndex, int value) {
		previous=lastIndex;
		this.value=value;
	}
}