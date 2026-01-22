/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author Bui_Hai_Dang
 */
import model.SetMenu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class SetMenus extends HashMap<String, SetMenu> {

    private final String pathFile = "FeastMenu.csv";

    public void readFromFile() {
        try ( BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line;
            String headLine = br.readLine();
            if (headLine.startsWith("\uFEFF")) {
                headLine = headLine.substring(1);  
            }
            List<String> Line = parseCSVLine(headLine);
            System.out.println("Header line: [" + headLine + "]");
            System.out.println("Parsed headers: " + Line);

            int indexMenuID = -1;
            int indexName = -1;
            int indexPrice = -1;
            int indexIngredients = -1;

            for (int i = 0; i < Line.size(); ++i) {
                String columnName = Line.get(i).trim();

                switch (columnName) {
                    case "Code":
                        indexMenuID = i;
                        break;
                    case "Name":
                        indexName = i;
                        break;
                    case "Price":
                        indexPrice = i;
                        break;
                    case "Ingredients":
                        indexIngredients = i;
                        break;
                    default:
                        break;
                }
            }

            if (indexMenuID == -1 || indexName == -1
                    || indexPrice == -1 || indexIngredients == -1) {
                System.out.println("File don't have enough collum");
                System.out.println(indexMenuID);
                System.out.println(indexName);
                System.out.println(indexPrice);
                System.out.println(indexIngredients);
                return;
            }

            while ((line = br.readLine()) != null) {
                List<String> parts = parseCSVLine(line);

                if (parts.size() >= Line.size()) {
                    try {
                        String menuId = parts.get(indexMenuID).trim();
                        String name = parts.get(indexName).trim();
                        double price = Double.parseDouble(parts.get(indexPrice).trim());
                        String description = parts.get(indexIngredients).trim();

                        SetMenu sm = new SetMenu(menuId, name, price, description);
                        this.put(sm.getMenuId(), sm);

                    } catch (NumberFormatException e) {
                        System.out.println("Error read Line" + line);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading FeastMenu.csv");
        }
    }

    private List<String> parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                inQuotes = !inQuotes; // đảo trạng thái trong/ngoài dấu ngoặc kép
            } else if (c == ',' && !inQuotes) {
                // dấu phẩy ngoài dấu ngoặc → kết thúc 1 cột
                result.add(current.toString());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }

        // thêm cột cuối
        result.add(current.toString());

        return result;
    }

    public void showMenuList() {
        System.out.println("------------------------------------------------------------");
        System.out.println("List of Set Menus for ordering party:");
        System.out.println("------------------------------------------------------------");

        for (SetMenu m : this.values()) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Code        : " + m.getMenuId());
            System.out.println("Name        : " + m.getMenuName());
            System.out.printf("Price       : %,.0f Vnd\n", m.getPrice());
            System.out.println("Ingredients :");
            String raw = m.getIngredients().replace("\"", "");
            String[] groups = raw.split("#");

            for (String group : groups) {
                System.out.println("+ " + group.trim());
            }
        }
        System.out.println("-------------------------------------------------------");
    }

}
