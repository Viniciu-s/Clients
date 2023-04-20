package clients;

public class Clients {
    private String name;
    private String lastName;
    private String cpf;
    private String email;
    private Plan plan;

    public Clients(String name, String lastName, String cpf, String email, Plan plan) {
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public void exibirDados(){
        System.out.println("\nDados do usuário: ");
        System.out.println("Nome: " + name);
        System.out.println("Ultimo nome: " + lastName);
        System.out.println("CPF: " + cpf);
        System.out.println("Email: " + email);
        System.out.println("Plano: " + plan);
    }

    public void changeName(String newName){
        this.name = newName;
    }

    public void changeEmail(String newEmail){
        this.email = newEmail;
    }

    public void changePlan(Plan newPlan){
        this.plan = newPlan;
    }
}