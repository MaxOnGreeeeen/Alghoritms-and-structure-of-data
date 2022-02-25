package tpu.company;

public class InsuranceCompany {
    private String nameOfCompany;
    private int numberOfEmployees;
    private int size;

    public int getSize() {
        return size;
    }

    InsuranceCompany (String nameOfCompany, int numberOfEmployees){
        this.nameOfCompany = nameOfCompany;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
    public Stack<Staff> staff = new Stack<>(numberOfEmployees);

    public void addEmployee(Staff employee){
        staff.push(employee);
        size++;
    }
    public void removeEmployee(){
        staff.pop();
        size--;
    }

    public Stack<Staff> getStaff() {
        return staff;
    }

    public boolean findEmployee(String nameofEmployee){
        for( int i = 0; i < getSize(); i++){
            if (staff.get(i).getName().equals(nameofEmployee)){
                return true;
            }
        }
        return false;
    }
}
