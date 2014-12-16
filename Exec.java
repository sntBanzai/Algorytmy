import java.util.Scanner;


public class Exec {
	Algorytmy nowy = new Algorytmy();
	Scanner fromUser = new Scanner(System.in);
	int granZakr;
	static{
		System.out.println("Ten program tworzy tablicê sk³adaj¹c¹ siê z okreœlonej liczby elementów typu Integer (liczby ca³kowite).");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Liczba elementów w tablicy oraz zakres generowanych liczb pseudolosowych zale¿y od widzimisiê u¿ytkownika.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Nastêpnie u¿ytkownik ma mozliwoœæ posortowania utworzonej w ten sposób tablicy za pomoc¹ kilku metod,"
				+ " b¹dŸ sprawdzenia czy wewn¹trz tablicy wystêpuj¹ okreœlone liczby.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	Exec(){
		System.out.println("Proszê o wskazanie ile liczb ma siê znajdowaæ w sortowanej tablicy:");
		int rozmiarTab = fromUser.nextInt();
		System.out.println("Proszê o wskazanie górnej granicy zakresu generowanych liczb (dolna granica to 0):");
		granZakr = fromUser.nextInt();
		nowy.createArray(rozmiarTab,granZakr);
		System.out.println("Stworzono tablicê sk³adaj¹c¹ siê z "+rozmiarTab+" elementów, której zawartoœæ przedstawia siê jak poni¿ej:");
		System.out.println(nowy.nieposortowany);
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		firstQuest();
		nextQuest();
		
	}
	
	private void firstQuest(){
		int wybórOpcji = 0;
		System.out.println("Co teraz chcesz zrobiæ?:\n 1.Wyszukaæ liniowo, czy dana liczba wystêpuje w zbiorze"
				+ "\n 2.Posortowaæ zbiór za pomoc¹ sortowania przez wybieranie \n 3.Posortowaæ za pomoc¹ sortowania przez wstawianie."
				+ "\n 4.Zakoñczyæ dzia³anie programu.");
		while(wybórOpcji>4||wybórOpcji==0){
			wybórOpcji = fromUser.nextInt();
			
			if(wybórOpcji>4||wybórOpcji==0)
				System.out.println("Prosze wybraæ liczbê z zakresu 1-4!");
		}
		switch(wybórOpcji){
			case 1:
				firstOp();
				firstQuest();
				break;
			case 2:
				System.out.println("Po posortowaniu wygl¹d tablicy przedstawia siê jak poni¿ej:");
				System.out.println(nowy.selectionSort(nowy.nieposortowany));
				break;
			case 3:
				System.out.println("Po posortowaniu wygl¹d tablicy przedstawia siê jak poni¿ej:");
				System.out.println(nowy.insertionSort(nowy.nieposortowany));
				break;
			case 4:
				System.out.println("Zakoñczono pracê programu!");
				System.exit(0);
				break;		
		}
	}
	
	private void nextQuest(){
		if(nowy.sorted==true){
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int chooseYN = 0;
			while(chooseYN<1||chooseYN>2){
				System.out.println("Dziêki posortowaniu zbióru istnieje mozliwoœæ wyszukiwania binarnego wewn¹trz zbioru. Czy chcesz to tero uczyniæ? (1 = TAK/2 = NIE)");
				chooseYN = fromUser.nextInt();
				if(chooseYN<1||chooseYN>2){
					System.out.println("Odpowiedz tak (1) lub nie (2)!");
				}
			}
			switch(chooseYN){
				case 1:
					System.out.println("Proszê podaæ liczbê, któr¹ chcesz wyszukaæ:");
					int poszukiwana = fromUser.nextInt();
					nowy.binarySearch(poszukiwana, nowy.posortowany);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					finalQuest();
					break;
				case 2:
					finalQuest();
					break;
				default:
					
				}
			}
		
		fromUser.close();
	}
	
	private void firstOp(){
		System.out.println("Proszê podaæ liczbê, któr¹ chcesz wyszukaæ:");
		int poszukiwana = fromUser.nextInt();
		if(poszukiwana>granZakr){
			System.out.println("Poszukiwana liczba przekracza maksymaln¹ wartoœæ pozycji w utworzonej tabeli!");
			firstOp();
		}
		else{
		nowy.lineSearch(poszukiwana, nowy.nieposortowany);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	private void finalQuest(){
		int choice = 0;
		while(choice!=1||choice!=2||choice!=3){
			System.out.println("Co teraz chcia³byœ zrobiæ?:\n 1.Ponownie poszukaæ okreœlonej liczby w utworzonym ju¿ zbiorze. \n 2.Rozpocz¹æ jeszcze raz.\n 3.Zakoñczyæ program.");
			choice = fromUser.nextInt();	
			switch(choice){
			case 1:
				nextQuest();
				break;
			case 2:
				System.out.print("\n \n \n \n \n \n \n ");
				new Exec();
				break;
			case 3:
				System.out.println("Zakoñczono pracê programu!");
				System.exit(0);
				break;
			default:
				System.out.println("Wybrano b³êdn¹ opcjê!");
			}
		}
		fromUser.close();	
	}

	public static void main(String[] args){
		new Exec();
	}
}
