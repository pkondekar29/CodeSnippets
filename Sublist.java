
package CodeSnippets;
public class Sublist{

    static class Node {
        Node(int i){this.val = i;}
        int val;
        Node next;
    }

    public static void main(String[] args) {
        Node list = new Node(2);
        list.next = new Node(3);
        list.next.next = new Node(4);
        list.next.next.next = new Node(5);

        Node sList = new Node(3);
        sList.next = new Node(4);

        new Sublist().performSearch(list, sList);
    }

    public boolean performSearch(Node l, Node sl){
        Node h = l;
        Node sh = sl;
        boolean found = false;
        while(h != null && !found) {
            
            Node currHead = h;
            while(currHead != null && sl != null && currHead.val == sl.val){
                currHead = currHead.next;
                sl = sl.next;
            }
            if(sl == null) {
                // keep a prev -> compare with head prev. If same, return true
                // else reintialise sl
            }
            h = h.next;
            sl = sh;
        }
        return found;
    }

}