package modelo;

public class ConcurrentQuickSort implements Runnable {
	
	// Declaración de variables de instancia para el arreglo, los límites izquierdo y derecho del subarreglo
    private final int[] array;
    private final int left;
    private final int right;

 // Constructor que inicializa las variables de instancia
    public ConcurrentQuickSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    
 // Método run() que ejecuta la ordenación concurrente
    @Override
    public void run() {
    	// Verifica si hay elementos en el subarreglo
        if (left < right) {
        	// Obtiene el índice del pivote
            int pivotIndex = partition(array, left, right);
            
         // Crea dos sub-tareas para ordenar las subparticiones izquierda y derecha
            Thread leftThread = new Thread(new ConcurrentQuickSort(array, left, pivotIndex - 1));
            Thread rightThread = new Thread(new ConcurrentQuickSort(array, pivotIndex + 1, right));
            
         // Inicia las sub-tareas
            leftThread.start();
            rightThread.start();
            try {
            	// Espera a que las sub-tareas terminen
                leftThread.join();
                rightThread.join();
            } catch (InterruptedException e) {
            	// Manejo de excepciones si ocurre interrupción en los hilos
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }
    }

    
 // Método que realiza la partición del arreglo y devuelve el índice del pivote
    private int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[i] <= pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, left, j);
        return j;
    }

 // Método auxiliar para intercambiar dos elementos en el arreglo
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    
 // Método estático para iniciar el proceso de ordenación concurrente
    public static void quickSort(int[] array) {
    	// Crea una tarea principal para ordenar todo el arreglo
        ConcurrentQuickSort task = new ConcurrentQuickSort(array, 0, array.length - 1);
        
     // Crea un hilo principal para ejecutar la tarea
        Thread mainThread = new Thread(task);
        
     // Inicia el hilo principal
        mainThread.start();
        
        
        try {
        	// Espera a que la tarea principal termine
            mainThread.join();
        } catch (InterruptedException e) {
        	// Manejo de excepciones si ocurre interrupción en el hilo principal
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted: " + e.getMessage());
        }
    }
}
