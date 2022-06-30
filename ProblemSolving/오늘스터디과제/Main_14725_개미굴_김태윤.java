package class6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//메모리 : 14216kb
//시간 : 268ms
public class Main_14725_개미굴_김태윤 {
	static int N;

	static class Trie{

		Node root;

		public Trie() {
			super();
			this.root = new Node();
		}
		
		public void insert(String[] s) {
			Node cur = this.root;
			for(int i = 0; i<s.length; i++) {
				if(!cur.children.containsKey(s[i])) {
					Node next = new Node();
					cur.children.put(s[i], next);
					next.depth = cur.depth + 1;
					cur = next;
				}else {
					Node next = cur.children.get(s[i]);
					cur = next;
				}
			}
			cur.isTerminal = true;
			return;
		}
		
		public void print() {
			root.print();
		}
		
		
		
	}
	static class Node{
		int depth;
		boolean isTerminal;
		
		Map<String, Node> children;

		public Node() {
			super();
			this.depth = 0;
			this.isTerminal = false;
			this.children = new HashMap<>();
		}
		
		public void print() {
			List<String> list = new ArrayList<String>(children.keySet());
			Collections.sort(list);
			for(String key : list) {
				for(int i =0; i<depth; i++) {
					System.out.print("--");
				}
				System.out.println(key);
				children.get(key).print();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		
		Trie trie = new Trie();
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int layer = Integer.parseInt(st.nextToken());
			
			String[] s = new String[layer];
			for(int j = 0; j<layer; j++) {
				s[j] = st.nextToken();
			}
			
			trie.insert(s);
		}
		
		trie.print();
	}

}
