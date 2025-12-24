package SRP.BookSave;

import SRP.Solution.BookSRP;

// Classe BookSaver : persistance
 class BookSaver {

    public void saveToDatabase(BookSRP book) {

        System.out.println("\nSauvegarde de '" + book.getTitle() + "' en base de données..."); }

//On peut ajouter d'autres façons de sauvegarder

    public void saveToFile(BookSRP book, String filename) {

        System.out.println("\nSauvegarde de '" + book.getTitle() + "' dans " + filename); }
 }
