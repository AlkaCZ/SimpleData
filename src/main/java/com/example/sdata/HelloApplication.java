package com.example.sdata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        //Connection conn = DriverManager.getConnection("jdbc:sqlite:items.db");
        //Statement statement = conn.createStatement();
        //statement.executeUpdate("CREATE TABLE IF NOT EXISTS items (id INTEGER PRIMARY KEY, name TEXT)");
       // Item item1 = new Item(1, "Book");
        //Item item2 = new Item(2, "T-shirt");
        //AddItem(item1, conn);
        //AddItem(item2, conn);
        //ResultSet rs = statement.executeQuery("SELECT * FROM items");
        //while (rs.next()) {
          //  int id = rs.getInt("id");
            //String name = rs.getString("name");
            //Item item = new Item(id, name);
            //System.out.println(item);
        //}
        //statement.close();
        //conn.close();

    }

    public static void AddItem(Item item1,Connection conn) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO items (id, name) VALUES (?, ?)");
        pstmt.setInt(1, item1.getId());
        pstmt.setString(2, item1.getName());
        pstmt.executeUpdate();
    }

    public static void main(String[] args) {
        launch();

    }
}