public class Alumni extends Person{    
    String yearOfGrad;
    
    public Alumni(String yearOfGrad) {
        this.yearOfGrad = yearOfGrad;
    }

    public Alumni(){
        
    }


    @Override
    public String intro() {
        return "I graduated here";
    }


}
