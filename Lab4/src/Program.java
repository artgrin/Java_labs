import Animal.Eagle;
import Animal.Giraffe;
import Animal.Lion;
import Animal.Ungulates;
import Animal.Zebra;

public class Program {
	
	public static void main(String[] args) throws Exception {
	    Zoo zoo = new Zoo();

	    Cage<Eagle> eagleCage = new Cage<>(2);
        eagleCage.addAnimal(new Eagle());

	    zoo.addCage(eagleCage);
	    zoo.addCage(new Cage<Lion>(1));
	    Cage<Ungulates> ungCage = new Cage<>(2);
	    ungCage.addAnimal(new Giraffe());
	    ungCage.addAnimal(new Zebra());
	    zoo.addCage(ungCage);
	    eagleCage.addAnimal(new Eagle());

	    System.out.println("������ � ��������: " + zoo.getCountOfAnimals());
	    System.out.println("������ � ��i��i ��� ��������: " + ungCage.busyCount() + "/" + ungCage.maxCount());
    }

}
