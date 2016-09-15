public class cyclesInGraphs{
	public static void main(String[] args){
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		public static ArrayList<String> unvisited = new ArrayList<String>();
		public static ArrayList<String> visiting = new ArrayList<String>();
		public static ArrayList<String> visited = new ArrayList<String>();
		String[] vertices;

		try{
			File file = new File("digraph.dot");
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){Line
				String line = sc.nextLine();
               	Pattern exp = Pattern.compile("[\\p{Punct}\\d]");
                Matcher w = exp.matcher(line);
                vertices = w.replaceAll("").split(" ");
                
                if(unvisited.contains(vertices[0]))
                	unvisited.add(vertices[0]);
                else if(unvisited.contains(vertices[1])){
                	unvisited.add(vertices[1]);
                }

                if(!graph.containsKey(vertices[0])){
                	graph.put(vertices[0], new ArrayList<String>());
                	graph.put(vertices[0], graph.get(vertices[0]).add(vertices[1]);
                }
                else{
                	graph.put(vertices[0], graph.get(vertices[0]).add(vertices[1]);
                }


            	
            }

            if(isDirectedCyclic(graph))
            {
            	System.out.println("Graph is Cyclic");
            }
            else{
            	System.out.println("Graph is Acyclic")
            }

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	

	}	
	public boolean isDirectedCyclic(HashMap<String, ArrayList<String>> graph){

			  for(int i =0; i< graph.size();i++){
			  		moveToVisited(graph());

			  }
			  

			  if(graph.size()==1){
			  	return false;
			  }
			  else{
			  	return false;
			  }

			  
			 
	}



	public void moveToVisited(HashMap<String, ArrayList<String>> graph){
		 	for(Map.Entry<String, ArrayList<String>> entry: graph.entrySet()){
			  		if(entry.getValue().size()==0){
			  			int key = entry.getKey();
			  			graph.remove(key);
			  			for(Map.Entry<String, ArrayList<String>> entry2: graph.entrySet()){
			  				entry.getValue().remove(key);
			  			}
			  		}
			  }



	}
}