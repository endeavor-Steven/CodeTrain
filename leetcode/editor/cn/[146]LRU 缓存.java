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
     *实现本体操作，需要hash+双向链表
     * 此题要手动实现双向链表
     *
     *
     */
    //实现双向链表
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value}
    }

    private int size;//链表是没办法记录当前的长度的，所以为了对比容量情况，人工留一个
    private int capacity;
    private DLinkedNode head, tail;
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();

    public LRUCache(int capacity) {
        //构造器基本逻辑包括：
        //1、定义容量；2、定义双向链表；

        //1、初始化参数
        this.size = 0;
        this.capacity = capacity;
        //2、使用伪头节点和伪尾节点，并连接关系
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        //1、成功查找；2、查找失败
        DLinkedNode tmp_node = cache.get(key);//前面初始化了一个map叫cache，先取出这个节点
        if (tmp_node == null) {
            return -1;
        }
        moveToHead(tmp_node); //把这个节点移动到双链表头部
        return tmp_node.value;//返回这个节点的值作为查询结果
    }

    public void put(int key, int value) {
        //1、节点不存在则新建节点；2、节点存在则刷新节点
        DLinkedNode tmp_node = cache.get(key);//前面初始化了一个map叫cache，先取出这个节点
        if (tmp_node == null) {
            //不存在节点，则要创建一个新节点并放入链表中
            DLinkedNode new_Node = new DLinkedNode(key, value);
            cache.put(key, new_Node);
            //新节点在创建时属于新操作，所以要移动到尾部，并增长链表长度
            addToHead(new_Node);
            ++size;   //长度在变化后要判断和容量之间的关系
            if (size > capacity) {
                //头部是最新的，那尾部就是很久没用的，删除尾部
                DLinkedNode tail_Node = removeTail(); //找到这个节点，然后再map中删掉
                cache.remove(tail_Node.key);
                --size;
            }
        } else {
            //节点存在
            tmp_node.value = value;
            moveToHead(tmp_node);
        }
    }

    private void addToHead(DLinkedNode node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    //移动的时候涉及到删除这里可以抽象
    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

    //除此之外要手动实现双向链表的基本功能
    //要记住。这个地方要选定一个方向作为最近使用过的痕迹
    //包括：
    // 1、在头部添加节点；
    // 2、在尾部添加节点；即每次有新节点进来则在尾部插入
    // 3、将节点移动到头部
}


//    class LRUCache extends LinkedHashMap<Integer, Integer>{
//        private int capacity;
//
//        public LRUCache(int capacity) {
//            super(capacity, 0.75F, true);
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            return super.getOrDefault(key, -1);
//        }
//
//        public void put(int key, int value) {
//            super.put(key, value);
//        }
//
//        @Override
//        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//            return size() > capacity;
//        }
//    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}