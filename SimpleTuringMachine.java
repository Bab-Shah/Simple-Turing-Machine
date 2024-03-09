import java.util.Scanner;
public class SimpleTuringMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[36m" + "Created By Babak Shahba - KIT Studienkolleg" + "\u001B[0m");
        System.out.println("\u001B[33m" + "Simple Turing Machine - v1.0.0" + "\u001B[0m");
        byte choice;
        do {
            System.out.println("\u001B[37m" + "-------------------------------------------" + "\u001B[0m");
            System.out.println("\u001B[32m" + "Choose Your Option:" + "\u001B[0m");
            System.out.println("\u001B[35m" + "1. " + "\u001B[0m" + "Addition (+1)");
            System.out.println("\u001B[35m" + "2. " + "\u001B[0m" + "Subtraction (-1)");
            System.out.println("\u001B[35m" + "3. " + "\u001B[0m" + "Show source code");
            System.out.println("\u001B[35m" + "4. " + "\u001B[0m" + "Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextByte();
            if (choice == 4) {
                System.out.println("Exiting program...");
                break;
            } else if (choice == 3) {
                System.out.println("\u001B[37m" + "-------------------------------------------" + "\u001B[0m");
                System.out.println("\u001B[35m" + "Explore the source code on GitHub:" + "\u001B[0m");
                System.out.println("https://github.com/Bab-Shah/Simple-Turing-Machine/blob/main/SimpleTuringMachine.java");
            } else if (choice < 1 || choice > 4) {
                System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
                continue;
            } else if (choice == 1 || choice == 4) {
                System.out.print("Enter the decimal number that you want to operate on: ");
                long number = scanner.nextLong();
                System.out.println("\u001B[37m" + "-------------------------------------------" + "\u001B[0m");
                if (choice == 1) {
                    System.out.println("\u001B[35m" + "Addition (+1)" + "\u001B[0m");
                } else if (choice == 2) {
                    System.out.println("\u001B[35m" + "Subtraction (-1)" + "\u001B[0m");
                }
                System.out.println("\u001B[34m" + "Decimal Input: " + "\u001B[0m" + number);
                String binaryNumber = Long.toBinaryString(number);
                System.out.println("\u001B[34m" + "Binary Representation: " + "\u001B[0m" + binaryNumber);
                String binaryInputString = "$" + binaryNumber + "€";
                char[] binaryInput = binaryInputString.toCharArray();
                String state = "q_0";
                int head = 0;
                switch (choice) {
                    case 1:
                        while (!state.equals("q_3")) {
                            char readSymbol = binaryInput[head];
                            switch (state) {
                                case "q_0":
                                    if (readSymbol == '0') {
                                        state = "q_0";
                                        binaryInput[head] = '0';
                                        ++head;
                                    } else if (readSymbol == '1') {
                                        state = "q_0";
                                        binaryInput[head] = '1';
                                        ++head;
                                    } else if (readSymbol == '€') {
                                        state = "q_1";
                                        binaryInput[head] = '€';
                                        --head;
                                    } else if (readSymbol == '$') {
                                        state = "q_0";
                                        binaryInput[head] = '$';
                                        ++head;
                                    }
                                    System.out.println("\u001B[37m" + head + " - " + "q_0: " + new String(binaryInput) + "\u001B[0m");
                                    break;
                                case "q_1":
                                    if (readSymbol == '0') {
                                        state = "q_2";
                                        binaryInput[head] = '1';
                                        --head;
                                    } else if (readSymbol == '1') {
                                        state = "q_1";
                                        binaryInput[head] = '0';
                                        --head;
                                    } else if (readSymbol == '€') {
                                        state = "q_1";
                                        binaryInput[head] = '€';
                                        --head;
                                    } else if (readSymbol == '$') {
                                        state = "q_3";
                                        binaryInput[head] = '1';
                                        ++head;
                                    }
                                    System.out.println("\u001B[37m" + head + " - " + "q_1: " + new String(binaryInput) + "\u001B[0m");
                                    break;
                                case "q_2":
                                    if (readSymbol == '0') {
                                        state = "q_2";
                                        binaryInput[head] = '0';
                                        --head;
                                    } else if (readSymbol == '1') {
                                        state = "q_2";
                                        binaryInput[head] = '1';
                                        --head;
                                    } else if (readSymbol == '€') {
                                        state = "q_2";
                                        binaryInput[head] = '€';
                                        --head;
                                    } else if (readSymbol == '$') {
                                        state = "q_3";
                                        binaryInput[head] = '$';
                                    }
                                    System.out.println("\u001B[37m" + head + " - " + "q_2: " + new String(binaryInput) + "\u001B[0m");
                                    break;
                            }
                        }
                        String binaryOutputAdd = new String(binaryInput);
                        String tapeResultAdd = binaryOutputAdd;
                        if (!tapeResultAdd.startsWith("$")) {
                            tapeResultAdd = "$" + tapeResultAdd;
                        }
                        binaryOutputAdd = binaryOutputAdd.replace("$", "").replace("€", "");
                        System.out.println("\u001B[37m" + "Final result on Turing machine tape: " + tapeResultAdd + "\u001B[0m");
                        System.out.println("\u001B[34m" + "Binary Output: " + "\u001B[0m" + binaryOutputAdd);
                        long decimalOutputAdd = Long.parseLong(binaryOutputAdd, 2);
                        System.out.println("\u001B[34m" + "Decimal Representation: " + "\u001B[0m" + decimalOutputAdd);
                        break;
                    case 2:
                        while (!state.equals("q_3")) {
                            char readSymbol = binaryInput[head];
                            switch (state) {
                                case "q_0":
                                    if (readSymbol == '0') {
                                        state = "q_0";
                                        binaryInput[head] = '0';
                                        ++head;
                                    } else if (readSymbol == '1') {
                                        state = "q_0";
                                        binaryInput[head] = '1';
                                        ++head;
                                    } else if (readSymbol == '€') {
                                        state = "q_1";
                                        binaryInput[head] = '€';
                                        --head;
                                    } else if (readSymbol == '$') {
                                        state = "q_0";
                                        binaryInput[head] = '$';
                                        ++head;
                                    }
                                    System.out.println("\u001B[37m" + head + " - " + "q_0: " + new String(binaryInput) + "\u001B[0m");
                                    break;
                                case "q_1":
                                    if (readSymbol == '0') {
                                        state = "q_1";
                                        binaryInput[head] = '1';
                                        --head;
                                    } else if (readSymbol == '1') {
                                        state = "q_2";
                                        binaryInput[head] = '0';
                                        --head;
                                    } else if (readSymbol == '€') {
                                        state = "q_1";
                                        binaryInput[head] = '€';
                                        --head;
                                    } else if (readSymbol == '$') {
                                        state = "q_3";
                                        binaryInput[head] = '-';
                                    }
                                    System.out.println("\u001B[37m" + head + " - " + "q_1: " + new String(binaryInput) + "\u001B[0m");
                                    break;
                                case "q_2":
                                    if (readSymbol == '0') {
                                        state = "q_2";
                                        binaryInput[head] = '0';
                                        --head;
                                    } else if (readSymbol == '1') {
                                        state = "q_2";
                                        binaryInput[head] = '1';
                                        --head;
                                    } else if (readSymbol == '€') {
                                        state = "q_2";
                                        binaryInput[head] = '€';
                                        --head;
                                    } else if (readSymbol == '$') {
                                        state = "q_3";
                                        binaryInput[head] = '$';
                                    }
                                    System.out.println("\u001B[37m" + head + " - " + "q_2: " + new String(binaryInput) + "\u001B[0m");
                                    break;
                            }
                        }
                        String binaryOutputSubtract = new String(binaryInput);
                        String tapeResultSubtract = binaryOutputSubtract;
                        if (!tapeResultSubtract.startsWith("$")) {
                            tapeResultSubtract = "$" + tapeResultSubtract;
                        }
                        binaryOutputSubtract = binaryOutputSubtract.replace("$", "").replace("€", "");
                        System.out.println("\u001B[37m" + "Final result on Turing machine tape: " + tapeResultSubtract + "\u001B[0m");
                        System.out.println("\u001B[34m" + "Binary Output: " + "\u001B[0m" + binaryOutputSubtract);
                        long decimalOutputSubtract = Long.parseLong(binaryOutputSubtract, 2);
                        System.out.println("\u001B[34m" + "Decimal Representation: " + "\u001B[0m" + decimalOutputSubtract);
                        break;
                }
            }
        } while (choice != 4);
        scanner.close();
    }
}

