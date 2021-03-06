import java.util.Scanner;


public class Exec {
	Algorytmy nowy = new Algorytmy();
	Scanner fromUser = new Scanner(System.in);
	int granZakr;
	static{
		System.out.println("Ten program tworzy tablic� sk�adaj�c� si� z okre�lonej liczby element�w typu Integer (liczby ca�kowite).");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Liczba element�w w tablicy oraz zakres generowanych liczb pseudolosowych zale�y od widzimisi� u�ytkownika.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Nast�pnie u�ytkownik ma mozliwo�� posortowania utworzonej w ten spos�b tablicy za pomoc� kilku metod,"
				+ " b�d� sprawdzenia czy wewn�trz tablicy wyst�puj� okre�lone liczby.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	Exec(){
		System.out.println("Prosz� o wskazanie ile liczb ma si� znajdowa� w sortowanej tablicy:");
		int rozmiarTab = fromUser.nextInt();
		System.out.println("Prosz� o wskazanie g�rnej granicy zakresu generowanych liczb (dolna granica to 0):");
		granZakr = fromUser.nextInt();
		nowy.createArray(rozmiarTab,granZakr);
		System.out.println("Stworzono tablic� sk�adaj�c� si� z "+rozmiarTab+" element�w, kt�rej zawarto�� przedstawia si� jak poni�ej:");
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
		int wyb�rOpcji = 0;
		System.out.println("Co teraz chcesz zrobi�?:\n 1.Wyszuka� liniowo, czy dana liczba wyst�puje w zbiorze"
				+ "\n 2.Posortowa� zbi�r za pomoc� sortowania przez wybieranie \n 3.Posortowa� za pomoc� sortowania przez wstawianie."
				+ "\n 4.Zako�czy� dzia�anie programu.");
		while(wyb�rOpcji>4||wyb�rOpcji==0){
			wyb�rOpcji = fromUser.nextInt();
			
			if(wyb�rOpcji>4||wyb�rOpcji==0)
				System.out.println("Prosze wybra� liczb� z zakresu 1-4!");
		}
		switch(wyb�rOpcji){
			case 1:
				firstOp();
				firstQuest();
				break;
			case 2:
				System.out.println("Po posortowaniu wygl�d tablicy przedstawia si� jak poni�ej:");
				System.out.println(nowy.selectionSort(nowy.nieposortowany));
				break;
			case 3:
				System.out.println("Po posortowaniu wygl�d tablicy przedstawia si� jak poni�ej:");
				System.out.println(nowy.insertionSort(nowy.nieposortowany));
				break;
			case 4:
				System.out.println("Zako�czono prac� programu!");
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
				System.out.println("Dzi�ki posortowaniu zbi�ru istnieje mozliwo�� wyszukiwania binarnego wewn�trz zbioru. Czy chcesz to tero uczyni�? (1 = TAK/2 = NIE)");
				chooseYN = fromUser.nextInt();
				if(chooseYN<1||chooseYN>2){
					System.out.println("Odpowiedz tak (1) lub nie (2)!");
				}
			}
			switch(chooseYN){
				case 1:
					System.out.println("Prosz� poda� liczb�, kt�r� chcesz wyszuka�:");
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
		System.out.println("Prosz� poda� liczb�, kt�r� chcesz wyszuka�:");
		int poszukiwana = fromUser.nextInt();
		if(poszukiwana>granZakr){
			System.out.println("Poszukiwana liczba przekracza maksymaln� warto�� pozycji w utworzonej tabeli!");
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
			System.out.println("Co teraz chcia�by� zrobi�?:\n 1.Ponownie poszuka� okre�lonej liczby w utworzonym ju� zbiorze. \n 2.Rozpocz�� jeszcze raz.\n 3.Zako�czy� program.");
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
				System.out.println("Zako�czono prac� programu!");
				System.exit(0);
				break;
			default:
				System.out.println("Wybrano b��dn� opcj�!");
			}
		}
		fromUser.close();	
	}

	public static void main(String[] args){
		new Exec();
	}
}
