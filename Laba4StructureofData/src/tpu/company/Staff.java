package tpu.company;

import tpu.company.com.LinkedList;

public class Staff {

    private String name;
    private int salary;
    private int clients;
    private int size = -1;
    public LinkedList<Client> listofClients= new LinkedList<>();

    public int getSize() {
        return size;
    }

    Staff(int salary, String name, int clients){
        this.salary = salary;
        this.name = name;
        this.clients = clients;
    }
    public void addClient(Client client){
        listofClients.addToEnd(client);
        size++;
    }

    public int findClient(Client client){
        return listofClients.indexOf(client);
    }
    public void removeClient(int position){
        listofClients.deleteByIndex(position);
        size--;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
    public int getClients() {
        return clients;
    }
}
