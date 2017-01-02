package ofedorova;

/**
 *Class for sorting array by buble method
 *@author Olga Fedorova
 *@since 18.07.2016
 *@version 1
 */
 public class ArrayBubleSort{
	 /**
	  *The array for sorting
	  */
	 private int[] values;
	 
	 public ArrayBubleSort(int[] values){
		 this.values = values;
	 }
	 
	 public int[] getValues(){
		 return this.values;
	 }
	 
	 public void setValues(int[] values){
		 this.values = values;
	 }
	 
	 /**
	  *Sort array by buble method
	  */
	 public void sort(){
		 for(int indexOut = 0; indexOut < this.values.length; indexOut++){
			 for(int indexIn = this.values.length - 1; indexIn > indexOut; indexIn--){
				 if (this.values[indexIn-1] > this.values[indexIn]){
					 swap(indexIn-1, indexIn);
				 }
			 }
		 }		 
	 }
	 
	 /**
	  *Swap elements of variable values 
	  *@param indexFirst - index of first element, indexSecond - index of second element
	  */
	  private void swap(int indexFirst, int indexSecond){
		  int temp = this.values[indexFirst];
		  this.values[indexFirst] = this.values[indexSecond];
		  this.values[indexSecond] = temp;
	  }
	  
 }