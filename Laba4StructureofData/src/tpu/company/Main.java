package tpu.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        InsuranceCompany insuranceCompany;
        try{
            insuranceCompany = new InsuranceCompany(
                    " Российская компания ", in.nextInt());
        }catch (InputMismatchException ex){
            throw ex;
        }
	    int counter = 1;

	    //set the values of staff
	    for (int i = 0; i < insuranceCompany.getNumberOfEmployees(); i++){
	        System.out.println("Введите зарплату сотрудника, его имя,  число застрахованных клиентов:");
            System.out.println("Сотрудник #"+counter);
            int salary = in.nextInt();
            InputReader inputReader = new InputReader();
            String name = inputReader.inString();
            int clients = inputReader.inInt();



            //set the values of employee
	        Staff employee = new Staff(salary, name, clients);
	        insuranceCompany.addEmployee(employee);

	        //set the clients of employee2
            int counter1 = 0;
            for ( int j = 0; j < employee.getClients(); j++){
                System.out.println("Введите сумму страхования " +
                        "и имя клиента");
                System.out.println("Клиент №" + counter1);
                Client client = new Client(in.nextInt(), in.nextLine());
                employee.addClient(client);
                counter1 ++;
            }
            System.out.println();
            counter++;
        }
	    System.out.println();
	    solve(insuranceCompany);

    }

    //obviously
    public static void showDescription(){
        System.out.println("Для продолжения вам необходимо ввести операцию," +
                "которую вы хотите проделать.\n Ниже представлен перечень возможных действий:\n" +
                "#1.Уволить работника (не надо)\n"+
                "#2.Найти работника по имени\n"+
                "#3.Удалить застрахованного клиента\n"+
                "#4.Найти застрахованного клиента по имени\n"+
                "Ваш ответ!:");
    }

    //method for observing the changes in structure of company
    public static void showTheHierarchy(InsuranceCompany insuranceCompany) {
        System.out.println("Название страховой компании" + insuranceCompany.getNameOfCompany());
        System.out.println("___________________________");
        System.out.println("Сотрудники компании:");

        for(int i = 0 ; i < insuranceCompany.getSize(); i++){
            System.out.println("Сотрудник#" + (i+1) + ": "+insuranceCompany.staff.get(i).getName()+ "," +
                    " заработная плата: " + insuranceCompany.staff.get(i).getSalary() +
                    " , число клиентов:" + insuranceCompany.staff.get(i).getClients());
            System.out.println();
            for ( int j = 0; j < insuranceCompany.staff.get(i).getSize() + 1; j++){
                System.out.println( "     Клиент #" + (j+1) + ": " + insuranceCompany.staff.get(i).listofClients.get(j).getNameOfClient()+
                        ", сумма страхования: " + insuranceCompany.staff.get(i).listofClients.get(j).getSummofInsurance());
            }
        }
    }
    public static int solve(InsuranceCompany insuranceCompany) throws IOException {
        InputReader inputReader = new InputReader();
        while (true){
            showTheHierarchy(insuranceCompany);
            showDescription();
            switch (inputReader.inInt()){
                case 1:
                    insuranceCompany.removeEmployee();
                    break;
                case 2:
                    String nameofEmployee = inputReader.inString();
                    if(insuranceCompany.findEmployee(nameofEmployee)) System.out.println("Работник "
                            + nameofEmployee + " найден ");
                    showTheHierarchy(insuranceCompany);
                    break;
                case 3:
                    insuranceCompany.staff.get(0).removeClient(0);
                    break;
                case 4:
                    System.out.println("Введите имя клиента : ");

                    String nameofClient = inputReader.inString();
                    System.out.println("\t и его сумму страхования ");

                    int sumOfInsurance = inputReader.inInt();

                    Client clent = new Client(sumOfInsurance, nameofClient);
                    int found = 0;
                    for (int i = 0; i < insuranceCompany.getSize(); i++){
                        found = insuranceCompany.staff.get(i).findClient(clent);
                    }
                    if (found == -1  ) System.out.println("Клиент  найден");
                    else System.out.println("Клиент не найден");;
                    break;
                case -1:
                    System.out.println("Выход из метода...");
                    return 0;
                default:
                    break;
            }
        }
    }
}
