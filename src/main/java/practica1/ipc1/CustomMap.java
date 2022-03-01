package practica1.ipc1;
import java.util.Scanner;


public class CustomMap {
	public static Scanner input = new Scanner(System.in);
	int mapIndex;
	int columns;
	int rows;
	int reqGold;
	String[][] generatedMap;

	CustomMap(int columns, int rows, int mapIndex) {
		this.columns = columns;
		this.rows = rows;
		this.mapIndex = mapIndex;
	}

	public static String[][] askForCharacter(String message){
		String enteredChar;
		boolean inputError = false;

		do {
			try {
				System.out.print(message);
				enteredNumber = input.nextInt();
				if ((enteredNumber >= lMin) && (enteredNumber <= lMax)) {
					inputError = false;
				} else {
					inputError = true;
					System.out.println("El valor ingresado debe ser entre "+ lMin +" y " + lMax);
					System.out.println("Intenta de nuevo");
				}

			} catch (Exception ex) {
				inputError = true;
				System.out.println("El valor ingresado no es valido, intenta de nuevo");
				input.next();

			}

		} while (inputError);
		return enteredNumber;
	}

	public void FillMap() {
		System.out.println("Hola");
	}
}
