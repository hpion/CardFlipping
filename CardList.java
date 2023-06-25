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
    private int length;

    // default constructor
    public CardList()
    {
        head = new CardListNode();
        tail = new CardListNode();
        head.setNext(tail);
        length = 0;
    }

    // add new card
    public void addCard(CardListNode newCard)
    {
        //set newCard.next to the first card in the list then set head.next to newCard

        newCard.setNext(head.getNext());
        head.setNext(newCard);
        length += 1;
    }

    //add new card from string
    public void addCard(String newCard)
    {
        CardListNode newNode = new CardListNode(newCard);
        addCard(newNode);
    }

    // flip list onto another list
    public void flip(CardList newList)
    {
        CardListNode current = head.getNext();
        // flip each card in cardList onto newList
        for (int i = 0; i < this.length; i++)
        {
            //flip card and add it to newList, then set current to the next card
            current.flip();
            newList.addCard(current);
            current = current.getNext();
        }
    }
}
