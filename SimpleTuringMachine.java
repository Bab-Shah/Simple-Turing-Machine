import java.util.Scanner;
public class SimpleTuringMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("\u001B[34m" + "Created By Babak Shahba - KIT Studienkolleg\n" + "\u001B[0m");
        System.out.println("\u001B[35m" + "Simple Turing Machine - v1.0.0\n" + "\u001B[0m");
        byte choice;
        do {
            System.out.println("\u001B[37m" + "--------------------------------------------------------\n" + "\u001B[0m");
            System.out.println("\u001B[32m" + "Choose Your Option:\n" + "\u001B[0m");
            System.out.println("\u001B[33m" + "1. " + "\u001B[0m" + "Addition (+1)\n");
            System.out.println("\u001B[33m" + "2. " + "\u001B[0m" + "Subtraction (-1)\n");
            System.out.println("\u001B[33m" + "3. " + "\u001B[0m" + "Show source code\n");
            System.out.println("\u001B[33m" + "4. " + "\u001B[0m" + "Exit\n");
            System.out.print("Your choice:");
            choice = scanner.nextByte();
            System.out.println();
            if (choice == 4) {
                System.out.println("\u001B[31m" + "Exiting program...\n" + "\u001B[0m");
                break;
            } else if (choice == 3) {
                System.out.println("\u001B[37m" + "--------------------------------------------------------\n" + "\u001B[0m");
                System.out.println("\u001B[33m" + "Explore the source code on GitHub:\n" + "\u001B[0m");
                System.out.println("https://github.com/Bab-Shah/Simple-Turing-Machine/blob/main/SimpleTuringMachine.java\n");
            } else if (choice < 1 || choice > 4) {
                System.out.println("\u001B[31m" + "Invalid choice. Please try again.\n" + "\u001B[0m");
                continue;
            } else if (choice == 1 || choice == 2) {
                System.out.print("Enter the decimal number that you want to operate on: ");
                long number = scanner.nextLong();
                System.out.println();
                System.out.println("\u001B[37m" + "--------------------------------------------------------\n" + "\u001B[0m");
                if (choice == 1) {
                    System.out.println("\u001B[33m" + "Addition (+1)\n" + "\u001B[0m");
                } else if (choice == 2) {
                    System.out.println("\u001B[33m" + "Subtraction (-1)\n" + "\u001B[0m");
                }
                System.out.println("\u001B[36m" + "Decimal Input: " + "\u001B[0m" + number);
                String binaryNumber = Long.toBinaryString(number);
                System.out.println();
                System.out.println("\u001B[36m" + "Binary Representation: " + "\u001B[0m" + binaryNumber);
                String binaryInputString = "$" + binaryNumber + "#";
                System.out.println();
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
                                    } else if (readSymbol == '#') {
                                        state = "q_1";
                                        binaryInput[head] = '#';
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
                                    } else if (readSymbol == '#') {
                                        state = "q_1";
                                        binaryInput[head] = '#';
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
                                    } else if (readSymbol == '#') {
                                        state = "q_2";
                                        binaryInput[head] = '#';
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
                        binaryOutputAdd = binaryOutputAdd.replace("$", "").replace("#", "");
                        System.out.println("\u001B[37m" + "Final result on Turing machine tape: " + tapeResultAdd + "\u001B[0m");
                        System.out.println();
                        System.out.println("\u001B[36m" + "Binary Output: " + "\u001B[0m" + binaryOutputAdd);
                        System.out.println();
                        long decimalOutputAdd = Long.parseLong(binaryOutputAdd, 2);
                        System.out.println("\u001B[36m" + "Decimal Representation: " + "\u001B[0m" + decimalOutputAdd);
                        System.out.println();
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
                                    } else if (readSymbol == '#') {
                                        state = "q_1";
                                        binaryInput[head] = '#';
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
                                    } else if (readSymbol == '#') {
                                        state = "q_1";
                                        binaryInput[head] = '#';
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
                                    } else if (readSymbol == '#') {
                                        state = "q_2";
                                        binaryInput[head] = '#';
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
                        binaryOutputSubtract = binaryOutputSubtract.replace("$", "").replace("#", "");
                        System.out.println("\u001B[37m" + "Final result on Turing machine tape: " + tapeResultSubtract + "\u001B[0m");
                        System.out.println();
                        System.out.println("\u001B[36m" + "Binary Output: " + "\u001B[0m" + binaryOutputSubtract);
                        System.out.println();
                        long decimalOutputSubtract = Long.parseLong(binaryOutputSubtract, 2);
                        System.out.println("\u001B[36m" + "Decimal Representation: " + "\u001B[0m" + decimalOutputSubtract);
                        System.out.println();
                        break;
                }
            }
        } while (choice != 4);
        scanner.close();
    }
}
