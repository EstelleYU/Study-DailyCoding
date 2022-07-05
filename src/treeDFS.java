/* ------------------------------
26_treeDFS
Daily Coding from CodeStates
Fri 1st July 2022 (HBD to Me!)

Input the one of node object from one of the tree.
Do the DFS(Depth First Search) starts with that node.
Return the array of the nodes in order of DFS.
임의의 tree를 구성하는 노드 중 하나의 Node 객체를 입력받아,
해당 노드를 시작으로 깊이 우선 탐색(DFS, Depth First Search)을 합니다.
이 때, 탐색되는 순서대로 노드의 값이 저장된 배열을 리턴해야 합니다.
 ------------------------------ */

public class treeDFS {
    public static void main(String[] args) {

        System.out.println("Not done yet.");

    }
}

/* reference

package com.codestates.coplit;
import java.util.*;

public class Solution {
  public ArrayList<String> dfs(tree node) {
    ArrayList<String> values = new ArrayList<>();
    values.add(node.getValue());

    if(node.getChildrenNode() != null) {
      for(int i = 0; i < node.getChildrenNode().size(); i++) {
        ArrayList<String> curList = dfs(node.getChildrenNode().get(i));
        values.addAll(curList);
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
