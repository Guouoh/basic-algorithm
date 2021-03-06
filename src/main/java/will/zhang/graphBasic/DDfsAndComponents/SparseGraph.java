package will.zhang.graphBasic.DDfsAndComponents;

import java.util.Vector;

/**
 * Created by Will.Zhang on 2018/1/26 0026 18:26.
 * 稀疏图 - 邻接表
 */
public class SparseGraph implements Graph {

    /**
     * 节点数
     */
    private int n;

    /**
     * 边数
     */
    private int m;

    /**
     * 是否为有向图
     */
    private boolean directed;

    /**
     * 图的具体数据
     */
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        //g初始化为n个空的vector, 表示每一个g[i]都为空
        g = new Vector[n];
        for (int i = 0; i < g.length; i++) {
            g[i] = new Vector<>();
        }
    }

    /**
     * 返回节点个数
     * @return
     */
    public int V(){
        return this.n;
    }

    /**
     * 返回边的个数
     * @return
     */
    public int E(){
        return this.m;
    }

    /**
     * 向图中添加一个边
     * @param v
     * @param w
     */
    public void addEdge(int v, int w){
        assert v > 0 && v < n;
        assert v > 0 && v < n;

        g[v].add(w);

        //这里不判断addEdge的算法复杂度是O(1), 但是hasEdge的算法复杂度是O(n)
        //如果添加了hasEdge的话, addEdge也会变成O(n)
        //v!=w是判断是否自环边,如果相等,那么运行上面g[v].add(w);就足够了
        //并且是否为有向图
        if(v != w && !directed){
            g[w].add(v);
        }
        //图的边数
        m++;
    }

    /**
     * 验证图中是否有从v到w的边
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w){
        assert v > 0 && v < n;
        assert v > 0 && v < n;

        for (int i = 0; i < g[v].size(); i++) {
            if(g[v].elementAt(i) == w){
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ )
                System.out.print(g[i].elementAt(j) + "\t");
            System.out.println();
        }
    }

    /**
     * 返回图中一个顶点的所有邻边
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v){
        assert v >= 0 && v < n;
        return g[v];
    }
}
