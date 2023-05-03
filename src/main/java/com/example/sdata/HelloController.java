package com.example.sdata;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    @FXML
    private TextField kontrolaText;
    @FXML

    private TextField pridejItemText;
    @FXML
    private Button KontrolaButtonClick;
    @FXML

    private TextArea Vystup;
    public void AddButtonClick(ActionEvent actionEvent) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:items.db");
        Vystup.setText("ADD");
        Item i = new Item(getLastID() + 1, pridejItemText.getText());
        AddItem(i, conn);
    }

    public void KontrolaButtonClick(ActionEvent actionEvent) throws SQLException{
        if (getItemState(kontrolaText.getText()) == true) {
            Vystup.setText(kontrolaText.getText() + " již je v seznamu");
        }
        else {
            Vystup.setText(kontrolaText.getText() + " ještě není v seznamu");
        }

    }
    public static void AddItem(Item item1, Connection conn) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO items (id, name) VALUES (?, ?)");
        pstmt.setInt(1, item1.getId());
        pstmt.setString(2, item1.getName());
        pstmt.executeUpdate();
    }

    public int getLastID()throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:items.db");
        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery("SELECT MAX(id) FROM items");
        int lastId = rs.getInt(1);

        statement.close();
        conn.close();
        return lastId;
    }
    public boolean getItemState(String itemName) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:items.db");
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM items WHERE name = ?");
        statement.setString(1, itemName);
        ResultSet rs = statement.executeQuery();
        boolean itemExists = rs.getInt(1) > 0;

        statement.close();
        conn.close();

        return itemExists;

    }
}