package practica1.ipc1;
import java.util.Scanner;

public class Main{

	// VARS GLOBALES
	static Scanner input = new Scanner(System.in);
	static String[][][] maps;
	static int[] reqGoldList = new int[10];
	static String[] mapNamesList = new String[10];
	static int mapIndex = 1;


	public static void main(String[] args) {

		// definimos el limite de mapas a 10
		maps = new String[10][][];

		// inicia: asignación de mapa por defecto como primer mapa en la lista

	String[][] mapDefault ={{"#","#","#","#","#","#","#","#","S","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
				{"S","O","O","O","O","O","O","#","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","O","#","O","O","S"},
				{"#","#","#","#","#","#","O","O","#","#","#","O","#","#","#","O","#","O","O","#","#","#","#","#","#","O","O","#","O","#"},
				{"#","O","O","G","O","#","O","#","G","G","#","O","#","G","#","O","#","G","#","O","#","O","O","O","#","#","O","O","O","#"},
				{"#","O","#","#","O","#","O","O","O","O","#","G","#","O","#","O","#","#","O","O","#","O","#","O","O","#","O","#","O","#"},
				{"#","G","#","O","O","#","O","#","#","#","#","#","#","O","#","O","O","O","#","O","#","O","#","#","#","#","O","#","O","#"},
				{"#","O","#","#","O","O","O","O","O","O","#","O","#","O","O","O","O","O","O","O","O","O","#","O","O","O","O","#","#","#"},
				{"#","#","O","O","O","#","O","#","O","#","O","O","#","#","O","#","#","O","#","#","#","#","#","O","#","O","#","#","G","#"},
				{"#","O","O","#","O","#","O","O","O","#","O","#","O","#","O","O","#","O","#","O","O","O","O","O","#","O","O","#","G","#"},
				{"#","O","#","#","O","#","#","#","O","#","O","#","O","#","#","O","#","O","#","#","#","O","#","#","#","#","G","#","O","#"},
				{"#","O","O","O","O","#","O","#","O","#","O","#","O","#","O","O","#","O","O","G","#","O","O","#","O","#","O","#","O","#"},
				{"#","#","#","G","#","O","O","O","O","#","O","#","O","#","#","O","#","#","#","#","#","O","#","o","#","#","O","#","O","#"},
				{"#","O","O","#","O","O","#","#","#","O","O","#","O","#","O","O","O","O","O","O","O","O","O","O","O","#","O","#","O","#"},
				{"#","#","O","#","#","O","#","O","O","#","O","#","O","O","O","#","O","#","#","O","#","O","O","#","O","#","O","#","O","#"},
				{"#","O","O","#","O","O","#","O","#","#","O","#","G","#","O","#","#","O","O","#","O","O","#","O","O","#","O","#","O","#"},
				{"#","#","O","#","#","O","O","O","G","#","O","#","#","#","O","#","O","O","O","O","O","#","O","O","#","#","O","#","O","#"},
				{"#","O","O","#","O","O","#","O","#","#","O","O","#","O","O","#","O","#","#","#","#","#","O","#","O","#","G","#","O","#"},
				{"#","#","O","O","O","#","#","#","O","#","O","#","O","#","O","O","O","#","G","O","O","O","O","O","O","O","#","#","O","#"},
				{"#","G","#","O","#","O","O","O","O","#","O","O","#","#","#","#","#","#","#","#","#","#","#","#","#","O","O","O","O","#"},
				{"#","G","#","O","O","O","#","#","O","O","O","O","O","G","O","O","O","G","O","O","O","G","O","O","#","#","O","#","O","#"},
				{"#","O","#","#","#","#","#","O","O","#","#","#","#","#","#","#","#","#","#","#","#","#","#","O","O","#","O","#","#","#"},
				{"#","O","#","O","O","O","#","O","#","O","O","O","O","O","O","O","O","O","O","O","O","O","O","#","O","#","O","O","O","S"},
				{"#","O","O","O","#","O","#","O","O","#","O","#","#","#","#","#","#","O","#","#","#","O","O","O","O","#","O","#","#","#"},
				{"#","#","#","#","#","O","#","O","#","O","O","#","G","O","O","O","#","O","O","O","#","O","#","#","#","#","O","#","O","#"},
				{"#","O","#","O","O","O","#","O","G","#","O","#","#","#","#","O","#","#","#","O","#","O","O","O","O","#","O","O","O","#"},
				{"#","O","#","#","#","O","#","#","#","#","O","#","O","O","O","O","#","G","#","O","#","#","#","O","#","G","#","#","O","#"},
				{"#","O","#","O","O","O","O","O","O","O","O","O","O","#","O","O","#","O","#","O","O","O","O","O","#","O","#","O","O","#"},
				{"#","O","#","#","#","#","#","#","#","#","#","O","#","O","#","#","#","O","#","O","#","#","#","#","#","O","O","O","#","#"},
				{"#","O","O","O","O","O","G","#","O","O","O","O","#","O","O","O","O","O","O","O","O","O","O","O","O","O","#","O","G","#"},
				{"#","#","#","#","#","#","#","#","#","#","#","#","#","S","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"}};

		maps[0] = new String[mapDefault.length][mapDefault.length];

		for (int i = 0; i < mapDefault.length; i++) {
			for (int j = 0; j < mapDefault.length; j++) {
				maps[0][i][j] = mapDefault[i][j];
			}
		}

		reqGoldList[0] = 15;
		mapNamesList[0] = "Predeterminado";

		// termina: asignación de mapa por defecto como primer mapa en la lista, oro requerido para mapa por defecto y nombre

		mainMenu();

	}

	// MENU PRINCIPAL
	public static void mainMenu() {

		int selection = 0;

		String mainMenuOptions = """
				================ Escape del laberinto =================
				==================== Menú principal ===================
				
				1): Jugar
				2): Crear mapa
				3): Reportes / Estadísticas de juego
				4): Visualizar mapa
				5): Salir del juego
				>\040""";

		selection = askForNumberL(mainMenuOptions, 1, 5);


		switch (selection) {
			case 1 :
				System.out.println("Jugar");
				break;
			case 2: {
				prepareMapCreation();
				break;
			}
			case 3:
				System.out.println("reportes");
				break;
			case 4:
				System.out.println("====== Entrando a previsualizador de mapas ======");
				previewMap(maps);
				break;
			case 5:
				System.out.println("====== Saliendo del juego ... ======");
				System.exit(0);
				break;
		}

	}
	// TEMRINA MENU PRINCIPAL


	// PREVISUALIZADOR DE MAPAS
	public static void previewMap(String[][][] maps){
		int selection;
		int avaliableMaps = 0;
		// obtenemos la cantidad de mapas dispobnibles

		for (int i = 0; i < maps.length; i++) {
			if (maps[i] != null) {
				avaliableMaps = i+1;
			} else {
				break;
			}
		}

		do {
			System.out.println("Mapas disponibles:");
			// listamos los mapas que estan disponibles
			for (int i = 0; i < maps.length; i++) {
				if (i==0) {
					System.out.println("Mapa #"+(i+1)+" (mapa predeterminado)");
				} else if (maps[i] != null){
					System.out.println("Mapa #"+(i+1));
				} else {
					break;
				}
			}
			// pedimos el mapa a mostrar
			selection = askForNumberL("Selecciona un mapa de los " +avaliableMaps+ " disponibles, o escribe 0 para regresar a menu principal\n> ", 0, avaliableMaps);

			// finalmente, mostramos el mapa seleccionado o salimos del previsualizador

			if (selection > 0){
				for (int i = (selection-1); i < maps.length;) {
					System.out.println("Mostrando mapa #"+(i+1));
					for (int j = 0; j < maps[i].length; j++) {
						for (int k = 0; k < maps[i][j].length; k++) {
							System.out.print(maps[i][j][k]+" ");
						}
						System.out.println("");
					}
					break;
				}
			}

		} while (selection != 0);

		mainMenu();

	}
	// TERMINA PREVISUALIZADOR DE MAPAS

	// PREPARAR CREACION DE MAPAS
	public static void prepareMapCreation(){

		System.out.println("====== Entrando a creador de mapas ======");
		System.out.println("Aviso: Puede crear hasta 9 mapas");
		System.out.println("Comenzando creación del nuevo mapa:");
		System.out.println("De que tamaño desea crearlo?");
		int rows = askForNumberGZ("Filas? > ");
		int columns = askForNumberGZ("Columnas? > ");
		int reqGold = askForNumberGZ("Cantidad de oro necesario para salir? > ");
		reqGoldList[mapIndex] = reqGold;
		CustomMap newMap = new CustomMap(rows, columns, reqGold);
		newMap.FillMap();
		String[][] createdMap = newMap.generatedMap;
		maps[mapIndex] = createdMap;
		mapIndex += 1;

		// una vez terminada la creacion de un mapa, regresar al menu
		mainMenu();

	}
	// TERMINA PREPARAR CREACION DE MAPAS



	// FUNCIONES AUXILIARES

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

	// funcion para pedir numeros mayor que cero
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


	// funcion para pedir numeros sin limite
	public static int askForNumberNL(String message){
		int enteredNumber = 0;
		boolean inputError = false;

		do {
			try {
				System.out.print(message);
				enteredNumber = input.nextInt();
				inputError = false;

			} catch (Exception ex) {
				inputError = true;
				System.out.println("El valor ingresado no es valido, intenta de nuevo");
				input.next();

			}

		} while (inputError);
		return enteredNumber;
	}



}