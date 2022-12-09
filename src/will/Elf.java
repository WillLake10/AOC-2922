package will;

public class Elf {
    private final int elfNum;
    private final int numCalories;

    public Elf(int elfNum, int numCalories) {
        this.elfNum = elfNum;
        this.numCalories = numCalories;
    }

    public int getNumCalories() {
        return numCalories;
    }

    @Override
    public String toString() {
        return "Elf{" +
                "elfNum=" + elfNum +
                ", numCalories=" + numCalories +
                '}';
    }
}
