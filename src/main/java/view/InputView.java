package view;

import java.util.Scanner;

import domain.Function;
import utils.Converter;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputFunction(){
        System.out.println("## 원하는 기능을 선택하세요,");
        return Converter.NumberConverterBy(scanner.nextLine());
    }
}
