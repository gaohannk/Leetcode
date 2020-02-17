package company.amazon.oa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryLCA {
    public static class Employee {
        int id;
        List<Employee> reports = new ArrayList<Employee>();

        public void setId(int val) {
            id = val;
        }

        public int getId() {
            return id;
        }

        public void addReport(Employee emp) {
            reports.add(emp);
        }

        public List<Employee> getReports() {
            return reports;
        }
    }

    public static void main(String[] args) {

    }


    public static Employee comManager(Employee ceo, Employee emp1, Employee emp2) {
        Stack<Employee> e1 = new Stack<Employee>();
        Stack<Employee> e2 = new Stack<Employee>();
        Employee root = ceo;
        dfs(root, emp1, e1);
        dfs(root, emp2, e2);
        if ((!e1.isEmpty() && e1.peek().getId() == emp1.getId()) && (!e2.isEmpty() && e2.peek().getId() == emp2.getId())) {
            int len1 = e1.size();
            int len2 = e2.size();
            if (len1 > len2) {
                moveUp(e1, len1 - len2);
            } else {
                moveUp(e2, len2 - len1);
            }
            while (e1.size() > 0 && e1.peek().getId() != e2.peek().getId()) {
                e1.pop();
                e2.pop();
            }
            if (e1.size() > 0) {
                return e1.peek();
            }

        }
        return null;

    }

    public static void moveUp(Stack<Employee> stack, int steps) {
        while (steps > 0 && !stack.isEmpty()) {
            stack.pop();
            steps--;
        }
    }

    public static boolean dfs(Employee ceo, Employee emp, Stack<Employee> stack) {
        stack.push(ceo);
        if (ceo.getId() == emp.getId()) {
            return true;
        }
        for (Employee em : ceo.getReports()) {
            boolean result = dfs(em, emp, stack);
            if (result == true) {
                return true;
            }

        }
        stack.pop();
        return false;
    }


    //************************************************************Tree**************************************
    public static Employee comManagerTree(Employee ceo, Employee emp1, Employee emp2) {
        if (ceo == null || ceo == emp1 || ceo == emp2) {
            return ceo;
        }
        boolean judgeemp1 = false;
        boolean judgeemp2 = false;
        for (Employee em : ceo.getReports()) {
            Employee result = comManagerTree(em, emp1, emp2);
            if (result == emp1) {
                judgeemp1 = true;
            } else if (result == emp2) {
                judgeemp2 = true;
            } else if (result != null) {
                return result;
            }
        }
        if (judgeemp1 == true && judgeemp2 == true) {
            return ceo;
        } else if (judgeemp1 == true) {
            return emp1;
        } else if (judgeemp2 == true) {
            return emp2;
        }
        return null;

    }
}
