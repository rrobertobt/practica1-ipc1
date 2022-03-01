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
	CustomMap(int rows, int columns, int reqGold, String name) {
		this.rows = rows;
		this.columns = columns;
		this.reqGold = reqGold;
		this.name = name;

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

	// funcion para pedir numeros dentro de un rango
	public static int askForNumberL(String message, int lMin, int lMax){
		int enteredNumber = 0;
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

	// FUNCION PARA LLENAR EL MAPA POR EL USUARIO
	public void FillMap() {

		System.out.println("Comenzando llenado de mapa...");

		// comenzamos por las salidas que tendra el mapa y en donde se ubicarán
		System.out.println("Colocando salidas del mapa:");
		int exitsCount = askForNumberGZ("Cuantas salidas tendra este mapa? > ");

		for (int i = 0; i < exitsCount; i++) {

			// mostramos el mapa en su estado actual
			System.out.println("Mapa actual:");
			for (int k = 0; k < generatedMap.length; k++) {
				for (int l = 0; l < generatedMap[k].length; l++) {
					if (generatedMap[k][l] == null) {
						generatedMap[k][l] = "-";
					}
					System.out.print(generatedMap[k][l]+" ");
				}
				System.out.println("");
			}


			System.out.println("Tomando coordenadas de las salidas: (debes ingresarlas solo en las paredes)");
			System.out.println("Donde se colocara la salida #"+(i+1)+"?");
			int rowExit = 0;
			int columnExit = 0;
			boolean inputCorrect = false;

			do {
				rowExit = askForNumberL("Fila? > ", 1, rows);
				rowExit -= 1;
				columnExit = askForNumberL("Columna? > ", 1, columns);
				columnExit -= 1;
				if(alreadyFilled(generatedMap, rowExit, columnExit)){
					System.out.println("Error: esa casilla ya esta llena");
				} else { inputCorrect = true; }

				generatedMap[rowExit][columnExit] = "S";
			} while (!inputCorrect);

		}

		// mostramos el mapa en su estado actual
		System.out.println("Mapa actual:");
		for (int k = 0; k < generatedMap.length; k++) {
			for (int l = 0; l < generatedMap[k].length; l++) {
				if (generatedMap[k][l] == null) {
					generatedMap[k][l] = "-";
				}
				System.out.print(generatedMap[k][l]+" ");
			}
			System.out.println("");
		}

		// luego preguntamos por las casillas de oro y sus ubicaciones
		System.out.println("Colocando casillas de oro:");

		boolean goldCountCorrect = false;
		int goldCount = 0;
		do {
			goldCount = askForNumberGZ("Cuantas casillas con oro tendra este mapa? Debe ser mayor de " + reqGold + " > ");
			if (goldCount < reqGold) {
				System.out.println("Error: El mapa debe tener la misma cantidad o mas casillas de oro que el oro requerido para salir");
			} else { goldCountCorrect = true; }

		} while (!goldCountCorrect);



		for (int i = 0; i < goldCount; i++) {
			System.out.println("Tomando coordenadas de casillas de oro:");
			System.out.println("Donde se colocara la casilla de oro #" + (i + 1) + "?");
			int rowGold = 0;
			int columnGold = 0;
			boolean inputCorrect = false;

			do {
				rowGold = askForNumberL("Fila? > ", 1, rows);
				rowGold -= 1;
				columnGold = askForNumberL("Columna? > ", 1, columns);
				columnGold -= 1;
				if(alreadyFilled(generatedMap, rowGold, columnGold)){
					System.out.println("Error: esa casilla ya esta llena");
				} else { inputCorrect = true; }

				generatedMap[rowGold][columnGold] = "G";
			} while (!inputCorrect);

		}

		// MOSTRAR ESTADO ACTUAL DEL MAPA

		System.out.println("Mostrando previsualizacion del estado actual del mapa: ");

		for (int i = 0; i < generatedMap.length; i++) {
			for (int j = 0; j < generatedMap[i].length; j++) {
				if (generatedMap[i][j] == null) {
					generatedMap[i][j] = "-";
				}
				System.out.print(generatedMap[i][j]+" ");
			}
			System.out.println("");
		}

		System.out.println("");

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
