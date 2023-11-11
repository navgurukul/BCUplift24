
/*1. What is the purpose of the Java Garbage Collector?
   a) To allocate memory for objects
   b) To release memory occupied by unused objects
   c) To optimize code execution
   d) To manage database connections
Answer:- b

2. Which part of the Java Virtual Machine (JVM) is responsible for garbage collection?
   a) Class Loader
   b) JVM Compiler
   c) Runtime Data Area
   d) Bytecode Verifier
Answer :- c

3. How does the Garbage Collector determine if an object is eligible for garbage collection?
   a) By checking if the object is reachable
   b) By examining the object's reference count
   c) By the size of the object
   d) By the object's creation time
Answer:- a

4. Which of the following are Java Garbage Collection algorithms?
   a) Stack-based algorithm
   b) Mark-and-Sweep
   c) Bubble Sort
   d) Depth-First Search
Answer:- b

5. In Java, which part of the memory is managed by the Garbage Collector?
   a) Stack
   b) Heap
   c) Cache
   d) Register
Answer:- b

6. Which of the following is not a generation in the generational garbage collection model?
   a) Young Generation
   b) Old Generation
   c) Infant Generation
   d) Permanent Generation
Answer:- c

7. What is a "stop-the-world" event in the context of Garbage Collection?
   a) A situation where the Garbage Collector runs concurrently with the application
   b) A situation where the application is paused while Garbage Collection is performed
   c) A situation where an object is pinned in memory
   d) A situation where Garbage Collection never occurs
Answer:- b

8. What is the purpose of the "System.gc()" method in Java?
   a) To explicitly trigger garbage collection
   b) To increase memory allocation for the JVM
   c) To reduce the memory footprint of an application
   d) To start a new JVM instance
Answer:- b

9. Which garbage collection algorithm is typically used for the Young Generation in the JVM?
   a) Mark-and-Sweep
   b) Generational Garbage Collection
   c) Parallel Garbage Collection
   d) Concurrent Garbage Collection

10. In the context of Garbage Collection, what is the PermGen (Permanent Generation) used for?
    a) Storing live objects
    b) Storing the heap
    c) Storing class metadata, such as classes and methods
    d) Managing thread pools


Subjective Questions:

11. Why Garbage Collection is necessary in Java?
Answer Garbage collector are very essential part of JVM Garbage collector used for To release memory occupied by unused objects and checked which obeject is reacheable or not and delete those unreacheable object.
12. What is the drawback to Garbage Collection?
Answer Garbage collector take time
13. What do you mean by mark-and-sweep?
14. What is the difference between Heap and Stack in Java?
15. Write a Stack Program*/

public class Garbage_Collection_Questions{
	public static void main(String args[]){
		Stack s1=new Stack();
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);
		s1.peek();
		s1.pop();
		s1.peek();

	}

}

class Stack(){
	public ArrayList<int> arr=new ArrayList<int>();
	public int i=0;

	public void push(int ele){
		arr.add(ele);
		i+=1;
	}

	public void pop(int ele){
		if(arr.lenght==0){
			System.out.prinln("Stack is empty");
		}
		else{
			p=arr.get(i-1);
			arr.remove(p);
			i-=1;
		}
	}

	public void peek(){
		if(arr.length==0){
			System.out.prinln("Stack is empty");
		}
		else{
			System.out.println(arr.get(arr.lenght-1));
		}
	}

}

