/* Author: Hunter Pion
 * Date: 6/25/2023
 * 
 * CardListNode class for use in CardFlipping project.
 * 
 */

 // linked list nodes for CardFlipping project
 // contain int values for suit and face value, as well as a reference to the next node in the list
 // also contains utility classes to get the card as a string

import java.lang.Math;

 public class CardListNode
 {
   
   private int suit;                   // suit value of the card, 1 for diamonds, 2 for hearts, 3 for spades, 4 for clubs
   private int value;                  // face value of card from 1 to 12, negative values indicate card is facedown, ace is 1, jack is 10, queen is 11, king is 12
   private CardListNode next;          // next card in the list
    
   // default constructor
   public CardListNode(){}

   // constructor with string
   // used for creation of cards
   public CardListNode(String card)
   {
      //set value of card based on face value and orientation
      switch(card.charAt(2))
      {
         case 'A':
            this.value = 1;
            break;
         case 'J':
            this.value = 10;
            break;
         case 'Q':
            this.value = 11;
            break;
         case 'K':
            this.value = 12;
         default:
            this.value = card.charAt(2) - 48;
            break;
      }

      // if card is face down make value negative
      if (card.charAt(0) == 'D')
      {
         this.value *= -1;
      }

      //set suit
      switch(card.charAt(1))
      {
         case 'D':
            this.suit = 1;
            break;
         case 'H':
            this.suit = 2;
            break;
         case 'S':
            this.suit = 3;
            break;
         case 'C':
            this.suit = 4;
            break;
         default:
            break;
      }
   }

   // set next node
   public void setNext(CardListNode next)
   {
      this.next = next;
   }

   // get next node
   public CardListNode getNext()
   {
      return this.next;
   }

   // getCard
   // returns the card as a string
   public String getCard()
   {
      String card = "";

      //set orientation of card
      if (this.value > 0)
      {
         card = card + 'U';
      }
      else
      {
         card = card + 'D';
      }

      //set suit of card
      switch(this.suit)
      {
         case 1:
            card = card + 'D';
            break;
         case 2:
            card = card + 'H';
            break;
         case 3:
            card = card + 'S';
            break;
         case 4:
            card = card + 'C';
            break;
         default:
            break;
      }

      //set face value of card
      switch(Math.abs(this.value))
      {
         case 1:
            card = card + 'A';
            break;
         case 10:
            card = card + 'J';
            break;
         case 11:
            card = card + 'Q';
            break;
         case 12:
            card = card + 'K';
         default:
            card = card + Math.abs(this.value);
      }

      return card;

   }

   // flip card
   public void flip()
   {
      this.value = this.value * -1;
   }
 }
