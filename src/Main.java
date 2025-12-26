import DIP.Solution.DataBase;
import DIP.Solution.MongoDBDatabase;
import DIP.Solution.MySQLDatabase;
import DIP.Violation.OrderProcessor;
import ISP.Solution.HumanWorkerISP;
import ISP.Solution.RobotWorkerISP;
import ISP.Violation.HumanWorker;
import ISP.Violation.RobotWorker;
import LSP.Solution.RectangleLSPs;
import LSP.Solution.ShapeLSP;
import LSP.Solution.SquareLSPs;
import LSP.Violation.RectangleLSPV;
import LSP.Violation.Square;
import OCP.Solution.CircleOCP;
import OCP.Solution.RectangleOCP;
import OCP.Solution.Shape;
import OCP.Violation.AreaCalculator;
import OCP.Violation.Circle;
import OCP.Violation.Rectangle;
import SRP.Solution.BookBusnessLogic;
import SRP.Solution.BookPrinter;
import SRP.Solution.BookSRP;
import SRP.Solution.BookSave;
import SRP.Violation.Book;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // appellation du book du SRP avec violation dans le main
        System.out.println(" SRP avec violation");


        Book book = new Book(" les principes solid", "Etudiants de M1-G1", "Revision des principes Solid");
        book.printToScreen();
        book.saveToDatabase();
        book.emprunter("Zita");

        //appellation du book du SRP sans violation dans le main
        System.out.println("SRP sans violation");

        BookSRP bookSRP = new BookSRP("les principes SOLID", "Etudiants de M1-G1", "Revision des principes Solid");
        BookSave bookSave = new BookSave();
        bookSave.saveToDatabase(bookSRP);
        bookSave.saveToFile(bookSRP,"Zita.txt");
        BookBusnessLogic bookBusnessLogic = new BookBusnessLogic();
        bookBusnessLogic.emprunter(bookSRP,"Tassolimo");
        bookBusnessLogic.autreService(bookSRP);
        BookPrinter bookPrinter = new BookPrinter();
        bookPrinter.printToScreen(bookSRP);
        bookPrinter.printToHTML(bookSRP);

        // Appelation du OCP dans le main
        System.out.println("OCP avec violation");
        Rectangle rectangle = new Rectangle(12,24);
        Circle circle = new Circle(2.4);
        AreaCalculator areaCalculator = new AreaCalculator();
        System.out.println("Aire Rectangle"+areaCalculator.calculateArea(rectangle));
        System.out.println("Aire Circle"+areaCalculator.calculateArea(circle));

        System.out.println("OCP sans violation");
        Shape rect = new RectangleOCP(12,47);
        Shape cir =new CircleOCP(4);
        System.out.println("aire du circle"+cir.calculateArea());
        System.out.println("Aire Rectangle"+rect.calculateArea());

        // Appelation du LSP dans le main
        System.out.println("LSP avec violation");
        RectangleLSPV rectangleLSPV = new RectangleLSPV();
        rectangleLSPV.setHeight(4);
        rectangleLSPV.setWidth(8);
        System.out.println("aire du rectangle"+rectangleLSPV.getArea());
       RectangleLSPV square = new Square();
       square.setWidth(7);
        System.out.println("aire du carre"+square.getArea());
       System.out.println("LSP sans violation");
        ShapeLSP squareLSP = new SquareLSPs(4);
        ShapeLSP rectangleLPSs = new RectangleLSPs(4,2);
        System.out.println("Airee du du rectangle"+rectangleLPSs.getArea());
        System.out.println("Aire du carre"+squareLSP.getArea());

        //Appelation du ISP dans le main
        System.out.println("ISP sans violation");
        HumanWorker humanWorker = new HumanWorker();
        humanWorker.eat();
        humanWorker.work();
        RobotWorker robotWorker = new RobotWorker();
        robotWorker.work();
       // cela genere une erreur car le robot ne mangee pas robotWorker.eat();
        System.out.println("ISP avec violation");
        HumanWorkerISP humanWorkerISP = new HumanWorkerISP();
        humanWorkerISP.eat();
        humanWorkerISP.work();
        RobotWorkerISP robotWorkerISP = new RobotWorkerISP();
        robotWorkerISP.work();

        // Appelation du DIP dans le main
        System.out.println("DIP sans violation");
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder("Donnees a sauvegarder");

        System.out.println("DIP avec violation");
        DataBase dataBase ;
        dataBase = new MySQLDatabase();
        OrderProcessor order = new  OrderProcessor();
        order.processOrder("Donnees a sauvegarder");
        dataBase=new MongoDBDatabase();
        OrderProcessor order2 = new OrderProcessor();
        order2.processOrder("Donnees a sauvegarder");














    }



}