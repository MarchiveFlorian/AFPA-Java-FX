package fr.afpa;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class ListViewMoveManager {

    public static <T> void moveSelectedItemUp(ListView<T> listBox) {
        moveSelectedItem(listBox, -1);
    }

    public static <T> void moveSelectedItemDown(ListView<T> listBox) {
        moveSelectedItem(listBox, 1);
    }

    private static <T> void moveSelectedItem(ListView<T> listBox, int direction) {
        // Checking selected item
        int selectedIndex = listBox.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0) {
            return; // No selected item - nothing to do
        }

        // Calculate new index using move direction
        int newIndex = selectedIndex + direction;

        // Checking bounds of the range
        if (newIndex < 0 || newIndex >= listBox.getItems().size()) {
            return; // Index out of range - nothing to do
        }

        // Get the selected item
        T selected = listBox.getSelectionModel().getSelectedItem();

        // Get the list of items
        ObservableList<T> items = listBox.getItems();

        // Remove the selected item
        items.remove(selectedIndex);

        // Insert it in new position
        items.add(newIndex, selected);

        // Restore selection
        listBox.getSelectionModel().select(newIndex);
    }
}