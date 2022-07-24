package leetcode.editor.cn;

//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 2230 👎 0

import java.util.HashMap;
import java.util.Map;

public class LruCache{
    public static void main(String[] args) {
        Solution solution = new LruCache().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    /**
     *     双链表中实现的方法：
     *          链表初始化
     *          添加元素到双链表尾部（同时意味着该元素最近使用过）
     *           删除某个结点（非头结点）
     *          删除并返回头结点（意味着移除最久未使用过的元素）
     *          返回链表当前长度
     *     LRU 缓存中的方法
     *          初始化，get，put方法
     *          设置某元素最近已使用makeRecently（原map中已有该元素）
     *          添加最近使用过的元素addRecently（原map中不存在该键值对，新元素）
     *          删除某个key对应的元素
     *          删除最久未使用过的元素 2.中的方法也可以直接在get和put方法中实现，可以减少部分冗余
     */
    class Node {
        int key, val;   //在删除节点的时候需要使用到Key在map中检索
        Node pre, next;
        Node (int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {
        Node head, tail;
        int size;

        public DoubleList (){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void addLast(Node x) { // 添加到链表尾部，且越靠近链表尾部，越代表最近使用过
            // 如当前链表为： head <-> 1 <-> tail，加入结点x = 2
            x.pre = tail.pre;
            tail.pre.next = x;
            x.next = tail;
            tail.pre = x;
            ++size;
        }
        public void remove(Node x) {// 删除指定结点（该结点一定存在与链表）
            x.pre.next = x.next;
            x.next.pre = x.pre;
            --size;
        }
        public Node removeHead() {
            if (head.next == tail) {//空表
                return null;
            } else {
                Node tmp = head.next;
                remove(tmp);
                return tmp;
            }
        }
        public int getSize() {
            return size;
        }
    }//DoubleList

    //封装一层函数，方面同时调用map和cache
//    public void makeRecently(int key) { // 将某个key标记为最近使用的元素（map中已存在的）
//        Node tmp = map.get(key);
//        cache.remove(tmp);
//        cache.addLast(tmp);
//    }
//
//    public void addRecently(int key, int value) { // 添加最近使用过的元素， 原map中不存在该key
//        Node tmp = new Node(key, value);
//        cache.addLast(tmp);
//        map.put(key, tmp);
//    }
//
//    public void deleteKey(int key) { // 删除某一个key对应的元素
//        Node tmp = map.get(key);
//        map.remove(key);
//        cache.remove(tmp);
//    }
//
//    public void removeLeastRecently() { // 删除最久未使用的元素
//        Node tmp = cache.removeHead();
//        int tmpKey = tmp.key;
//        map.remove(tmpKey);
//    }

    Map<Integer, Node> map;
    DoubleList cache;
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
//            makeRecently(key);
            Node tmp = map.get(key);
            cache.remove(tmp);
            cache.addLast(tmp);
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
//            deleteKey(key); // 从原map中移除该key
            Node tmp = map.get(key);
            map.remove(key);
            cache.remove(tmp);
//            addRecently(key, value); // 更新最近使用
            tmp = new Node(key, value);
            cache.addLast(tmp);
            map.put(key, tmp);
            return;
        }
        int size = cache.getSize();
        if(size == cap){ // 说明需要移除最久未使用的元素了
//            removeLeastRecently();
            Node tmp = cache.removeHead();
            int tmpKey = tmp.key;
            map.remove(tmpKey);
        }
        // 走到这说明添加的是一个新元素
//        addRecently(key, value);
        Node tmp = new Node(key, value);
        cache.addLast(tmp);
        map.put(key, tmp);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}