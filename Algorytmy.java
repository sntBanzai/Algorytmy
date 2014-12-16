import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Algorytmy {
		public List<Integer> nieposortowany = new ArrayList<Integer>();
		public List<Integer> posortowany = new ArrayList<Integer>();
		public ArrayList<Boolean> trackBS = new ArrayList<Boolean>();
		boolean sorted;
		boolean found;
	
	
	public List<Integer> selectionSort(List<Integer> xyz){
			for(int i = 0; i<xyz.size()-1; i++){
				int min = xyz.get(i);
				int temp;
					for(int j = i+1;j<xyz.size();j++){
						int actual = xyz.get(j);
						if(actual<min){
							temp = xyz.set(i, actual);
							xyz.set(j, temp);
							min = xyz.get(i);
				}
			}
		}
		posortowany = xyz;
		sorted = true;
		return posortowany;
	}

	public List<Integer> insertionSort(List<Integer> xyz){
		for(int i = 1;i<xyz.size();i++){
			for(int j = i-1;j>=0;j--){
				int klucz = xyz.get(j+1);
				if (klucz<=xyz.get(j)) {
					int temp = xyz.set(j, klucz);
					xyz.set(j+1, temp);
					klucz = xyz.get(j+1);
				}
			}
		}
		posortowany = xyz;
		sorted = true;
		return posortowany;
	}
	
	public List<Integer> mergeSort(List<Integer> xyz){
		return xyz;
	}
	
	public void binarySearch(Integer n, List<Integer> xyz){
		octopussy:
		while(!xyz.isEmpty()){	
			int p = 0;
			int r = xyz.size();
			int mid = p+r/2;
			if(xyz.get(mid).equals(n)){
				System.out.println("Znaleziono liczbê "+n+" na pozycji "+bSearchAux()+". zbioru.");
				found = true;
				break octopussy;
			}
			if(xyz.get(mid)>n){
				r = mid;
				List<Integer> zyx = xyz.subList(p, r);
				binarySearch(n, zyx);
				trackBS.add(true);
				break octopussy;
				}
			else if((xyz.get(mid)<n)){
				p = mid;
				List<Integer>zyx = xyz.subList(p, r);
				binarySearch(n, zyx);
				trackBS.add(false);
				break octopussy;	
			}
		}
		if(found!=true){
			System.out.println("Nie znaleziono wskazanej liczby w zbiorze!");
		
		}
	}
	
	
	private int bSearchAux(){
		List<Integer> percentage = new ArrayList<Integer>();
		for(int i = 1;i<=100;i++){
			percentage.add(i);
		}
		System.out.println(percentage);
		int mid = percentage.size()/2;
		for(Boolean b:trackBS){
			if(mid<=percentage.size()){
				if(b==true){
					percentage = percentage.subList(0, mid);
					System.out.println(percentage);
				}
				else{
				percentage = percentage.subList(mid+1, percentage.size());
				System.out.println(percentage);
				}
			}
		}
		double d = mid/100;
		System.out.println("D = "+d);
		int wyszukanaPoz = (int) (d*posortowany.size())*100;
		System.out.println("Wyszukana Poz = "+wyszukanaPoz);
		return wyszukanaPoz;
	}
	
	
	public void lineSearch(Integer n2, List<Integer> xyz){
		boolean znaleziono = false;
		for(int i = 0;i<xyz.size();i++){
			if(xyz.get(i).equals(n2)){
				System.out.println("Znaleziono poszukiwan¹ liczbê pod indeksem "+i);
				znaleziono = true;
			}	
		}
		if(!znaleziono){
			System.out.println("W przeszukiwanym zbiorze nie znaleziono takiej wartoœci!");
		}
	}
	
	public List<Integer> createArray(int n, int nn){
		Random generator = new Random();
		for(int i=0; i<=n-1; i++){
			nieposortowany.add(generator.nextInt(nn));
		}
		return (ArrayList<Integer>) nieposortowany;
	}
	
	public void printArray(List<Integer> xyz){
		for(Integer n: xyz){
			System.out.print(" "+n);;
		}
	}
}
