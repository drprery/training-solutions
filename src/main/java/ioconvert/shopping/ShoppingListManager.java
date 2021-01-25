package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream os, List<String> shopItems) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {

            for (String shopItem : shopItems) {
                bw.write(shopItem+"\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    public List<String> loadShoppingList(InputStream is) {
        List<String> shopItems = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;

            while ((line = br.readLine()) != null) {
                shopItems.add(line);
            }
            return shopItems;

        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}
