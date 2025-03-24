abstract class Animal {
    public String name;
    
    public abstract void animalSound();
    
    public void sleeping(){
        System.out.println("Zzz Zzz Zzz");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

}
