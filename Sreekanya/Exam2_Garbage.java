
1. What is the purpose of the Java Garbage Collector?
   a) To allocate memory for objects
   b) To release memory occupied by unused objects
   c) To optimize code execution
   d) To manage database connections

Ans)b

2. Which part of the Java Virtual Machine (JVM) is responsible for garbage collection?
   a) Class Loader
   b) JVM Compiler
   c) Runtime Data Area
   d) Bytecode Verifier
Ans)c

3. How does the Garbage Collector determine if an object is eligible for garbage collection?
   a) By checking if the object is reachable
   b) By examining the object's reference count
   c) By the size of the object
   d) By the object's creation time
Ans)a

4. Which of the following are Java Garbage Collection algorithms?
   a) Stack-based algorithm
   b) Mark-and-Sweep
   c) Bubble Sort
   d) Depth-First Search
Ans)b

5. In Java, which part of the memory is managed by the Garbage Collector?
   a) Stack
   b) Heap
   c) Cache
   d) Register
Ans)b

6. Which of the following is not a generation in the generational garbage collection model?
   a) Young Generation
   b) Old Generation
   c) Infant Generation
   d) Permanent Generation
Ans)c

7. What is a "stop-the-world" event in the context of Garbage Collection?
   a) A situation where the Garbage Collector runs concurrently with the application
   b) A situation where the application is paused while Garbage Collection is performed
   c) A situation where an object is pinned in memory
   d) A situation where Garbage Collection never occurs
Ans)a

8. What is the purpose of the "System.gc()" method in Java?
   a) To explicitly trigger garbage collection
   b) To increase memory allocation for the JVM
   c) To reduce the memory footprint of an application
   d) To start a new JVM instance
Ans>a

9. Which garbage collection algorithm is typically used for the Young Generation in the JVM?
   a) Mark-and-Sweep
   b) Generational Garbage Collection
   c) Parallel Garbage Collection
   d) Concurrent Garbage Collection
Ans)a

10. In the context of Garbage Collection, what is the PermGen (Permanent Generation) used for?
    a) Storing live objects
    b) Storing the heap
    c) Storing class metadata, such as classes and methods
    d) Managing thread pools
Ans)c


Subjective Questions:

11. Why Garbage Collection is necessary in Java?
Ans)Garbage Collection is used to remove unused objects and for memory management.
12. What is the drawback to Garbage Collection?
13. What do you mean by mark-and-sweep?
Ans)Mark:in mark first check in eden space which is unused objects and mark that objects .
    Swap:Swap is used to work to swap the used objects to s0 and s1 areas
14. What is the difference between Heap and Stack in Java?
Ans) Heap is used to store Objects and reference varables.
      Stack is used to store Local varables in method area.
15. Write a Stack Program.


public class Stack{
	public ArrayList<Integer> stack;
	Stack(){
		this.stack=new ArrayList<>();
		
	}
	public void push(int value){
		stack.push(value);
	}
	public int  pop(){
		if(stack.size>=0){
			stack.remove(stack.size()-1);
		}
	}
	public int peek(){
		if(stack.size>=0){
			stack.get(stack.size()-1);
		}
	}
	public boolean isEmpty(){
		return (stack.size()>=0);
	}
	
	public static void main(String[] args){
	
		Stack s=new Stack();
		s.push(4);
		s.push(6);
		s.push(7);
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.isEmpty());
	
	}
}








