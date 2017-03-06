/**
 * Created by rajporu on 3/4/17.
 */
public class TestBST {
    public static void main(String[] args) {
        String test = "S E A R C H E X A M P L E";
        String[] keys = test.split(" ");
        int n = keys.length;
        BST<String, Integer> st = new BST<String, Integer>();
        for (int i=0; i<n; i++)
            st.put(keys[i], i);
        System.out.println("size = " + st.size());
        System.out.println("max = " + st.max());
        System.out.println("min = " + st.min());
        System.out.println();
        System.out.println("PreOrder:");
        st.preorder();
        System.out.println();
        System.out.println("InOrder:");
        st.inorder();
        System.out.println();
        System.out.println("PostOrder:");
        st.postorder();
        System.out.println();
        System.out.println("LevelOrder");
        st.levelorder();
    }
}
