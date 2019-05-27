package nfa;

import java.util.Stack;

import ds.bag.Bag;
import graphs.DepthFirstSearchPath;
import graphs.DiGraph;
import graphs.DirectedDFS;

public class NFA {
	
	private String pattern;
	private char[] re;
	private int M;
	private DiGraph G;
	
	public NFA(String regex){
		this.pattern = regex;
		this.re = regex.toCharArray();
		this.M = re.length;
		G = buildStateMachine();
	}
	//(.*ABC.*)
	public DiGraph buildStateMachine(){
		DiGraph tempG = new DiGraph(M+1);
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<M;i++){
			int lp=i;
			if(re[i]=='(' || re[i]=='|'){
				stack.push(i);
			}else if(re[i]==')'){
				int or = stack.pop()	;
				if(re[or]=='|'){
					lp=stack.pop();
					tempG.addEdge(or, i);
					tempG.addEdge(lp, or+1);
				}else{
					lp=or;
				}
			}
			
			if(i<M-1 && re[i+1]=='*'){
				tempG.addEdge(lp, i+1);
				tempG.addEdge(i+1, lp);
			}
			
			if(re[i]==')' || re[i]=='(' || re[i]=='*'){
				tempG.addEdge(i, i+1);
			}
		}
		
		return tempG;
	}
	
	
	public boolean recognizes(String text){
		Bag<Integer> pc = new Bag<>();
		//States reachable via epsilon transitions from 0
		DirectedDFS dfs = new DirectedDFS(G, 0);
		for(int v=0;v<G.V();v++){
			if(dfs.marked(v)) pc.add(v);
		}
		int matchedAt = -1;
		for(int i=0;i<text.length();i++){
			//states reachable after scanning ith character in text;
			Bag<Integer> match = new Bag<>();
			for(int v : pc){
				if(v==M) continue;
				if(re[v]==text.charAt(i) || re[i]=='.'){
					if(matchedAt==-1)
						matchedAt = v;
					match.add(v+1);
				}
			}
			//follow epsilon transition after ith character
			dfs = new DirectedDFS(G, match);
			for(int v=0;v<G.V();v++){
				if(dfs.marked(v)) pc.add(v);
			}
		}
		
		//accept if the end state is reached
		for(int v: pc){
			if(v==M) {
				System.out.println(matchedAt);
				return true;
			}
		}
		
		
		return false;
	}
	
	public static void main(String[] args) {
		String pat = "(.*ABC.*)";
		NFA nfa = new NFA(pat);
		System.out.println(nfa.recognizes("AAABCAA"));
	}

}
