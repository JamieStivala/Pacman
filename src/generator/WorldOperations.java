package generator;

class WorldOperations {
    static void drawMiddleBox(Seed seed){
        boolean currentSeed[] = seed.getSeed(1);

        for (boolean x:
             currentSeed) {
            System.out.print(x + " ");
        }
    }
}
