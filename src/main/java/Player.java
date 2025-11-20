public class Player {
   
    public String name;
    public String role;

    public int dexterity;
    public int charisma;
    // Add rest of the stats.
    
    public int limbs = 4;

    public Player(String name, String role) {
        this.name = name;
        this.role = role; 
    }

    public void attack() {
        System.out.println(this.name + " the " + this.role + " ATTACKED! ");
    }

    public static int rollD20() {
        int r = (int) (Math.random() * 20) +1;
        return r;
    }

    public static int rollAdvantage() {
        int first = (int) (Math.random() * 20) + 1; 
        int second = (int) (Math.random() * 20) + 1;
        if(first > second) {
            return first;
        }
        return second;
    }
}
