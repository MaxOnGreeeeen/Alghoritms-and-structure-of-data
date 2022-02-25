package tpu.company;

public class Client{

    private String nameOfClient;
    private int summofInsurance;

    public int getSummofInsurance() {
        return summofInsurance;
    }
    Client(int summofInsurance, String nameOfClient){
        this.summofInsurance = summofInsurance;
        this.nameOfClient = nameOfClient;
    }
    public String getNameOfClient() {
        return nameOfClient;
    }

}
