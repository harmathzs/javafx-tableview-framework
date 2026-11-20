package org.example.javafxtableviewframework;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.function.Function;

public class SimpleTableviewManager {
    private TableView<ObservableList<String>> tableview;
    private ObservableList<ObservableList<String>> tableData;


    public TableView<ObservableList<String>> getTableview() {
        return tableview;
    }

    public void setTableview(TableView<ObservableList<String>> tableview) {
        this.tableview = tableview;
    }

    public ObservableList<ObservableList<String>> getTableData() {
        return tableData;
    }

    public void setTableData(ObservableList<ObservableList<String>> tableData) {
        this.tableData = tableData;
    }

    public SimpleTableviewManager(TableView<ObservableList<String>> tableview, ObservableList<ObservableList<String>> tableData) {
        this.tableview = tableview;
        this.tableData = tableData;
    }

    public SimpleTableviewManager(TableView<ObservableList<String>> tableview) {
        this.tableview = tableview;
        this.tableData = null;
    }

    public SimpleTableviewManager(ObservableList<ObservableList<String>> tableData) {
        this.tableview = null;
        this.tableData = tableData;
    }

    public SimpleTableviewManager() {
        this.tableview = null;
        this.tableData = null;
    }

    public SimpleTableviewManager(String[][] data) {
        this.tableview = null;
        this.tableData = null;
        if (data != null) {
            for (String[] row : data) {
                ObservableList<String> rowData = javafx.collections.FXCollections.observableArrayList(row);
                if (this.tableData == null) {
                    this.tableData = javafx.collections.FXCollections.observableArrayList();
                }
                this.tableData.add(rowData);
            }
        }
    }

    public SimpleTableviewManager(String[][] data, TableView<ObservableList<String>> tableview) {
        this.tableview = tableview;
        this.tableData = null;
        if (data != null) {
            for (String[] row : data) {
                ObservableList<String> rowData = javafx.collections.FXCollections.observableArrayList(row);
                if (this.tableData == null) {
                    this.tableData = javafx.collections.FXCollections.observableArrayList();
                }
                this.tableData.add(rowData);
            }
        }
    }

    public SimpleTableviewManager(List<List<String>> data) {
        this.tableview = null;
        this.tableData = null;
        if (data != null) {
            for (List<String> row : data) {
                ObservableList<String> rowData = javafx.collections.FXCollections.observableArrayList(row);
                if (this.tableData == null) {
                    this.tableData = javafx.collections.FXCollections.observableArrayList();
                }
                this.tableData.add(rowData);
            }
        }
    }

    public String getCellValue(int rowIndex, int columnIndex) {
        if (tableData != null && rowIndex >= 0 && rowIndex < tableData.size()) {
            ObservableList<String> row = tableData.get(rowIndex);
            if (columnIndex >= 0 && columnIndex < row.size()) {
                return row.get(columnIndex);
            }
        }
        return null;
    }

    public void setCellValue(int rowIndex, int columnIndex, String value) {
        if (tableData != null && rowIndex >= 0 && rowIndex < tableData.size()) {
            ObservableList<String> row = tableData.get(rowIndex);
            if (columnIndex >= 0 && columnIndex < row.size()) {
                row.set(columnIndex, value);
            }
        }
    }

    public void addRow(List<String> rowData) {
        if (tableData != null) {
            ObservableList<String> newRow = javafx.collections.FXCollections.observableArrayList(rowData);
            tableData.add(newRow);
        }
    }

    public void insertRow(int rowIndex, List<String> rowData) {
        if (tableData != null && rowIndex >= 0 && rowIndex <= tableData.size()) {
            ObservableList<String> newRow = javafx.collections.FXCollections.observableArrayList(rowData);
            tableData.add(rowIndex, newRow);
        }
    }

    public void updateRow(int rowIndex, List<String> rowData) {
        if (tableData != null && rowIndex >= 0 && rowIndex < tableData.size()) {
            ObservableList<String> updatedRow = javafx.collections.FXCollections.observableArrayList(rowData);
            tableData.set(rowIndex, updatedRow);
        }
    }

    public String[] getRow(int rowIndex) {
        if (tableData != null && rowIndex >= 0 && rowIndex < tableData.size()) {
            ObservableList<String> row = tableData.get(rowIndex);
            return row.toArray(new String[0]);
        }
        return null;
    }

    public void removeRow(int rowIndex) {
        if (tableData != null && rowIndex >= 0 && rowIndex < tableData.size()) {
            tableData.remove(rowIndex);
        }
    }

    public void addColumn(String[] columnData) {
        if (tableData != null) {
            for (int i = 0; i < columnData.length; i++) {
                if (i < tableData.size()) {
                    ObservableList<String> row = tableData.get(i);
                    row.add(columnData[i]);
                } else {
                    ObservableList<String> newRow = javafx.collections.FXCollections.observableArrayList();
                    newRow.add(columnData[i]);
                    tableData.add(newRow);
                }
            }
        }
    }

    public void insertColumn(int columnIndex, String[] columnData) {
        if (tableData != null) {
            for (int i = 0; i < columnData.length; i++) {
                if (i < tableData.size()) {
                    ObservableList<String> row = tableData.get(i);
                    if (columnIndex >= 0 && columnIndex <= row.size()) {
                        row.add(columnIndex, columnData[i]);
                    }
                } else {
                    ObservableList<String> newRow = javafx.collections.FXCollections.observableArrayList();
                    newRow.add(columnData[i]);
                    tableData.add(newRow);
                }
            }
        }
    }

    public void updateColumn(int columnIndex, String[] columnData) {
        if (tableData != null) {
            for (int i = 0; i < columnData.length; i++) {
                if (i < tableData.size()) {
                    ObservableList<String> row = tableData.get(i);
                    if (columnIndex >= 0 && columnIndex < row.size()) {
                        row.set(columnIndex, columnData[i]);
                    }
                }
            }
        }
    }

    public String[] getColumn(int columnIndex) {
        if (tableData != null) {
            String[] columnData = new String[tableData.size()];
            for (int i = 0; i < tableData.size(); i++) {
                ObservableList<String> row = tableData.get(i);
                if (columnIndex >= 0 && columnIndex < row.size()) {
                    columnData[i] = row.get(columnIndex);
                } else {
                    columnData[i] = null;
                }
            }
            return columnData;
        }
        return null;
    }

    public void removeColumn(int columnIndex) {
        if (tableData != null) {
            for (ObservableList<String> row : tableData) {
                if (columnIndex >= 0 && columnIndex < row.size()) {
                    row.remove(columnIndex);
                }
            }
        }
    }

    public void clearTable() {
        if (tableData != null) {
            tableData.clear();
        }
    }

    public void setCellTextColor(int rowIndex, int columnIndex, String color) {
        if (tableview != null && rowIndex >= 0 && rowIndex < tableview.getItems().size()) {
            ObservableList<String> row = tableview.getItems().get(rowIndex);
            if (columnIndex >= 0 && columnIndex < row.size()) {
                // Assuming you have a method to set the text color of a cell
                // This is a placeholder for actual implementation
                // You might need to use a custom cell factory to achieve this
            }
        }
    }

    public String getCellTextColor(int rowIndex, int columnIndex) {
        if (tableview != null && rowIndex >= 0 && rowIndex < tableview.getItems().size()) {
            ObservableList<String> row = tableview.getItems().get(rowIndex);
            if (columnIndex >= 0 && columnIndex < row.size()) {
                // Assuming you have a method to get the text color of a cell
                // This is a placeholder for actual implementation
                // You might need to use a custom cell factory to achieve this
                return "color"; // Placeholder
            }
        }
        return null;
    }

    public void setCellBackgroundColor(int rowIndex, int columnIndex, String color) {
        if (tableview != null && rowIndex >= 0 && rowIndex < tableview.getItems().size()) {
            ObservableList<String> row = tableview.getItems().get(rowIndex);
            if (columnIndex >= 0 && columnIndex < row.size()) {
                // Assuming you have a method to set the background color of a cell
                // This is a placeholder for actual implementation
                // You might need to use a custom cell factory to achieve this
            }
        }
    }

    public String getCellBackgroundColor(int rowIndex, int columnIndex) {
        if (tableview != null && rowIndex >= 0 && rowIndex < tableview.getItems().size()) {
            ObservableList<String> row = tableview.getItems().get(rowIndex);
            if (columnIndex >= 0 && columnIndex < row.size()) {
                // Assuming you have a method to get the background color of a cell
                // This is a placeholder for actual implementation
                // You might need to use a custom cell factory to achieve this
                return "color"; // Placeholder
            }
        }
        return null;
    }

    public void handleCellClick(int rowIndex, int columnIndex, Function<String, Void> onClick) {
        if (tableview != null && rowIndex >= 0 && rowIndex < tableview.getItems().size()) {
            ObservableList<String> row = tableview.getItems().get(rowIndex);
            if (columnIndex >= 0 && columnIndex < row.size()) {
                String cellValue = row.get(columnIndex);
                // Handle the cell click event here
                onClick.apply(cellValue);
                System.out.println("Cell clicked at (" + rowIndex + ", " + columnIndex + "): " + cellValue);
            }
        }
    }
}
