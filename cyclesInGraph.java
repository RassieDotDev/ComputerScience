public class cyclesInGraphs{
	public static void main(String[] args){
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		String[] vertices;

		try{
			File file = new File("digraph.dot");
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){Line
				String line = sc.nextLine();
               	Pattern exp = Pattern.compile("[\\p{Punct}\\d]");
                Matcher w = exp.matcher(line);
                vertices = w.replaceAll("").split(" ");
                if(!graph.containsKey(vertices[0])){
                	graph.put(vertices[0], new ArrayList<String>());
                	graph.put(vertices[0], graph.get(vertices[0]).add(vertices[1]);
                }
                else{
                	graph.put(vertices[0], graph.get(vertices[0]).add(vertices[1]);
                }


            	
            }

		}
		catch(){}
	

	}	
	public boolean isDirectedCyclic(Graph<Integer> graph){
			  ArrayList<String> visited = new ArrayList<String>();
			  ArrayList<ArrayList<String>> visitList = new ArrayList<ArrayList<String>>();
			  Stack<String> stack = new Stack<String>();
			  visitList.add();
			  stack = push();
			  while(!stack.isEmpty()){
			  	stack.peek()
			  }
	}



	public boolean dfs(){}
}