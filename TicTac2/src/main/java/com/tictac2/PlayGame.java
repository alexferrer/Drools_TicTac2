package com.tictac2;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class PlayGame {

	private static Cell cellarray[][] = new Cell[8][8];
	
    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
            KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( kSession, "./TicTac2", 1000 );
            
            //setup the test environment
            System.out.println(">running tictac test");
            setup(kSession );

            // go
            printArray("Init board");
            kSession.fireAllRules();
            
            //System.out.println(" ************* Ending tictac test *********");
            //printArray(" Final board ");

            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    
    //setup the env for the particular test
    // x wins on first row 
    private static void setup(KieSession kSession){

    	//String[] s = {"y"," "," "," ","y"," "," "," "," ",}; //standard game
    	String[] s = {" "," "," "," "," "," "," "," "," ",}; //standard game
    	//String[] s = {"x","x","x"," "," "," "," "," "," ",}; //row win
    	//String[] s = {"x"," "," ","x"," "," ","x"," "," ",}; //col win
    	//String[] s = {"x"," "," "," ","x"," "," "," ","x",}; //angle win
    	//String[] s = {"x","x"," "," ","x"," "," "," "," ",}; //posible wins row & col 1 % cross 1 to 9
    	
    	Cell cell1 = new Cell(0,0,s[0],2);  kSession.insert(cell1);cellarray[0][0]=cell1;
    	Cell cell2 = new Cell(0,1,s[1],1);  kSession.insert(cell2);cellarray[0][1]=cell2;
    	Cell cell3 = new Cell(0,2,s[2],2);  kSession.insert(cell3);cellarray[0][2]=cell3;
    	Cell cell4 = new Cell(1,0,s[3],1);  kSession.insert(cell4);cellarray[1][0]=cell4;
    	Cell cell5 = new Cell(1,1,s[4],3);  kSession.insert(cell5);cellarray[1][1]=cell5;
    	Cell cell6 = new Cell(1,2,s[5],1);  kSession.insert(cell6);cellarray[1][2]=cell6;
    	Cell cell7 = new Cell(2,0,s[6],2);  kSession.insert(cell7);cellarray[2][0]=cell7;
    	Cell cell8 = new Cell(2,1,s[7],1);  kSession.insert(cell8);cellarray[2][1]=cell8;
    	Cell cell9 = new Cell(2,2,s[8],2);  kSession.insert(cell9);cellarray[2][2]=cell9;
    	
    	//X starts game
    	Context context = new Context(" ");   kSession.insert(context);

    }
    
    public static void printArray(String text){
    	System.out.println("");
    	System.out.println("[ "+ text + " ]");
    	
        System.out.println(" "+cellarray[0][0].getPlayer()+" | "+  cellarray[0][1].getPlayer()+" | "+  cellarray[0][2].getPlayer() ); 
    
           		      //+ "       "+ cellarray[0][0].getValue()+" | "+  cellarray[0][1].getValue()+" | "+  cellarray[0][2].getValue()   );
        System.out.println("---|---|---  "); //   ---|---|---");
        
        System.out.println(" "+cellarray[1][0].getPlayer()+" | "+  cellarray[1][1].getPlayer()+" | "+  cellarray[1][2].getPlayer() );
		             //+"       "+cellarray[1][0].getValue()+" | "+  cellarray[1][1].getValue()+" | "+  cellarray[1][2].getValue()   );
        System.out.println("---|---|---  ");//   ---|---|---");
        
        System.out.println(" "+cellarray[2][0].getPlayer()+" | "+  cellarray[2][1].getPlayer()+" | "+  cellarray[2][2].getPlayer() );
                     //+ "       "+cellarray[2][0].getValue()+" | "+  cellarray[2][1].getValue()+" | "+  cellarray[2][2].getValue()   );

    }
}

