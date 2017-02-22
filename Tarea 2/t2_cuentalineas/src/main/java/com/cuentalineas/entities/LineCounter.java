package com.cuentalineas.entities;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Ciro D�az
 * Programa contador de l�neas
 * Versi�n: 1.0
 * Creado: 18/02/2017
 * �ltima modificaci�n: 21/02/2017
 */


import java.util.LinkedList;



/* Clase principal del programa; contiene el m�todo main y un m�todo static para
   controlar la ejecuci�n del resto de las utilidades.
 */
public class LineCounter {
	
	public static void main(String args[]){
		
		//Se solicita el archivo desde donde se leer�n los valores, y se instancia la clase de utilidad, donde se calculan los requerimientos
		try{
		System.out.println("Bienvenido; el archivo que se indic� ser� cargado");
		
		String propertyFileName = args[0];
		String projectFolder = args[1];
		String fileType = args[2];
		//valores para prueba en IDE; los args se comentan
		//String propertyFileName = "C:\\Workspaceejemplos\\t2_cuentalineas\\docs\\standards.properties"; 
		//String projectFolder = "C:\\Workspaceejemplos\\t2_cuentalineas\\src";
		//String fileType = "java";
		int totalLines = 0;
		CodingStandard standard = new CodingStandard(propertyFileName);
		LinkedList<Expression> standardRules = standard.setStandards(propertyFileName);
		
		// Los valores se guardar�n en una lista, una vez se hayan le�do
		System.out.println("Los est�ndares que se van a tener en cuenta son:");
		
		for(int i=0;i<standardRules.size();i++)
		{
			System.out.println(standardRules.get(i).getRuleType());
			System.out.println(standardRules.get(i).getRule());
		}
		
		LinkedList<Part> resultingFiles= countPartLines(standardRules, projectFolder, fileType);
		int fileListSize = resultingFiles.size();
		System.out.println("el tama�o de la lista es " + fileListSize + " archivos");
		
		for(int i=0;i<resultingFiles.size();i++)
		{
			 totalLines +=   resultingFiles.get(i).getLineAmount();			 		 
		}
		
		System.out.println("El total de l�neas en el proyecto " + projectFolder +" es: " + totalLines);
		} catch (Exception e){
			System.out.println("no se ha encontrado el archivo, por favor verificar");
			
		}
		

		
	}
	
	
	/**
	 * M�todo que har� el conteo de l�neas para cada documento del proyecto, y el conteo de m�todos.
	 * @param standardRules
	 * @param projectFolder
	 * @param fileType
	 * @return
	 * @throws FileNotFoundException
	 */
	public static LinkedList<Part> countPartLines(LinkedList<Expression> standardRules, String projectFolder, String fileType) throws Exception
	{
		
		File file = new File(projectFolder);
		LinkedList<Part>  parts = new LinkedList<Part>();
		
		if(!file.exists())
			throw new FileNotFoundException("El directorio que se quiere evaluar no existe");
		else if(file.isDirectory())
		{
			File[] files = file.listFiles();
			
			for (File currentFile : files)
			{
			    if (currentFile.isFile()) {
			        if(currentFile.getName().endsWith(fileType))
			        {
			        	Part part = new Part();
			        	part.setPartName(currentFile.getName());
			        	System.out.println(part.getPartName());
			        	part.setLineAmount(currentFile,standardRules);
			        	System.out.println("La cantidad de l�neas para este archivo es:");
			        	System.out.println(part.getLineAmount());
			        	part.setMethodAmount(currentFile,standardRules);
			        	parts.add(part);	
			        	
			        }
			        
			    }
			    else 
			    	parts = countPartLines(standardRules, currentFile.getPath(), fileType);
			}

		}

		return parts;
	}


}
