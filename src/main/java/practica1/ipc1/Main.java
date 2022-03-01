package practica1.ipc1;
import java.util.Scanner;

public class Main{

	public static Scanner input = new Scanner(System.in);
	public static String[][][] maps;
	public static int[] reqGold = new int[10];

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

		String[][] mapDefault2 ={{"#","#","#","#","#","#","#","#","S","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
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
				{"#","#","#","#","#","#","#","#","#","#","#","#","#","S","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"}};


		maps[0] = new String[mapDefault.length][mapDefault.length];

		for (int i = 0; i < mapDefault.length; i++) {
			for (int j = 0; j < mapDefault.length; j++) {
				maps[0][i][j] = mapDefault[i][j];
			}
		}

		reqGold[0] = 15;


		// termina: asignación de mapa por defecto como primer mapa en la lista

		// prueba: mapa 2

		maps[1] = new String[mapDefault2.length][mapDefault2.length];
		for (int i = 0; i < mapDefault2.length; i++) {
			for (int j = 0; j < mapDefault2.length; j++) {
				maps[1][i][j] = mapDefault2[i][j];
			}
		}

		// termina prueba: mapa 2

		mainMenu();

	}
	
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
			selection = askForNumber("Selecciona un mapa de los " +avaliableMaps+ " disponibles, o escribe 0 para regresar a menu principal\n> ", 0, avaliableMaps);

			// finalmente, mostramos el mapa seleccionado o salimos del previsualizador

			if (selection > 0){
				for (int i = (selection-1); i < maps.length;) {
					for (int j = 0; j < maps[i].length; j++) {
						for (int k = 0; k < maps[i][j].length; k++) {
							System.out.print(maps[i][j][k]);
						}
						System.out.println("");
					}
					break;
				}
			}

		} while (selection != 0);

		mainMenu();

	}

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

		selection = askForNumber(mainMenuOptions, 1, 5);


		switch (selection) {
			case 1 :
				System.out.println("Jugar");
				break;
			case 2: {
				System.out.println("====== Entrando a creador de mapas ======");
				CustomMap newMap = new CustomMap(5,5,1);
//				mapa1.generate();
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


	public static int askForNumber(String message, int lMin, int lMax){
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

}