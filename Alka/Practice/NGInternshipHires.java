interface NGStudent{
	public void study();

}
 abstract class DefaultNGStudent implements NGStudent{
	private String name;
	DefaultNGStudent(String name){
		this.name=name;
	}
	public String getName(){	
		return name;
	}
	
}

interface NWIntern{
	public void workAtNatWest();
}

interface AccIntern{
	public void workAtAccenture();
}
 
class Uplifter extends DefaultNGStudent implements NWIntern{
	public void study(){
		System.out.println("I study at NavGurukul");
	}
	public void work(){
		System.out.println("I work at NatWest");
	}
}

class AccentureInterns extends DefaultNGStudent implements AccIntern{
	
	AccentureInterns(String name){
		super(name);
	}
	public void workAtAccenture(){
		System.out.println("I work at Accenture");
		
	}
}

public class NGInternshipHires{
	public static void main(String args[]){
		Uplifter riti = new Uplifter();
		riti.study();
		riti.work();
		NGStudent ritiStudent = new Uplifter("Alka");
		ritiStudent.study();
		System.out.println("Congrats"+getName());

		NWIntern ritiIntern = new Uplifter();
		ritiIntern.work();
		
		AccentureInterns abhi = new AccentureInterns();
		abhiStudent.study();
		System.out.println();
	}
}