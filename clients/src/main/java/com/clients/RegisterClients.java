package clients;

import java.util.Scanner;

public class RegisterClients extends Clients {

    public RegisterClients(String name, String lastName, String cpf, String email, Plan plan) {
        super(name, lastName, cpf, email, plan);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = "";
        boolean validName = false;
        do {
            System.out.print("Nome: ");
            name = sc.nextLine();
            try {
                if (!name.matches("^[a-zA-Z\\s]+")) {
                    throw new Exception("O nome deve conter apenas letras e espaços.");
                }
                validName = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Informe um nome válido");
            }
        } while (!validName);

        String lastName = "";
        boolean validLastName = false;
        do {
            System.out.print("Ultimo nome: ");
            lastName = sc.nextLine();
            try {
                if (!lastName.matches("^[a-zA-Z\\s]+")) {
                    throw new Exception("O nome deve conter apenas letras e espaços.");
                }
                validLastName = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Informe um nome válido");
            }
        } while (!validLastName);

        String cpf = "";
        boolean validCpf = false;
        do {
            System.out.print("CPF: ");
            cpf = sc.nextLine();
            try {
                // Remove pontos e traços
                cpf = cpf.replaceAll("\\D", "");
                if (!cpf.matches("^\\d{11}$")) {
                    throw new Exception("O CPF deve conter exatamente 11 dígitos.");
                }
                // Verifica se o CPF é válido
                // Aqui você pode adicionar o seu algoritmo de validação de CPF
                validCpf = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Informe um cpf válido");
            }
        } while (!validCpf);

        String email = "";
        boolean validEmail = false;
        do {
            System.out.print("E-mail: ");
            email = sc.nextLine();
            try {
                if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    throw new Exception("O e-mail informado é inválido.");
                }
                validEmail = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Informe um email válido");
            }
        } while (!validEmail);

        String planStr;
        Plan plan;
        do {
            System.out.println("Qual é o seu plano? (basic, medium, premium): ");
            planStr = sc.nextLine();

            switch (planStr.toLowerCase()) {
                case "basic":
                    plan = Plan.BASIC;
                    break;
                case "medium":
                    plan = Plan.MEDIUM;
                    break;
                case "premium":
                    plan = Plan.PREMIUM;
                    break;
                default:
                    System.out.println("Plano inválido: " + planStr);
                    plan = null;
            }
        } while (plan == null);

        Clients client = new Clients(name, lastName, cpf, email, plan);
        client.exibirDados();

        System.out.println(
                "\nDigite 1 para alterar o nome \nDigite 2 para mudar o email \nDigite 3 para mudar o plano");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o novo nome: ");
                String newName = "";
                boolean validNewName = false;
                do {
                    System.out.print("Nome: ");
                    newName = sc.nextLine();
                    try {
                        if (!newName.matches("^[a-zA-Z\\s]+")) {
                            throw new Exception("O nome deve conter apenas letras e espaços.");
                        }
                        validNewName = true;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Informe um nome válido");
                    }
                } while (!validNewName);
                client.changeName(newName);
                System.out.println("\nDados atualizados:");
                client.exibirDados();
                break;
            case 2:
                System.out.print("Digite o novo e-mail: ");
                String newEmail = "";
                boolean validNewEmail = false;
                do {
                    System.out.print("E-mail: ");
                    email = sc.nextLine();
                    try {
                        if (!newEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                            throw new Exception("O e-mail informado é inválido.");
                        }
                        validNewEmail = true;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Informe um email válido");
                    }
                } while (!validNewEmail);
                client.changeEmail(newEmail);
                System.out.println("\nDados atualizados:");
                client.exibirDados();
                break;
            case 3:
                Plan newPlan;
                do {
                    System.out.print("Qual é o seu novo plano: ");
                    String newPlanStr = sc.nextLine();
                    switch (newPlanStr.toLowerCase()) {
                        case "basic":
                            newPlan = Plan.BASIC;
                            break;
                        case "medium":
                            newPlan = Plan.MEDIUM;
                            break;
                        case "premium":
                            newPlan = Plan.PREMIUM;
                            break;
                        default:
                            System.out.println("Plano inválido: " + newPlanStr);
                            newPlan = null;
                    }
                } while (newPlan == null);
                client.changePlan(newPlan);
                break;

        }
        client.exibirDados();
        sc.close();
    }
}