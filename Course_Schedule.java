// Approach: solved using kahns algorithm --> BFS topological sorting
// Time : O(V + E) where V is numCourses and E is the number of prerequisite pairs.
// Space complexity is O(V + E).
// The indegree array uses O(V).
// The adjacency list stored in the HashMap uses O(E).
// The queue can hold up to O(V) nodes in the worst case.
// No extra recursive stack since this is BFS.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pr : prerequisites) {
            indegrees[pr[0]]++;
            map.putIfAbsent(pr[1], new ArrayList<>());
            map.get(pr[1]).add(pr[0]);   // fixed syntax
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        // only add nodes with indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            List<Integer> dependencies = map.get(curr);
            if (dependencies != null) {
                for (int dependent : dependencies) {
                    indegrees[dependent]--;
                    if (indegrees[dependent] == 0) {
                        q.add(dependent);
                    }
                }
            }
        }

        return count == numCourses;
    }
}