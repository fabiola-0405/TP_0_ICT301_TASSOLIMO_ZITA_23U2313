package DIP.Solution;

class MongoDBDatabase implements Database{

    @Override

    public void save(String data) {

        System.out.println("Saving to MongoDB: " + data);

    }
}
