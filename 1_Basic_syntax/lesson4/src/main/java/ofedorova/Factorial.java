package ofedorova;

/**
 *Class for compute factorial
 *@author Olga Fedorova
 *@since 18.07.2016
 *@version 1
 */
 public class Factorial{
	 /**
	  *The number for factorial
	  */
	 private final int number;
	 
	 public Factorial(int number){
		 this.number = number;
	 }
	 
	 public int getNumber(){
		 return this.number;
	 }
	 
	 /**
	  *Compute factorial for number
	  *@return value of factorial
	  */
	 public int compute(){
		 int result = 1; 
		 for (int i = 2; i <= this.getNumber(); i++){
			result *= i;
		 }
		 return result;		 
	 }

 }