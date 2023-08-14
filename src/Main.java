import java.util.Random;
import java.util.Scanner;

public class Main {

    private static boolean notWin = false;
    private static boolean gameProcess = true;
    private static int tries;

    public static void main(String[] args) {
//Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
// При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
// После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        System.out.println("Привет!");
        do {
            guessGame();
            playAgain();
        } while (gameProcess);
       /*  //Запросить у пользователя число и вывести его в консоль, подписав, что это число ввел нам пользователь.
       System.out.println("Привет!");
        System.out.println("Напиши любое число!");
        Scanner scanner = new Scanner(System.in);
        int generatedNumber = scanner.nextInt();
        System.out.println("Введённое число в квадрате: " + (generatedNumber * generatedNumber));*/
        /*//Сгенерировать число в заданных пределах и продемонстрировать его пользователю
        System.out.println("Привет!");
        System.out.println("Я сейчас придумаю число от 1 до 100");
        Random random = new Random();
        int generatedNumber = random.nextInt(100);
        System.out.println("Я сгенерировал: " + generatedNumber);*/
       /* //Сгенерировать число в заданных пользователем пределах
        System.out.println("Привет!");
        System.out.println("Я сейчас придумаю число");
        System.out.println("Напиши какое минимальное число мне загадать");
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        System.out.println("Напиши какое максимальное число мне загадать");
        int max = scanner.nextInt();
        Random random = new Random();
        int generatedNumber = random.nextInt(min, max);
        System.out.println("Я сгенерировал: " + generatedNumber);*/
    }

    private static void playAgain() {
        System.out.println("Хотите сыграть еще? Напишите да/нет пожалуйста");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next().toLowerCase();
        if(userAnswer.equals("да")){
            System.out.println("Отлично! Стартуем!");
        } else if(userAnswer.equals("нет")){
            System.out.println("До скорой встречи!!!");
            gameProcess = false;
        } else {
            playAgain();
        }
    }

    private static void guessGame() {
        int generatedNumber = getGeneratedNumber();
        notWin = true;
        tries = 3;
        System.out.println("У тебя есть всего три попытки, чтобы угадать число :)");
        while (notWin && tries > 0) {
            int userNumber = getNumberFromUser();
            analiseNumber(userNumber, generatedNumber);
        }
    }

    private static int getGeneratedNumber() {
        System.out.println("Я сейчас придумаю число от 1 до 10");
        Random random = new Random();
        int generatedNumber = random.nextInt(10);
        System.out.println("Я сгенерировал: " + generatedNumber);
        return generatedNumber;
    }

    private static int getNumberFromUser() {
        System.out.println("Введи число: ");
        tries--;
        Scanner scanner = new Scanner(System.in);
        int userNumber = scanner.nextInt();
        return userNumber;
    }

    private static void analiseNumber(int userNumber, int generatedNumber) {
        if (userNumber < generatedNumber) {
            System.out.println("Загаданное число больше");
        } else if (userNumber > generatedNumber) {
            System.out.println("Загаданное число меньше");
        } else {
            System.out.println("ПОБЕДА!");
            notWin = false;
        }
    }
}
