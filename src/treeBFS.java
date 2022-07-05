/* ------------------------------
27_treeBFS
Daily Coding from CodeStates
Monday, July 4th, 2022

Input a node object of the tree,
starting with that node, do the BFS (Breadth First Search).
Return the array containing the values of the nodes
in the order they are searched.

임의의 tree를 구성하는 노드 중 하나의 Node 객체를 입력받아,
해당 노드를 시작으로 너비 우선 탐색(BFS, Breadth First Search)을 합니다.
이 때, 탐색되는 순서대로 노드의 값이 저장된 배열을 리턴해야 합니다.
 ------------------------------ */

public class treeBFS {
    public static void main(String[] args) {

    System.out.println("Not done yet.");

    }
}


/* reference

package com.codestates.coplit;
import java.util.*;

public class Solution {
	public ArrayList<String> bfs(tree node) {
    Queue<tree> queue = new LinkedList<>();
    ArrayList<String> values = new ArrayList<>();
    queue.add(node);

    while(queue.size() > 0) {
      tree curNode = queue.poll();

      values.add(curNode.getValue());

      if(curNode.getChildrenNode() != null) {
        queue.addAll(curNode.getChildrenNode());
      }
    }
    return values;
	}

	//아래 클래스의 내용은 수정하지 말아야 합니다.
	public static class tree {
    private String value;
    private ArrayList<tree> children;

    public tree(String data) {
      this.value = data;
      this.children = null;
    }

    public tree addChildNode(tree node) {
      if(children == null) children = new ArrayList<>();
      children.add(node);
      return children.get(children.size() - 1);
    }

    public String getValue() {      //현재 노드의 데이터를 반환
      return value;
    }

    public ArrayList<tree> getChildrenNode() {
      return children;
    }
  }
}


 */