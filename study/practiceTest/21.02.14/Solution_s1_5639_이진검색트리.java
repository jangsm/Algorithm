package ps.study.practiceTest.date210214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 15.
 * @author user
 * @see https://www.acmicpc.net/problem/5639
 * @mem52896
 * @time 428
 * @caution 기존에 Node클래스를 만들지 않고 진행하는 방식에서 틀린부분이 어디인지 확인 필요
 */

public class Solution_s1_5639_이진검색트리 {

	static int[] array = new int[10001];
	static int[][] nodes = new int[1000001][3];
	static StringBuilder output = new StringBuilder();;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		int index = 0;
		Node root = null;
		String numStr = "";
		while ((numStr = input.readLine()) != null && numStr.length() != 0) {
			int num = Integer.parseInt(numStr);
			if (index == 0) {
				root = new Node(num);
			} else {
				root.insertNode(new Node(num));
			}
			index++;
		}
		
//		while ((numStr = input.readLine()) != null && numStr.length() != 0) {
////			String numStr = input.readLine();
////			if (numStr.equals("")) {
////				break;
////			}
//
//			int num = Integer.parseInt(numStr);
//			if (index == 0) {
//				root = num;
//			}
//			array[index] = num;
//			nodes[num][0] = num;
//
//			if (index > 0 && array[index - 1] > array[index]) {
//				nodes[array[index - 1]][1] = array[index];
//			} else if (index != 0) {
//				int temp = index;
//				while (temp > 0 && array[temp - 1] < array[index]) {
//					temp--;
//				}
//				nodes[array[temp]][2] = array[index];
//			}
//
//			index++;
//		}

		postorder(root);
		System.out.println(output.toString());
	}

//	static void postorder(int root) {
//
//		if (nodes[root][1] != 0) {
//			postorder(nodes[root][1]);
//		}
//		if (nodes[root][2] != 0) {
//			postorder(nodes[root][2]);
//		}
//		output.append(nodes[root][0] + "\n");
//	}
	
	static void postorder(Node node) {
		
		if (node==null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		output.append(node.data + "\n");
	}

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public void insertNode(Node node) { // root 기준으로 사용
			Node curNode = this;
			while (true) {
				if (node.data < curNode.data) {
					if (curNode.left != null) {
						curNode = curNode.left;
					} else {
						curNode.left = node;
						break;
					}
				} else {
					if (curNode.right != null) {
						curNode = curNode.right;
					} else {
						curNode.right = node;
						break;
					}
				}
			}
		}

	}
}
