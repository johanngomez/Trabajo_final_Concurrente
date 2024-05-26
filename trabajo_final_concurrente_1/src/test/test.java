package test;


import modelo.*;

public class test {
	
	public static double inicio;
	public static double fin;
	public static int array[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Quicksort ordenamientoSecuencial = new Quicksort();
		
		
		//Numeros para ordenar aleatorios
		array = ordenamientoSecuencial.generarArrayAleatorio(1000, -1000, 1000);
		
		
        //Llamada Metodo de Ordenamiento QuickSort
        inicio = System.nanoTime();
        
        ordenamientoSecuencial.Quicksort(array, 0, array.length -1);
        fin = System.nanoTime()- inicio;
        
        //Metodo para imprimir Vector Ordenado y mostramos el tiempo
        System.out.print("\n Ordenamos por el metodo QuickSort Secuencial: \n\n");
        ordenamientoSecuencial.ImprimirVector(array);
        System.out.print("\n\n Tardamos en ordenar -------> " + fin/1000 + " Microsengundos en el secuencial \n");
        
        
        
        /// ******** ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ ********// 
        //empezamos concurrente
        array = ordenamientoSecuencial.generarArrayAleatorio(1000, -1000, 1000);
        ConcurrentQuickSort ordenamientoConcurrete = new ConcurrentQuickSort(array, 0, array.length -1);
        inicio = System.nanoTime();
        ordenamientoConcurrete.quickSort(array);
        fin = System.nanoTime()- inicio;
        
        System.out.print("\n Ordenamos por el metodo QuickSort Concurrente: \n\n");
        ordenamientoSecuencial.ImprimirVector(array);
        System.out.print("\n\n Tardamos en ordenar -------> " + fin/1000 + " Microsengundos en el Concurrente \n");
        
        
        
	}

}
