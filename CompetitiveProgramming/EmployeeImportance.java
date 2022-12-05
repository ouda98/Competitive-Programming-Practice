import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {
    public static void main(String[] args) {

    }
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    //Solution 1 high SC O(n) high TC
    static int sum;
    static HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        sum = 0;
        map = new HashMap<>();
        for(Employee emp: employees){
            map.put(emp.id,emp);
        }
        dfs(map.get(id));
        return sum + map.get(id).importance;
    }
    public void dfs(Employee employ){
        for(int e :employ.subordinates){
            sum+= map.get(e).importance;
            dfs(map.get(e));
        }
    }



    //Solution 2 Low O(1) SC high TC
    public int getImportance1(List<Employee> employees, int id) {
        sum = 0;
        for(Employee emp: employees){
            if(emp.id == id){
                sum+=emp.importance;
                dfs(emp, employees);
            }
        }
        return sum;
    }
    public void dfs(Employee employ, List<Employee> employees){
        for(int e :employ.subordinates){
            for(Employee emp : employees){
                if(e == emp.id){
                    sum+= emp.importance;
                    dfs(emp,employees);
                }
            }
        }
    }
}
