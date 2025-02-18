package Ti2;
import java.util.*;

public class SomaDoisInteiros {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("Digite o primeiro numero: ");
		int x = scanner.nextInt();
		
		System.out.printf("\nDigite o segundo numero: ");
		int y = scanner.nextInt();
		
		int soma = x + y;
		
		System.out.println("\nResultado: " + soma);
		
		scanner.close();
	}
}
