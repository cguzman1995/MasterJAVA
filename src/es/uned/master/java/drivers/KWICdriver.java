package es.uned.master.java.drivers;

import es.uned.master.java.coleccion.KWIC;

public class KWICdriver {
    /**
     * @param args
     */
    public static void main(String[] args) {
    	
    	//Se establecen las palabras no significativas
        String palNoSig = "el,la,los,las,al,un,una,unos,unas,y,o,a,ante,bajo,cabe,de,desde,en,entre,hacia,hasta,para,por,sin,si,no";
        //Se establecen las frases a analizar
        String []frases = {
            "El color del dinero",
            "Color púrpura",
            "Misión imposible",
            "La misión",
            "La rosa púrpura del Cairo",
            "El dinero llama al dinero",
            "La rosa del azafrán",
            "El nombre de la rosa",
            "Toma el dinero y corre"
        };
        
        //Se crea un objeto KWIC
        KWIC glosario = new KWIC();
        //Se incorporan las palabras no significativas al objeto creado
        glosario.addNoClaves(palNoSig);

        //Se analizan las frases
        for (int i=0 ; i<frases.length ; i++){
            glosario.clasificaFrases(frases[i]);
        }

        //Se imprime el glosario generado
        System.out.println(glosario.toString());

    }
}
