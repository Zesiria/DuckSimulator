public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();
        AbstractDuckFactory countEchoDuckFactory = new CountingEchoDuckFactory();

//        simulator.simulate(countingDuckFactory);
        simulator.simulate(countEchoDuckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdaptor(new Goose());
        Quackable pigeon = new PigeonAdaptor(new Pigeon());

//        Quackable duckCallEcho = new QuackEcho(new DuckCall());
//
//        Quackable rubberDuckCE = new QuackCounter(new QuackEcho(new RubberDuck()));
//        Quackable rubberDuckEC = new QuackEcho(new QuackCounter(new RubberDuck()));

//        System.out.println("\nDuck Simulator: With Abstract Factory");

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);
        FlockWithLeader flockWithLeader = new FlockWithLeader();
        flockWithLeader.add(redheadDuck);
        flockWithLeader.add(duckCall);
        flockWithLeader.add(rubberDuck);
        flockWithLeader.add(gooseDuck);
        flockWithLeader.add(flockOfMallards);
        flockWithLeader.add(pigeon);

//        System.out.println("\nDuck Simulator: Whole Flock Simulation");
//        simulate(flockOfDucks);
//
//        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
//        simulate(flockOfMallards);

        System.out.println("\nDuck Simulator: FlockWithLeader Simulation");
        simulate(flockWithLeader);



//        simulate(mallardDuck);
//        simulate(redheadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate(gooseDuck);
//        simulate(pigeon);

//        simulate(duckCallEcho);
//        simulate(rubberDuckCE);
//        simulate(rubberDuckEC);

        System.out.println("The ducks quacked " +
                QuackCounter.getQuacks() + " times.");
    }

    void simulate (Quackable duck){
        duck.quack();
    }
}
