
1. What is the purpose of the Java Garbage Collector?
   a) To allocate memory for objects
   b) To release memory occupied by unused objects
   c) To optimize code execution
   d) To manage database connections
   
    answer- option b .

2. Which part of the Java Virtual Machine (JVM) is responsible for garbage collection?
   a) Class Loader
   b) JVM Compiler
   c) Runtime Data Area
   d) Bytecode Verifier
   
    answer- option c.

3. How does the Garbage Collector determine if an object is eligible for garbage collection?
   a) By checking if the object is reachable
   b) By examining the object's reference count
   c) By the size of the object
   d) By the object's creation time

    answer- option a.


4. Which of the following are Java Garbage Collection algorithms?
   a) Stack-based algorithm
   b) Mark-and-Sweep
   c) Bubble Sort
   d) Depth-First Search

5. In Java, which part of the memory is managed by the Garbage Collector?
   a) Stack
   b) Heap
   c) Cache
   d) Register

   answer- option b .

6. Which of the following is not a generation in the generational garbage collection model?
   a) Young Generation
   b) Old Generation
   c) Infant Generation
   d) Permanent Generation

   answer- option c.

7. What is a "stop-the-world" event in the context of Garbage Collection?
   a) A situation where the Garbage Collector runs concurrently with the application
   b) A situation where the application is paused while Garbage Collection is performed
   c) A situation where an object is pinned in memory
   d) A situation where Garbage Collection never occurs

   answer- option b.
8. What is the purpose of the "System.gc()" method in Java?
   a) To explicitly trigger garbage collection
   b) To increase memory allocation for the JVM
   c) To reduce the memory footprint of an application
   d) To start a new JVM instance

   answer- option a.

9. Which garbage collection algorithm is typically used for the Young Generation in the JVM?
   a) Mark-and-Sweep
   b) Generational Garbage Collection
   c) Parallel Garbage Collection
   d) Concurrent Garbage Collection

   answer- option a.

10. In the context of Garbage Collection, what is the PermGen (Permanent Generation) used for?
    a) Storing live objects
    b) Storing the heap
    c) Storing class metadata, such as classes and methods
    d) Managing thread pools

    answer- option c.

Subjective Questions:

11. Why Garbage Collection is necessary in Java?
answer- Garbage collection is one of the needed and most essenstial part of the java runtime data area,
	because it helps to deallocate the memory used by objects which are not reachable at the moment.
	Java is the language is well known by it's platform independant & Automatic memory allocation 
	as well deallocation features. Garbage collecter prevents us to get outofmemorybounds error because 
	it's GC's responsibility to manage the heap memory for us. except java there are many languages where 
	we manually have to deallocate the memory which might be a bit risky and ommitable. 

12. What is the drawback to Garbage Collection?
answer- When garbage collecter gets invoked and go for marking phase , on that moment everything stops working.
	That is called "Stop the Event" which I found as a drawback. because it can take a pause according to 
	your GC type , which stops us to perform any task in between until GC is finished with it's task of 
	checking and deallocation of the memory used by unreachable objects. 

13. What do you mean by mark-and-sweep?
answer- Mark and sweep is the algorithum used for two phases which is marking and deallocating the memory used 
	by unreachable objects at the moment. moreover this can be done in young generation. in other words 
	when it's the marking phase , GC checks if the object is still in use so it will increase it's age count 
	and shift that object to survivour section. And if object found unreachable so GC will deallocate it from 
	the heap and assign it's space to new born objects. this phase is called Compact.

14. What is the difference between Heap and Stack in Java?
answer- Heap;-  all non primitive data types variable get stored in heap(ex- String,array,obj).
		pass by refrences things gets stored into the heap.
		heap is a bit slower in comparison of Stack.
		heap stores the address of the objects and instance variables.

	Stack;- primitive data types gets stored in Stack(ex- int,float,boolean).
		pass by values gets stored into the stack.
		Stack is faster the heap.
		Stack contains the original value of the variables rather the its address.
		
15. Write a Stack Program.
answer- 

public class StackExampleOne{
	public static void main(String[] args){
		Stack obj = new Stack();
		obj.push(1);
		obj.push(2);
		obj.pop();
		System.out.println("Top element is: " + obj.peek());
		System.out.println("check stack is empty: " + obj.isEmpty());
	}
}

class Stack{
	int array[] = new int[3] ;
	int i=-1;
	
	public void push(int num){
		if (i != array.length-1){
			array[++i] = num;
			System.out.println("new value inserted into the stack.");
		}
		else{
			System.out.println("Stack is getting Overflow, not enough space.");
		}
	}
	public void pop()throws ArrayIndexOutOfBoundsException{
		if (i!=-1){
			System.out.println("Last inserted element is: "+ array[i]);
			i-- ;
		}
		else{
			System.out.println("Stack is getting underflow or empty.");
		}
	}
	
	public int peek(){
		return array[i] ;
	}
	public boolean isEmpty(){
		return i == -1 ;
	}
}




