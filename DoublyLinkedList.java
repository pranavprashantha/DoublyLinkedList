public class DoublyLinkedList {
  
  public DoublyNode head;
  public DoublyNode tail;
  public int size;

  public DoublyNode createDLL(int value) {
    head = new DoublyNode();
    DoublyNode newNode = new DoublyNode();
    newNode.value = value;
    newNode.next = null;
    newNode.previous = null;
    head = newNode;
    tail = newNode;
    size = 1;
    return head;
  }

  public void insertDLL(int value, int location) {
    DoublyNode newNode = new DoublyNode();
    newNode.value = value;
    if(head == null) {
      createDLL(value);
      return;
    } else if(location == 0) {
      newNode.previous = null;
      newNode.next = head;
      head.previous = newNode;
      head = newNode;
    } else if(location >= size) {
      newNode.previous = tail.next;
      newNode.next = null;
      tail.next = newNode;
      tail = newNode;
    } else {
      DoublyNode temp = head;
      for(int i = 0; i < location - 1; i++) {
        temp = temp.next;
      }
      newNode.previous = temp;
      newNode.next = temp.next;
      temp.next = newNode;
      newNode.next.previous = newNode;
    }
    size++;
  }
  public void traverseDLL() {
    if(head != null) {
      DoublyNode temp = head;
      for(int i = 0; i < size; i++) {
        System.out.print(temp.value);
        if(i != size - 1) {
          System.out.print(" -> ");
        }
        temp = temp.next;
      }
    } else {
      System.out.print("DLL does not exist");
    }
    System.out.println("");
  }
  public void reverseTravers() {
    if(tail != null) {
      DoublyNode temp = tail;
      for(int i = 0; i < size; i++) {
        System.out.print(temp.value);
        if(i != size - 1) {
          System.out.print(" -> ");
        }
      }
      temp = temp.previous;
    } else {
      System.out.print("DLL does not exist");
    }
    System.out.println("");
  }
  public boolean searchDLL(int value) {
    if (head != null) {
    DoublyNode temp = head;
    for(int i = 0; i < size; i++) {
      if(temp.value = value) {
        System.out.print("The node was found at " + i);
        return true;
      }    
      temp = temp.next;
      }
    }
    System.out.print("Node not found");
    return false;
  }
  public void deleteDLL(int location) {
    if(head == null) {
      System.out.println("DLL does not exist");
      return;
    } else if(location == 0) {
      if(size = 1) {
        head = null;
        tail = null;
        size--;
        return;
      } else {
        head = head.next;
        head.previous = null;
        size--;
      }
    } else if(location >= size) {
      DoublyNode temp = tail.previous;
      if(size = 1) {
        head = null;
        tail = null;
        size--;
      } else {
        temp.next = null;
        tail = temp;
        size--;
      }
    } else {
      DoubleNode temp = head;
      for(int i = 0; i < location - 1; i++) {
        temp = temp.next;
      }
      temp.next = temp.next.next;
      temp.next.previou = temp;
      size--;
    }
  }

  public void deleteAllDLL() {
    DoublyNode temp = head;
    for(int i = 0; i < size; i++) {
      temp.previous = null;
      temp = temp.next;
    }
    head = null;
    tail = null;
    System.out.println("The DLL has been deleted");
  }
}