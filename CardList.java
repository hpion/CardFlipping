/*
 * Author: Hunter Pion
 * Date: 6/25/2023
 * 
 * CardList class for CardFlipping project
 * 
 */

// contains a head CardListNode which points to the top card in the list, a tail pointing to the last card in the list,
// an int length, which records the number of cards in the list
// and utility classes to flip lists, add cards to lists, and print lists
public class CardList
{
    private CardListNode head;
    private CardListNode tail;

    // default constructor
    public CardList()
    {
        head = new CardListNode();
        tail = new CardListNode();
        head.setNext(tail);
    }

    //add new card from string
    public void addCard(String newCard)
    {
        CardListNode newNode = new CardListNode(newCard);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
    }

    // flip list onto another list
    public void flip(CardList newList)
    {
        CardListNode current = head;
        // flip each card in cardList onto newList
        while (current.getNext() != tail)
        {
            //flip card and add it to newList, then set current to the next card
            current = current.getNext();
            current.flip();
            newList.addCard(current.getCard());
        }
    }

    // print list as a string of cards
    public String toString()
    {
        CardListNode current = head.getNext();
        String output = current.getCard();
        // get each card as a string septerated by spaces
        while(current.getNext() != tail)
        {
            output = output + " " + current.getCard();
            current = current.getNext();
        }
        return output;
    }
}
