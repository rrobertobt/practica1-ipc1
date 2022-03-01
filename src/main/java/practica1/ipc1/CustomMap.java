package practica1.ipc1;
import java.util.Scanner;


public class CustomMap {

	// VARS GLOBALES
	public static Scanner input = new Scanner(System.in);
	static String name;
	static int columns;
	static int rows;
	static int reqGold;
	static String[][] generatedMap;

	// CONSTRUCTOR
	CustomMap(int rows, int columns, int reqGold) {
		this.rows = rows;
		this.columns = columns;
		this.reqGold = reqGold;

		generatedMap = new String[rows][columns];
	}

	// FUNCION PARA PEDIR NUMERO MAYOR QUE CERO
	public static int askForNumberGZ(String message){
		int enteredNumber = 0;
		boolean inputError = false;

		do {
			try {
				System.out.print(message);
				enteredNumber = input.nextInt();

				if ((enteredNumber > 0)) {
					inputError = false;
				} else {
					inputError = true;
					System.out.println("El valor ingresado debe ser mayor que cero");
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

	// FUNCION PARA PEDIR NUMEROS POSITIVOS
	public static int askForNumber(String message){
		int enteredNumber = 0;
		boolean inputError = false;

		do {
			try {
				System.out.print(message);
				enteredNumber = input.nextInt();

				if ((enteredNumber >= 0)) {
					inputError = false;
				} else {
					inputError = true;
					System.out.println("El valor ingresado debe ser positivo");
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

	// FUNCION PARA LLENAR EL MAPA POR EL USUARIO
	public void FillMap() {

		System.out.println("Comenzando llenado de mapa...");

		// comenzamos por las salidas que tendra el mapa y en donde se ubicarán
		System.out.println("Colocando salidas del mapa:");
		int exitsCount = askForNumberGZ("Cuantas salidas tendra este mapa? > ");

		for (int i = 0; i < exitsCount; i++) {
			System.out.println("Tomando coordenadas de las salidas: (debes ingresarlas solo en las paredes)");
			System.out.println("Donde se colocara la salida #"+(i+1)+"?");
			int rowExit = 0;
			int columnExit = 0;
			boolean inputCorrect = false;

			do {
				rowExit = askForNumber("Fila? > ");
				rowExit -= 1;
				columnExit = askForNumber("Columna? > ");
				columnExit -= 1;
				if(alreadyFilled(generatedMap, rowExit, columnExit)){
					System.out.println("Error: esa casilla ya esta llena");
				} else { inputCorrect = true; }

				generatedMap[rowExit][columnExit] = "S";
			} while (!inputCorrect);

		}

		// luego preguntamos por las casillas de oro y sus ubicaciones
		System.out.println("Colocando casillas de oro:");
		int goldCount = askForNumberGZ("Cuantas casillas con oro tendra este mapa?");
		for (int i = 0; i < goldCount; i++) {
			System.out.println("Tomando coordenadas de casillas de oro:");
			System.out.println("Donde se colocara la casilla de oro #" + (i + 1) + "?");
			int rowGold = 0;
			int columnGold = 0;
			boolean inputCorrect = false;

			do {
				rowGold = askForNumber("Fila? > ");
				rowGold -= 1;
				columnGold = askForNumber("Columna? > ");
				columnGold -= 1;
				if(alreadyFilled(generatedMap, rowGold, columnGold)){
					System.out.println("Error: esa casilla ya esta llena");
				} else { inputCorrect = true; }

				generatedMap[rowGold][columnGold] = "G";
			} while (!inputCorrect);

		}

		// paredes
//		System.out.println("Colocando paredes:");
//		// Calculamos cuantos espacios estan vacios
//		int leftSpaces = (rows*columns);
//		int goldCount = askForNumberGZ("Cuantas casillas con oro tendra este mapa?");
//		for (int i = 0; i < goldCount; i++) {
//			System.out.println("Tomando coordenadas de casillas de oro:");
//			System.out.println("Donde se colocara la casilla de oro #" + (i + 1) + "?");
//			int rowGold = 0;
//			int columnGold = 0;
//			boolean inputCorrect = false;
//
//			do {
//				rowGold = askForNumber("Fila? > ");
//				columnGold = askForNumber("Columna? > ");
//				if(alreadyFilled(generatedMap, rowGold, columnGold)){
//					System.out.println("Error: esa casilla ya esta llena");
//				} else { inputCorrect = true; }
//
//				generatedMap[rowGold][columnGold] = "G";
//			} while (!inputCorrect);
//
//		}

	}


	// FUNCION PARA COMPROBAR SI YA SE LLENO LA CASILLA QUE SE ESTÁ INTENTANDO LLENAR
	private boolean alreadyFilled(String[][] mapToVerify, int row, int column){
		if ("S".equals(mapToVerify[row][column]) || "G".equals(mapToVerify[row][column]) || "#".equals(mapToVerify[row][column]) || "O".equals(mapToVerify[row][column])){
			return true;
		} else {
			return false;
		}
	}
}
