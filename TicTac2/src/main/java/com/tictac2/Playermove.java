package com.tictac2;

public class Playermove implements java.io.Serializable
{
   static final long serialVersionUID = 1L;
   
   private int row;
   private int col;

   public Playermove(int position)
   {
	  //convert position 1-9 to row-col [0,0] to [2,2]
	  row = (position - 1)/3  ;
	  col = (position -1) % 3 ;
   }

   
   public int getRow() {
	  return row;
   }

   public int getCol() {
	  return col;
   }   
   
}