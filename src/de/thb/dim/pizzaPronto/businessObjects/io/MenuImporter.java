package de.thb.dim.pizzaPronto.businessObjects.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.thb.dim.pizzaPronto.valueObjects.DessertVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.PastaVO;
import de.thb.dim.pizzaPronto.valueObjects.PizzaVO;

public class MenuImporter {

	public MenuImporter() {
	}

	public MenuVO readMenu(String fileName) throws IOException, FileNotFoundException {
		List<DishVO> dishes;
		MenuVO menu = null;
		String line = null;
		String[] words = null;
		DishVO currentDish = null;
		ArrayList<String> ingredients = new ArrayList<String>();
		dishes = new LinkedList<DishVO>();
		String[] s = null;
		FileReader reader = null;
		try {
			reader = new FileReader(new File(fileName));
		} catch(FileNotFoundException e) {
			throw new FileNotFoundException(fileName + " (Das System kann die angegebene Datei nicht finden)");
		}
		BufferedReader textFile = new BufferedReader(reader);
		
		while ((line = textFile.readLine()) != null) {
			words = line.split(":");
			if (words[0].equals("dish.type")) {
				
				if (words[1].equals("Pizza")) {
					currentDish = new PizzaVO();
				}
				if (words[1].equals("Pasta")) {
					currentDish = new PastaVO();
				}
				if (words[1].equals("Dessert")) {
					currentDish = new DessertVO();
				}
				dishes.add(currentDish);
				ingredients = new ArrayList<String>();
				
			}
			if (words[0].equals("dish.nr")) {
				int nr = Integer.parseInt(words[1]);
				currentDish.setNumber(nr);
			}
			if (words[0].equals("dish.name"))
				currentDish.setName(words[1]);

			if (words[0].equals("dish.price")) {
				float preis = Float.parseFloat(words[1]);
				currentDish.setPrice(preis);
			}
			if (words[0].equals("dish.size")) {
				int size = Integer.parseInt(words[1]);
				((PizzaVO) currentDish).setSize(size);
			}
			if (words[0].equals("dish.typeOfPasta")) {
				int sorte = Integer.parseInt(words[1]);
				((PastaVO) currentDish).setTypeOfPasta(sorte);
			}
			if (words[0].equals("dish.incredient")) {
				ingredients.add(words[1]);
			}
			if (ingredients.size() > 0) {
				s = ingredients.toArray(new String[ingredients.size()]);
				currentDish.setIngredients(s);
			}
		}
		menu = new MenuVO(new ArrayList<DishVO>(dishes));
		textFile.close();

		return menu;
	}

}
