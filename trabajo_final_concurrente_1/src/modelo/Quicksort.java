package modelo;

import java.util.Random;

//agrego thread para usar sleep
public class Quicksort extends Thread {
	

	// Método para realizar el algoritmo de QuickSort
	 public static void Quicksort(int numeros[], int izq, int der)
	    {
		 
		 try {
			// Se introduce un tiempo de espera artificial de 1 milisegundo (sleep) para simular compararlo con el concurrente.
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	            //Este metodo recibe un arreglo de numero, y dos enteros que referencian el primer valor
	            //Y el ultimo
	        
	            //Se toma como pivote el primer valor
	            int pivote = numeros[izq];
	            
	            //Se definen los dos lados y un auxiliar
	            int i = izq; 
	            int j = der; 
	            int aux;
	           
	            while(i<j)
	            {
		// Encuentra el primer elemento mayor que el pivote desde la izquierda
	               while (numeros[i] <= pivote && i < j) 
	                  i++;
		// Encuentra el primer elemento menor o igual que el pivote desde la derecha
	               while (numeros[j] > pivote) 
	                  j--;   
		 // Si aún no se han cruzado los índices, intercambia los elementos
	               if (i<j) 
	               {                                     
	                   aux = numeros[i];                  
	                   numeros[i]= numeros[j];
	                   numeros[j]=aux;
	               }
	            }
		 // Coloca el pivote en su lugar definitivo
	             numeros[izq] = numeros[j]; 
	             numeros[j] = pivote;
		// Ordena recursivamente la sublista a la izquierda del pivote
	             if (izq < j-1)
	                Quicksort(numeros,izq,j-1);
		// Ordena recursivamente la sublista a la derecha del pivote
	             if (j+1 < der)
	                Quicksort(numeros,j+1,der);

	             
	      }
	    
	 
	// Método para imprimir el arreglo en consola
	    public static void ImprimirVector(int arreglo[])
	    
	    {
	    	 System.out.print("[");
	        for(int i = 0; i < arreglo.length; i++)
	        {
	            System.out.print(", " + arreglo[i]);
	        }
	        System.out.print("]");
	    }
	    
	 // Método para generar un arreglo de números aleatorios
	    public static int[] generarArrayAleatorio(int n, int min, int max) {
	        // Declaración del array
	        int[] arr = new int[n];
	        
	        // Generación de números aleatorios
	        Random random = new Random();
	        for (int i = 0; i < n; i++) {
	            arr[i] = random.nextInt(max - min + 1) + min;
	        }
	        
	        return arr;
	    }
	            
	}

