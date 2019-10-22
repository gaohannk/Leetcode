package leetcode.algo.e;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    Map<Integer, Employee> emap;

    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e : employees)
            emap.put(e.id, e);
        return dfs(queryid);
    }

    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid : employee.subordinates)
            ans += dfs(subid);
        return ans;
    }
}
