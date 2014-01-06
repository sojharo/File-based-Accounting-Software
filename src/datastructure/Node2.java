/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructure;

/**
 *
 * @author MR
 */
public class Node2 {


    Node2 link=null;
   // String item;
    String transaction;

    Node2()
     {
         transaction = "";
         
     }

    Node2(String date, float values, String narration)
      {
        transaction =date+"//"+values+"//"+narration;
        
      }
}

