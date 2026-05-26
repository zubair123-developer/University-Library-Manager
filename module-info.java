module com.library.librarymanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.library.librarymanager to javafx.fxml;
    exports com.library.librarymanager;
    opens db;
    opens dao;
    opens model;
    opens controller;
}