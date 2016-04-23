package com.roop.hackerRank.algo.graphTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author rcnium
 *
 */
public class Graph {
	private int numVertices;
	private int numEdges;
	private int distance = 6;

	private Map<Integer, ArrayList<Integer>> adjListMap;
	private Map<Integer, Integer> distanceMap;
	private LinkedList<Integer> queue;
	private Set<Integer> visited;

	public Graph(int edges, int vertices) {
		this.numEdges = edges;
		this.numVertices = vertices;
		this.adjListMap = new HashMap<Integer, ArrayList<Integer>>();
		this.distanceMap = new HashMap<Integer, Integer>();
		this.queue = new LinkedList<Integer>();
		this.visited = new HashSet<Integer>();
	}

	public void addVertex(){
		int v = getNumVertices();
		ArrayList<Integer> neighbours = new ArrayList<Integer>();
		getAdjListMap().put(v+1, neighbours);
		numVertices++;
	}

	public void addEdge(int v, int w) {
		if(getAdjListMap().containsKey(v)){
			getAdjListMap().get(v).add(w);
		} else {
			ArrayList<Integer> a= new ArrayList<Integer>();
			a.add(w);
			getAdjListMap().put(v, a);
		}

		numEdges++;
	}

	public ArrayList<Integer> neighbours(int v) {
		return getAdjListMap().get(v);
	}

	public void breadthFirstSearch(int source) {
		visited.add(source);
		distanceMap.put(source, 0);
		bfs(source);
	}

	public void bfs(int source) {
		if(null != neighbours(source)) {
			for(Integer vertex : neighbours(source)) {
				if(!visited.contains(vertex)){
					queue.add(vertex);
					visited.add(vertex);
					distanceMap.put(vertex, distanceMap.get(source) + distance);
				}
			}
		}

		while(!queue.isEmpty()){
			int vertex = queue.poll();
			bfs(vertex);
		}

	}

	public Map<Integer, ArrayList<Integer>> getAdjListMap() {
		return adjListMap;
	}
	public void setAdjListMap(Map<Integer, ArrayList<Integer>> adjListMap) {
		this.adjListMap = adjListMap;
	}
	public int getNumVertices() {
		return numVertices;
	}
	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}
	public Map<Integer, Integer> getDistanceMap() {
		return distanceMap;
	}

	public void setDistanceMap(Map<Integer, Integer> distanceMap) {
		this.distanceMap = distanceMap;
	}

	public int getNumEdges() {
		return numEdges;
	}
	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}
}
